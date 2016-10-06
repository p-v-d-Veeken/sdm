package com.tudelft.sdm.service;


import com.tudelft.sdm.persistance.Client;

import java.util.List;

public interface ClientService {

    Client find(int id);
    void create(Client client);
    void update(Client client);
    void delete(Client client);
    List<Client> getAll();
    //TODO search specifieke methoden hier declareren
}
