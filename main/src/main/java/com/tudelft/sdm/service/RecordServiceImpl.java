package com.tudelft.sdm.service;

import com.tudelft.sdm.persistance.Client;
import com.tudelft.sdm.persistance.KeyTypeEnumeration;
import com.tudelft.sdm.persistance.Record;
import com.tudelft.sdm.persistance.dao.ClientRepository;
import com.tudelft.sdm.persistance.dao.RecordRepository;
import io.swagger.model.ApiRecord;
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

    @Override
    public Record find(int recordId, int clientId, String key, KeyTypeEnumeration keyType) {
        Record record = recordDao.findByIdAndClientId((long) recordId, (long) clientId);
        if (record == null) {
            throw new NullPointerException();
        }
        return record;
    }

    @Override
    public Record create(int clientId, ApiRecord apiRecord, String key, KeyTypeEnumeration keyType) {
        Client client = clientService.find(clientId, key, keyType);
        Record record = new Record(apiRecord);
        record.setUpdated_at(new Date());
        record.setCreated_at(new Date());
        record.setClient(client);
        recordDao.save(record);
        return record;
    }

    @Override
    public Void update(int recordId, int clientId, ApiRecord apiRecord, String key, KeyTypeEnumeration keyType) {
        Record record = this.find(recordId, clientId, key, keyType);
        record.merge(apiRecord);
        record.setUpdated_at(new Date());
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
        return recordDao.findByClientId((long) clientId);
    }
}
