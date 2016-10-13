package com.tudelft.sdm.service;

import com.tudelft.sdm.persistance.KeyTypeEnumeration;
import com.tudelft.sdm.persistance.Record;
import io.swagger.model.ApiRecord;

import java.util.List;

public interface RecordService {

    Record find(int recordId, int clientId, String key, KeyTypeEnumeration keyType);
    Record create(int clientId, ApiRecord apiRecord, String key, KeyTypeEnumeration keyType);
    Void update(int recordId, int clientId, ApiRecord apiRecord, String key, KeyTypeEnumeration keyType);
    Void delete(int recordId, int clientId, String key, KeyTypeEnumeration keyType);
    List<Record> getAll(int clientId, String key, KeyTypeEnumeration keyType);
    //TODO search specifieke methoden hier declareren
}
