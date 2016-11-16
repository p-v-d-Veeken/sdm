package com.tudelft.sdm.service;


import com.tudelft.sdm.persistence.Client;
import io.swagger.model.KeyringData;
import io.swagger.model.ModelApiClient;

import java.util.List;

public interface ClientService {

    Client find(int id, KeyringData keyring);
    Void create(ModelApiClient apiClient, KeyringData keyring);
    Void update(int id, ModelApiClient apiClient, KeyringData keyring);
    Void delete(int id, KeyringData keyring);

    List<Client> getAll(KeyringData keyring);
    //TODO search specifieke methoden hier declareren
}
