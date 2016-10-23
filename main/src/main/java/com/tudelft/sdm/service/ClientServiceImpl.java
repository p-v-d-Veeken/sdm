package com.tudelft.sdm.service;

import com.tudelft.sdm.persistence.Client;
import com.tudelft.sdm.persistence.dao.ClientRepository;
import io.swagger.model.Keyring;
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
    public Client find(int id, Keyring keyring) {
        Client client = clientDao.findOne((long) id);
        if (client == null) {
            throw new NullPointerException();
        }
        return client;
    }

    @Override
    @Transactional
    public Void create(ModelApiClient apiClient, Keyring keyring) {
        Client client = new Client(apiClient);
        client.setCreatedAt(new Date());
        client.setUpdatedAt(new Date());
        clientDao.save(client);
        return null;
    }

    @Override
    @Transactional
    public Void update(int id, ModelApiClient apiClient, Keyring keyring) {
        Client client = this.find(id, keyring);
        client.merge(apiClient);
        client.setUpdatedAt(new Date());
        clientDao.save(client);
        return null;
    }

    @Override
    @Transactional
    public Void delete(int id, Keyring keyring) {
        Client client = this.find(id, keyring);
        clientDao.delete(client);
        return null;
    }

    @Override
    @Transactional
    public List<Client> getAll(Keyring keyring) {
        List<Client> target = new ArrayList<>();
        clientDao.findAll().forEach(target::add);
        return target;
    }
}
