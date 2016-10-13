package com.tudelft.sdm.service;


import com.tudelft.sdm.persistance.Client;
import com.tudelft.sdm.persistance.KeyTypeEnumeration;
import io.swagger.model.ModelApiClient;

import java.util.List;

public interface ClientService {

    Client find(int id, String key, KeyTypeEnumeration keyType);
    Client create(ModelApiClient apiClient, String key, KeyTypeEnumeration keyType);
    Void update(int id, ModelApiClient apiClient, String key, KeyTypeEnumeration keyType);
    Void delete(int id, String key, KeyTypeEnumeration keyType);

    List<Client> getAll(String key, KeyTypeEnumeration keyType);
    //TODO search specifieke methoden hier declareren
}
