package com.tudelft.sdm.service;

import com.tudelft.sdm.persistence.enumerations.KeyTypeEnumeration;
import com.tudelft.sdm.persistence.Record;
import io.swagger.model.ApiRecord;
import io.swagger.model.Query;

import java.util.List;

public interface RecordService {

    Void create(int clientId, ApiRecord apiRecord, String key, KeyTypeEnumeration keyType);
    Void update(int recordId, int clientId, ApiRecord apiRecord, String key, KeyTypeEnumeration keyType);
    Void delete(int recordId, int clientId, String key, KeyTypeEnumeration keyType);
    List<Record> getAll(int clientId, String key, KeyTypeEnumeration keyType);
    List<Record> find(int clientId, List<Query> query, String key, KeyTypeEnumeration keyType);
    //TODO search specifieke methoden hier declareren
}
