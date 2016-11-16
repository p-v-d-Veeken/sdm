package com.tudelft.sdm.service;

import com.tudelft.paillier.PaillierPrivateKey;
import com.tudelft.paillier.PaillierPrivateKeyRing;
import com.tudelft.sdm.persistence.Client;
import com.tudelft.sdm.persistence.Record;
import com.tudelft.sdm.persistence.dao.RecordRepository;
import com.tudelft.sdm.service.enumerations.ComparisonResult;
import io.swagger.model.ApiRecord;
import io.swagger.model.Keyring;
import io.swagger.model.Query;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.tuple.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.commons.codec.binary.Base64;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service(value = "recordService")
public class RecordServiceImpl implements RecordService
{
	
	private RecordRepository recordDao;
	private ClientService    clientService;
	
	@Autowired
	public void setRecordDao(RecordRepository recordDao, ClientService clientService)
	{
		this.recordDao = recordDao;
		this.clientService = clientService;
	}
	
	public Record find(int recordId, int clientId, Keyring keyring)
	{
		Record record = recordDao.findByIdAndClientId((long) recordId, (long) clientId);
		if (record == null)
		{
			throw new NullPointerException();
		}
		return record;
	}
	
	@Override
	public Void create(int clientId, ApiRecord apiRecord, Keyring keyring)
	{
		Client client = clientService.find(clientId, keyring);
		Record record = new Record(apiRecord);
		record.setCreatedAt(new Date());
		record.setUpdatedAt(new Date());
		record.setClient(client);
		recordDao.save(record);
		return null;
	}
	
	@Override
	public Void update(int recordId, int clientId, ApiRecord apiRecord, Keyring keyring)
	{
		Record record = this.find(recordId, clientId, keyring);
		record.merge(apiRecord);
		record.setUpdatedAt(new Date());
		recordDao.save(record);
		return null;
	}
	
	@Override
	public Void delete(int recordId, int clientId, Keyring keyring)
	{
		Record record = this.find(recordId, clientId, keyring);
		recordDao.delete(record);
		return null;
	}
	
	@Override
	public List<Record> find(List<Query> queries, Keyring keyring)
	{
		PaillierPrivateKeyRing skRing = new PaillierPrivateKeyRing(keyring.getKeyring(), null);
		
		return skRing.keys()
				.stream()
				.parallel()
				.map(userId ->
				{
					List<Integer> clientIds     = IntStream.of(userId).boxed().collect(Collectors.toList());
					Keyring       keyRingClient = new Keyring().keyring(skRing.slice(clientIds).toString());
					
					return clientService.find(userId, keyRingClient);
				})
				.flatMap(client -> client.getRecords()
						.stream()
						.parallel()
						.filter(record -> queries.stream()
								.parallel()
								.allMatch(query -> recordMatchesQuery(record, query, skRing.get(client.getId().intValue())))
						)
				)
				.collect(Collectors.toList());
	}
	
	private boolean recordMatchesQuery(Record record, Query query, PaillierPrivateKey sk)
	{
		return query.getColumn().equals(Query.ColumnEnum.KEY)
		       ? evaluateKeyQuery(record, query, sk)
		       : evaluateValueQuery(record, query, sk);
	}
	
	private boolean evaluateKeyQuery(Record record, Query query, PaillierPrivateKey sk)
	{
		List<BigInteger> recordKeys = Pattern.compile(" ").splitAsStream(record.getName())
				.map(str -> new BigInteger(Base64.decodeBase64(str)))
				.collect(Collectors.toList());
		List<BigInteger> queryValues = Pattern.compile(" ").splitAsStream(query.getValue())
				.map(str -> new BigInteger(Base64.decodeBase64(str)))
				.collect(Collectors.toList());
		
		if (query.getOperator().equals(Query.OperatorEnum.EQUAL))
		{
			if (recordKeys.size() != queryValues.size()) { return false; }
			
			return IntStream.range(0, recordKeys.size())
					.parallel()
					.allMatch(i -> CompareService
							.compare(recordKeys.get(i), queryValues.get(i), sk).equals(ComparisonResult.EQUAL)
					);
		}
		int windowSize = queryValues.size();
		
		if (windowSize > recordKeys.size()) { return false; }
		
		return IntStream.range(0, recordKeys.size())
				.parallel()
				.anyMatch(i ->
				{
					List<BigInteger> window = recordKeys.subList(i, windowSize);
					
					return IntStream.range(0, queryValues.size())
							.parallel()
							.allMatch(j -> CompareService
									.compare(queryValues.get(j), window.get(j), sk).equals(ComparisonResult.EQUAL)
							);
				});
	}
	
	private boolean evaluateValueQuery(Record record, Query query, PaillierPrivateKey sk)
	{
		BigInteger       recordValue = new BigInteger(Base64.decodeBase64(record.getValue()));
		BigInteger       queryValue  = new BigInteger(Base64.decodeBase64(query.getValue()));
		ComparisonResult res         = CompareService.compare(recordValue, queryValue, sk);
		
		switch (query.getOperator())
		{
			case LESS_THAN:
				return res.equals(ComparisonResult.SMALLER);
			case LESS_THAN_OR_EQUAL_TO:
				return res.equals(ComparisonResult.SMALLER) || res.equals(ComparisonResult.EQUAL);
			case EQUAL:
				return res.equals(ComparisonResult.EQUAL);
			case GREATER_THAN:
				return res.equals(ComparisonResult.GREATER);
			case GREATER_THAN_OR_EQUAL_TO:
				return res.equals(ComparisonResult.GREATER) || res.equals(ComparisonResult.EQUAL);
			default:
				throw new IllegalArgumentException();
		}
	}
}