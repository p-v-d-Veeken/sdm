package com.tudelft.sdm.service;

import com.tudelft.sdm.persistance.Client;
import com.tudelft.sdm.persistance.KeyTypeEnumeration;
import com.tudelft.sdm.persistance.dao.ClientRepository;
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
        return clientDao.findOne((long) id);
    }

    @Override
    @Transactional
    public void create(Client client, String key, KeyTypeEnumeration keyType) {
        client.setUpdated_at(new Date());
        client.setCreated_at(new Date());
        clientDao.save(client);
    }

    @Override
    @Transactional
    public void update(Client client, String key, KeyTypeEnumeration keyType) {
        client.setUpdated_at(new Date());
        clientDao.save(client);
    }

    @Override
    @Transactional
    public void delete(Client client, String key, KeyTypeEnumeration keyType) {
        clientDao.delete(client);
    }

    @Override
    @Transactional
    public List<Client> getAll(String key, KeyTypeEnumeration keyType) {
        List<Client> target = new ArrayList<>();
        clientDao.findAll().forEach(target::add);
        return target;
    }
}
