package com.tudelft.sdm.service;

import com.tudelft.sdm.persistence.Client;
import com.tudelft.sdm.persistence.Record;
import com.tudelft.sdm.persistence.dao.RecordRepository;
import io.swagger.model.ApiRecord;
import io.swagger.model.KeyringData;
import io.swagger.model.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service(value = "recordService")
public class RecordServiceImpl implements RecordService {

    private RecordRepository recordDao;
    private ClientService clientService;

    @Autowired
    public void setRecordDao(RecordRepository recordDao, ClientService clientService) {
        this.recordDao = recordDao;
        this.clientService = clientService;
    }

    public Record find(int recordId, int clientId, KeyringData keyring) {
        Record record = recordDao.findByIdAndClientId((long) recordId, (long) clientId);
        if (record == null) {
            throw new NullPointerException();
        }
        return record;
    }

    @Override
    public Void create(int clientId, ApiRecord apiRecord, KeyringData keyring) {
        Client client = clientService.find(clientId, keyring);
        Record record = new Record(apiRecord);
        record.setCreatedAt(new Date());
        record.setUpdatedAt(new Date());
        record.setClient(client);
        recordDao.save(record);
        return null;
    }

    @Override
    public Void update(int recordId, int clientId, ApiRecord apiRecord, KeyringData keyring) {
        Record record = this.find(recordId, clientId, keyring);
        record.merge(apiRecord);
        record.setUpdatedAt(new Date());
        recordDao.save(record);
        return null;
    }

    @Override
    public Void delete(int recordId, int clientId, KeyringData keyring) {
        Record record = this.find(recordId, clientId, keyring);
        recordDao.delete(record);
        return null;
    }

    @Override
    public List<Record> find(int clientId, List<Query> query, KeyringData keyring) {
        Client client = clientService.find(clientId, keyring);
        // TODO filter records
        return client.getRecords();
    }
}
