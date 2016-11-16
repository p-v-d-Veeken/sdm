package com.tudelft.sdm.controller;

import com.tudelft.sdm.controller.core.ExceptionController;
import com.tudelft.sdm.persistence.Client;
import com.tudelft.sdm.service.ClientService;
import com.tudelft.sdm.service.RecordService;
import io.swagger.annotations.ApiParam;
import io.swagger.api.ClientsApi;
import io.swagger.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;


@CrossOrigin
@RestController
@SuppressWarnings("unchecked")
public class ClientController extends ExceptionController implements ClientsApi {

    private final ClientService clientService;
    private final RecordService recordService;

    @Autowired
    public ClientController(@Qualifier(value = "clientService") ClientService clientService, @Qualifier(value = "recordService") RecordService recordService) {
        this.clientService = clientService;
        this.recordService = recordService;
    }

    @Override
    public ResponseEntity<Void> clientsClientIdDelete(@ApiParam(value = "The ID of the client", required = true) @PathVariable("clientId") Integer clientId, @ApiParam(value = "", required = true) @RequestBody final Keyring keyring) {
        return handleExceptions(() -> clientService.delete(clientId, keyring));
    }

    @Override
    public ResponseEntity<ModelApiClient> clientsClientIdGet(@ApiParam(value = "The ID of the client", required = true) @PathVariable("clientId") Integer clientId, @ApiParam(value = "", required = true) @RequestBody Keyring keyring) {
        return handleExceptions(() -> clientService.find(clientId, keyring).cast());
    }

    @Override
    public ResponseEntity<Void> clientsClientIdPut(@ApiParam(value = "The ID of the client", required = true) @PathVariable("clientId") Integer clientId, @ApiParam(value = "", required = true) @RequestBody ClientBundle data) {
        return handleExceptions(() -> clientService.update(clientId, data.getClient(), data.getKeyring()));
    }

    @Override
    public ResponseEntity<List<ApiRecord>> clientsClientIdRecordsGet(@ApiParam(value = "The ID of the client", required = true) @PathVariable("clientId") Integer clientId, @ApiParam(value = "", required = true) @RequestBody QueryBundle data) {
        return handleExceptions(() -> recordService.find(data.getQuery(), data.getKeyring()));
    }

    @Override
    public ResponseEntity<ApiRecord> clientsClientIdRecordsPost(@ApiParam(value = "The ID of the client", required = true) @PathVariable("clientId") Integer clientId, @ApiParam(value = "", required = true) @RequestBody RecordBundle data) {
        return handleExceptions(() -> recordService.create(clientId, data.getRecord(), data.getKeyring()));
    }

    @Override
    public ResponseEntity<Void> clientsClientIdRecordsRecordIdDelete(@ApiParam(value = "The ID of the client", required = true) @PathVariable("clientId") Integer clientId, @ApiParam(value = "The ID of the client", required = true) @PathVariable("recordId") Integer recordId, @ApiParam(value = "", required = true) @RequestBody Keyring keyring) {
        return handleExceptions(() -> recordService.delete(recordId, clientId, keyring));
    }

    @Override
    public ResponseEntity<Void> clientsClientIdRecordsRecordIdPut(@ApiParam(value = "The ID of the client", required = true) @PathVariable("clientId") Integer clientId, @ApiParam(value = "The ID of the client", required = true) @PathVariable("recordId") Integer recordId, @ApiParam(value = "", required = true) @RequestBody RecordBundle data) {
        return handleExceptions(() -> recordService.update(recordId, clientId, data.getRecord(), data.getKeyring()));
    }

    @Override
    public ResponseEntity<List<ModelApiClient>> clientsGet(@ApiParam(value = "", required = true) @RequestBody Keyring keyring) {
        return handleExceptions(() -> clientService.getAll(keyring).parallelStream().map(Client::cast).collect(Collectors.toList()));
    }

    @Override
    public ResponseEntity<ClientBundle> clientsPost(@ApiParam(value = "", required = true) @RequestBody ClientBundle data) {
        return handleExceptions(() -> clientService.create(data.getClient(), data.getKeyring()));
    }
}
