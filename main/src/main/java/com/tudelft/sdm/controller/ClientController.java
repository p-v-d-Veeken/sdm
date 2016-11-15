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
    public ResponseEntity<Void> clientsClientIdDeletePost(@ApiParam(value = "The ID of the client", required = true) @PathVariable("clientId") Integer clientId, @ApiParam(value = "", required = true) @RequestBody KeyringData keyringData) {
        return handleExceptions(() -> clientService.delete(clientId, keyringData));
    }

    @Override
    public ResponseEntity<ModelApiClient> clientsClientIdGetPost(@ApiParam(value = "The ID of the client", required = true) @PathVariable("clientId") Integer clientId, @ApiParam(value = "", required = true) @RequestBody KeyringData keyringData) {
        return handleExceptions(() -> clientService.find(clientId, keyringData).cast());
    }

    @Override
    public ResponseEntity<Void> clientsClientIdPutPost(@ApiParam(value = "The ID of the client", required = true) @PathVariable("clientId") Integer clientId, @ApiParam(value = "", required = true) @RequestBody ClientBundle data) {
        return handleExceptions(() -> clientService.update(clientId, data.getClient(), data.getKeyringData()));
    }

    @Override
    public ResponseEntity<List<ApiRecord>> clientsClientIdRecordsGetPost(@ApiParam(value = "The ID of the client", required = true) @PathVariable("clientId") Integer clientId, @ApiParam(value = "", required = true) @RequestBody QueryBundle data) {
        return handleExceptions(() -> recordService.find(clientId, data.getQuery(), data.getKeyringData()));
    }

    @Override
    public ResponseEntity<ApiRecord> clientsClientIdRecordsPostPost(@ApiParam(value = "The ID of the client", required = true) @PathVariable("clientId") Integer clientId, @ApiParam(value = "", required = true) @RequestBody RecordBundle data) {
        return handleExceptions(() -> recordService.create(clientId, data.getRecord(), data.getKeyringData()));
    }

    @Override
    public ResponseEntity<Void> clientsClientIdRecordsRecordIdDeletePost(@ApiParam(value = "The ID of the client", required = true) @PathVariable("clientId") Integer clientId, @ApiParam(value = "The ID of the client", required = true) @PathVariable("recordId") Integer recordId, @ApiParam(value = "", required = true) @RequestBody KeyringData keyringData) {
        return handleExceptions(() -> recordService.delete(recordId, clientId, keyringData));
    }

    @Override
    public ResponseEntity<Void> clientsClientIdRecordsRecordIdPutPost(@ApiParam(value = "The ID of the client", required = true) @PathVariable("clientId") Integer clientId, @ApiParam(value = "The ID of the client", required = true) @PathVariable("recordId") Integer recordId, @ApiParam(value = "", required = true) @RequestBody RecordBundle data) {
        return handleExceptions(() -> recordService.update(recordId, clientId, data.getRecord(), data.getKeyringData()));
    }

    @Override
    public ResponseEntity<List<ModelApiClient>> clientsGetPost(@ApiParam(value = "", required = true) @RequestBody KeyringData keyringData) {
        return ResponseEntity.ok(clientService.getAll(keyringData).parallelStream().map(Client::cast).collect(Collectors.toList()));
    }

    @Override
    public ResponseEntity<ClientBundle> clientsPostPost(@ApiParam(value = "", required = true) @RequestBody ClientBundle data) {
        return handleExceptions(() -> clientService.create(data.getClient(), data.getKeyringData()));
    }
}
