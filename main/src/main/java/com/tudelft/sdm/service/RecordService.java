package com.tudelft.sdm.service;

import com.tudelft.sdm.persistence.Record;
import io.swagger.model.ApiRecord;
import io.swagger.model.Keyring;
import io.swagger.model.Query;

import java.util.List;

public interface RecordService {

    Void create(int clientId, ApiRecord apiRecord, Keyring keyring);
    Void update(int recordId, int clientId, ApiRecord apiRecord, Keyring keyring);
    Void delete(int recordId, int clientId, Keyring keyring);
    List<Record> find(int clientId, List<Query> query, Keyring keyring);
    //TODO search specifieke methoden hier declareren
}
