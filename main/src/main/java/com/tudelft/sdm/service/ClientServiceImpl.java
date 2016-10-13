package com.tudelft.sdm.service;

import com.tudelft.sdm.persistence.Client;
import com.tudelft.sdm.persistence.KeyTypeEnumeration;
import com.tudelft.sdm.persistence.dao.ClientRepository;
import io.swagger.model.ModelApiClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service(value = "clientService")
public class ClientServiceImpl implements ClientService{

    private final ClientRepository clientDao;

    @Autowired
    public ClientServiceImpl(ClientRepository clientDao) {
        this.clientDao = clientDao;
    }

    @Override
    @Transactional
    public Client find(int id, String key, KeyTypeEnumeration keyType) {
        Client client = clientDao.findOne((long) id);
        if (client == null) {
            throw new NullPointerException();
        }
        return client;
    }

    @Override
    @Transactional
    public Client create(ModelApiClient apiClient, String key, KeyTypeEnumeration keyType) {
        Client client = new Client(apiClient);
        client.setUpdated_at(new Date());
        client.setCreated_at(new Date());
        clientDao.save(client);
        return client;
    }

    @Override
    @Transactional
    public Void update(int id, ModelApiClient apiClient, String key, KeyTypeEnumeration keyType) {
        Client client = this.find(id, key, keyType);
        client.merge(apiClient);
        client.setUpdated_at(new Date());
        clientDao.save(client);
        return null;
    }

    @Override
    @Transactional
    public Void delete(int id, String key, KeyTypeEnumeration keyType) {
        Client client = this.find(id, key, keyType);
        clientDao.delete(client);
        return null;
    }

    @Override
    @Transactional
    public List<Client> getAll(String key, KeyTypeEnumeration keyType) {
        List<Client> target = new ArrayList<>();
        clientDao.findAll().forEach(target::add);
        return target;
    }
}
