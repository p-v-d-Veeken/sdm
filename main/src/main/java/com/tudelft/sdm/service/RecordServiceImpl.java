package com.tudelft.sdm.service;

import com.tudelft.sdm.persistence.Client;
import com.tudelft.sdm.persistence.enumerations.KeyTypeEnumeration;
import com.tudelft.sdm.persistence.Record;
import com.tudelft.sdm.persistence.dao.RecordRepository;
import io.swagger.model.ApiRecord;
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

    public Record find(int recordId, int clientId, String key, KeyTypeEnumeration keyType) {
        Record record = recordDao.findByIdAndClientId((long) recordId, (long) clientId);
        if (record == null) {
            throw new NullPointerException();
        }
        return record;
    }

    @Override
    public Void create(int clientId, ApiRecord apiRecord, String key, KeyTypeEnumeration keyType) {
        Client client = clientService.find(clientId, key, keyType);
        Record record = new Record(apiRecord);
        record.setCreatedAt(new Date());
        record.setUpdatedAt(new Date());
        record.setClient(client);
        recordDao.save(record);
        return null;
    }

    @Override
    public Void update(int recordId, int clientId, ApiRecord apiRecord, String key, KeyTypeEnumeration keyType) {
        Record record = this.find(recordId, clientId, key, keyType);
        record.merge(apiRecord);
        record.setUpdatedAt(new Date());
        recordDao.save(record);
        return null;
    }

    @Override
    public Void delete(int recordId, int clientId, String key, KeyTypeEnumeration keyType) {
        Record record = this.find(recordId, clientId, key, keyType);
        recordDao.delete(record);
        return null;
    }

    @Override
    public List<Record> getAll(int clientId, String key, KeyTypeEnumeration keyType) {
        Client client = clientService.find(clientId, key, keyType);
        return recordDao.findByClientId((long) clientId);
    }

    @Override
    public List<Record> find(int clientId, List<Query> query, String key, KeyTypeEnumeration keyType) {
        Client client = clientService.find(clientId, key, keyType);
        // TODO filter records
        return client.getRecords();
    }
}
