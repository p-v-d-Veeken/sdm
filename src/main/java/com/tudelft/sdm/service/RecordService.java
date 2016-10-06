package com.tudelft.sdm.service;

import com.tudelft.sdm.persistance.Client;
import com.tudelft.sdm.persistance.KeyTypeEnumeration;
import com.tudelft.sdm.persistance.Record;

import java.util.List;

public interface RecordService {

    Record find(int id, Client client, String key, KeyTypeEnumeration keyType);
    void create(Record record, Client client, String key, KeyTypeEnumeration keyType);
    void update(Record record, Client client, String key, KeyTypeEnumeration keyType);
    void delete(Record record, Client client, String key, KeyTypeEnumeration keyType);
    List<Record> getAll(Client client, String key, KeyTypeEnumeration keyType);
    //TODO search specifieke methoden hier declareren
}
