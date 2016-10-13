package com.tudelft.sdm.service;


import com.tudelft.sdm.persistence.Client;
import com.tudelft.sdm.persistence.KeyTypeEnumeration;

import java.util.List;

public interface ClientService {

    Client find(int id, String key, KeyTypeEnumeration keyType);
    void create(Client client, String key, KeyTypeEnumeration keyType);
    void update(Client client, String key, KeyTypeEnumeration keyType);
    void delete(Client client, String key, KeyTypeEnumeration keyType);
    List<Client> getAll(String key, KeyTypeEnumeration keyType);
    //TODO search specifieke methoden hier declareren
}
