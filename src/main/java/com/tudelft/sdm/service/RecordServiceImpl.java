package com.tudelft.sdm.service;

import com.tudelft.sdm.persistance.Client;
import com.tudelft.sdm.persistance.KeyTypeEnumeration;
import com.tudelft.sdm.persistance.Record;
import com.tudelft.sdm.persistance.dao.RecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service(value = "recordService")
public class RecordServiceImpl implements RecordService {

    private RecordRepository recordDao;

    @Autowired
    public void setRecordDao(RecordRepository recordDao) {
        this.recordDao = recordDao;
    }

    @Override
    @Transactional
    public Record find(int id, Client client, String key, KeyTypeEnumeration keyType) {
        return recordDao.findByIdAndClientId((long) id, client.getId());
    }

    @Override
    @Transactional
    public void create(Record record, Client client, String key, KeyTypeEnumeration keyType) {
        record.setCreated_at(new Date());
        record.setUpdated_at(new Date());
        record.setClient(client);
        recordDao.save(record);
    }

    @Override
    @Transactional
    public void update(Record record, Client client, String key, KeyTypeEnumeration keyType) {
        Record dbRecord = recordDao.findByIdAndClientId(record.getId(), client.getId());
        dbRecord.merge(record);
        dbRecord.setUpdated_at(new Date());
        recordDao.save(dbRecord);
    }

    @Override
    @Transactional
    public void delete(Record record, Client client, String key, KeyTypeEnumeration keyType) {
        Record dbRecord = recordDao.findByIdAndClientId(record.getId(), client.getId());
        recordDao.delete(dbRecord);
    }

    @Override
    @Transactional
    public List<Record> getAll(Client client, String key, KeyTypeEnumeration keyType) {
        return recordDao.findByClientId(client.getId());
    }
}
