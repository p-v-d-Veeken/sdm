package com.tudelft.sdm.service;

import com.tudelft.sdm.persistance.Client;
import com.tudelft.sdm.persistance.Record;

import java.util.List;

public interface RecordService {

    Record find(int id, Client client);
    void create(Record record, Client client);
    void update(Record record, Client client);
    void delete(Record record, Client client);
    List<Record> getAll(Client client);
    //TODO search specifieke methoden hier declareren
}
