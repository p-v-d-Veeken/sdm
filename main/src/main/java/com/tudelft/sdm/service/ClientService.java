package com.tudelft.sdm.service;


import com.tudelft.sdm.persistence.Client;
import io.swagger.model.Keyring;
import io.swagger.model.ModelApiClient;

import java.util.List;

public interface ClientService {

    Client find(int id, Keyring keyring);
    Void create(ModelApiClient apiClient, Keyring keyring);
    Void update(int id, ModelApiClient apiClient, Keyring keyring);
    Void delete(int id, Keyring keyring);

    List<Client> getAll(Keyring keyring);
    //TODO search specifieke methoden hier declareren
}
