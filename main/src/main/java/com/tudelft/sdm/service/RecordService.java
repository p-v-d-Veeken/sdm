package com.tudelft.sdm.service;

import io.swagger.model.ApiRecord;
import io.swagger.model.KeyringData;
import io.swagger.model.Query;

import java.util.List;

public interface RecordService {

    Void create(int clientId, ApiRecord apiRecord, KeyringData keyring);
    Void update(int recordId, int clientId, ApiRecord apiRecord, KeyringData keyring);
    Void delete(int recordId, int clientId, KeyringData keyring);
    List<ApiRecord> find(int clientId, List<Query> query, KeyringData keyring);
    //TODO search specifieke methoden hier declareren
}
