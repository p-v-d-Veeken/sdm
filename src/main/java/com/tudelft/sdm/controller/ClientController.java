package com.tudelft.sdm.controller;

import com.tudelft.sdm.persistance.Client;
import com.tudelft.sdm.persistance.Record;
import com.tudelft.sdm.service.ClientService;
import com.tudelft.sdm.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.ResourceAccessException;

import java.util.List;

@RestController
@RequestMapping("/clients")
public class ClientController {

    private ClientService clientService;
    private RecordService recordService;

    @Autowired
    @Qualifier(value="clientService")
    public void setClientService(ClientService clientService){
        this.clientService = clientService;
    }

    @Autowired
    @Qualifier(value="recordService")
    public void setRecordService(RecordService recordService){
        this.recordService = recordService;
    }

    @ResponseBody
    @RequestMapping(value = "/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Client> getClients() {
        return clientService.getAll();
    }

    @ResponseBody
    @RequestMapping(value = "/", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createClient(@RequestBody Client client) {
        clientService.create(client);
    }

    @ResponseBody
    @RequestMapping(value = "/{clientId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Client getClient(@PathVariable(name = "clientId") int clientId) {
        return clientService.find(clientId);
    }

    @ResponseBody
    @RequestMapping(value = "/{clientId}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateClient(@PathVariable(name = "clientId") int clientId, @RequestBody Client client) {
        Client dbClient = clientService.find(clientId);
        if (dbClient == null) {
            throw new ResourceAccessException("Client not found");
        }
        dbClient.merge(client);
        clientService.update(dbClient);
    }

    @ResponseBody
    @RequestMapping(value = "/{clientId}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public void deleteClient(@PathVariable(name = "clientId") int clientId) {
        Client client = clientService.find(clientId);
        if (client == null) {
            throw new ResourceAccessException("Client not found");
        }
        clientService.delete(client);
    }

    @ResponseBody
    @RequestMapping(value = "/{clientId}/records/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Record> getRecords(@PathVariable(name = "clientId") int clientId) {
        Client client = clientService.find(clientId);
        if (client == null) {
            throw new ResourceAccessException("Client not found");
        }
        return recordService.getAll(client);
    }

    @ResponseBody
    @RequestMapping(value = "/{clientId}/records/", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createRecord(@PathVariable(name = "clientId") int clientId, @RequestBody Record record) {
        Client client = clientService.find(clientId);
        if (client == null) {
            throw new ResourceAccessException("Client not found");
        }
        recordService.create(record, client);
    }

    @ResponseBody
    @RequestMapping(value = "/{clientId}/records/{recordId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Record getRecord(@PathVariable(name = "clientId") int clientId, @PathVariable(name = "recordId") int recordId) {
        Client client = clientService.find(clientId);
        if (client == null) {
            throw new ResourceAccessException("Client not found");
        }
        return recordService.find(recordId, client);
    }

    @ResponseBody
    @RequestMapping(value = "/{clientId}/records/{recordId}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateRecord(@PathVariable(name = "clientId") int clientId, @PathVariable(name = "recordId") int recordId, @RequestBody Record record) {
        Client client = clientService.find(clientId);
        if (client == null) {
            throw new ResourceAccessException("Client not found");
        }
        Record dbRecord = recordService.find(recordId, client);
        if (dbRecord == null) {
            throw new ResourceAccessException("Record not found");
        }
        dbRecord.merge(record);
        recordService.update(dbRecord, client);
    }

    @ResponseBody
    @RequestMapping(value = "/{clientId}/records/{recordId}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public void deleteRecord(@PathVariable(name = "clientId") int clientId, @PathVariable(name = "recordId") int recordId) {
        Client client = clientService.find(clientId);
        if (client == null) {
            throw new ResourceAccessException("Client not found");
        }
        Record record = recordService.find(recordId, client);
        if (record == null) {
            throw new ResourceAccessException("Record not found");
        }
        recordService.delete(record, client);
    }
}
