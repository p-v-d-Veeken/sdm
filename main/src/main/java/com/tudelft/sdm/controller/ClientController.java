package com.tudelft.sdm.controller;

import com.tudelft.sdm.controller.core.ExceptionController;
import com.tudelft.sdm.persistance.Client;
import com.tudelft.sdm.persistance.KeyTypeEnumeration;
import com.tudelft.sdm.persistance.Record;
import com.tudelft.sdm.service.ClientService;
import com.tudelft.sdm.service.RecordService;
import io.swagger.annotations.ApiParam;
import io.swagger.api.ClientsApi;
import io.swagger.model.ApiRecord;
import io.swagger.model.ModelApiClient;
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
    public ResponseEntity<Void> clientsClientIdDelete(@ApiParam(value = "The ID of the client", required = true) @PathVariable("clientId") Integer clientId, @ApiParam(value = "The encruption key", required = true) @RequestHeader(value = "x-key", required = true) String xKey, @ApiParam(value = "The encryption key type", required = true) @RequestHeader(value = "x-key-type", required = true) String xKeyType) {
        return handleExceptions(() -> clientService.delete(clientId, xKey, KeyTypeEnumeration.valueOf(xKeyType)));
    }

    @Override
    public ResponseEntity<ModelApiClient> clientsClientIdGet(@ApiParam(value = "The ID of the client", required = true) @PathVariable("clientId") Integer clientId, @ApiParam(value = "The encruption key", required = true) @RequestHeader(value = "x-key", required = true) String xKey, @ApiParam(value = "The encryption key type", required = true) @RequestHeader(value = "x-key-type", required = true) String xKeyType) {
        return handleExceptions(() -> clientService.find(clientId, xKey, KeyTypeEnumeration.valueOf(xKeyType)).cast());
    }

    @Override
    public ResponseEntity<Void> clientsClientIdPut(@ApiParam(value = "The ID of the client", required = true) @PathVariable("clientId") Integer clientId, @ApiParam(value = "The encruption key", required = true) @RequestHeader(value = "x-key", required = true) String xKey, @ApiParam(value = "The encryption key type", required = true) @RequestHeader(value = "x-key-type", required = true) String xKeyType, @ApiParam(value = "", required = true) @RequestBody ModelApiClient client) {
        return handleExceptions(() -> clientService.update(clientId, client, xKey, KeyTypeEnumeration.valueOf(xKeyType)));
    }

    @Override
    public ResponseEntity<List<ApiRecord>> clientsClientIdRecordsGet(@ApiParam(value = "The ID of the client", required = true) @PathVariable("clientId") Integer clientId, @ApiParam(value = "The encruption key", required = true) @RequestHeader(value = "x-key", required = true) String xKey, @ApiParam(value = "The encryption key type", required = true) @RequestHeader(value = "x-key-type", required = true) String xKeyType) {
        return handleExceptions(() -> recordService.getAll(clientId , xKey, KeyTypeEnumeration.valueOf(xKeyType)).parallelStream().map(Record::cast).collect(Collectors.toList()));
    }

    @Override
    public ResponseEntity<ApiRecord> clientsClientIdRecordsPost(@ApiParam(value = "The ID of the client", required = true) @PathVariable("clientId") Integer clientId, @ApiParam(value = "The encruption key", required = true) @RequestHeader(value = "x-key", required = true) String xKey, @ApiParam(value = "The encryption key type", required = true) @RequestHeader(value = "x-key-type", required = true) String xKeyType, @ApiParam(value = "", required = true) @RequestBody ApiRecord record) {
        return handleExceptions(() -> recordService.create(clientId, record, xKey, KeyTypeEnumeration.valueOf(xKeyType)).cast());
    }

    @Override
    public ResponseEntity<Void> clientsClientIdRecordsRecordIdDelete(@ApiParam(value = "The ID of the client", required = true) @PathVariable("clientId") Integer clientId, @ApiParam(value = "The ID of the client", required = true) @PathVariable("recordId") Integer recordId, @ApiParam(value = "The encruption key", required = true) @RequestHeader(value = "x-key", required = true) String xKey, @ApiParam(value = "The encryption key type", required = true) @RequestHeader(value = "x-key-type", required = true) String xKeyType) {
        return handleExceptions(() -> recordService.delete(recordId, clientId, xKey, KeyTypeEnumeration.valueOf(xKeyType)));
    }

    @Override
    public ResponseEntity<ApiRecord> clientsClientIdRecordsRecordIdGet(@ApiParam(value = "The ID of the client", required = true) @PathVariable("clientId") Integer clientId, @ApiParam(value = "The ID of the client", required = true) @PathVariable("recordId") Integer recordId, @ApiParam(value = "The encruption key", required = true) @RequestHeader(value = "x-key", required = true) String xKey, @ApiParam(value = "The encryption key type", required = true) @RequestHeader(value = "x-key-type", required = true) String xKeyType) {
        return handleExceptions(() -> recordService.find(recordId, clientId, xKey, KeyTypeEnumeration.valueOf(xKeyType)).cast());
    }

    @Override
    public ResponseEntity<Void> clientsClientIdRecordsRecordIdPut(@ApiParam(value = "The ID of the client", required = true) @PathVariable("clientId") Integer clientId, @ApiParam(value = "The ID of the client", required = true) @PathVariable("recordId") Integer recordId, @ApiParam(value = "The encruption key", required = true) @RequestHeader(value = "x-key", required = true) String xKey, @ApiParam(value = "The encryption key type", required = true) @RequestHeader(value = "x-key-type", required = true) String xKeyType, @ApiParam(value = "", required = true) @RequestBody ApiRecord record) {
        return handleExceptions(() -> recordService.update(recordId, clientId, record, xKey, KeyTypeEnumeration.valueOf(xKeyType)));
    }

    @Override
    public ResponseEntity<List<ModelApiClient>> clientsGet(@ApiParam(value = "The encruption key", required = true) @RequestHeader(value = "x-key", required = true) String xKey, @ApiParam(value = "The encryption key type", required = true) @RequestHeader(value = "x-key-type", required = true) String xKeyType) {
        return handleExceptions(() -> clientService.getAll(xKey, KeyTypeEnumeration.valueOf(xKeyType)).parallelStream().map(Client::cast).collect(Collectors.toList()));
    }

    @Override
    public ResponseEntity<ModelApiClient> clientsPost(@ApiParam(value = "The encruption key", required = true) @RequestHeader(value = "x-key", required = true) String xKey, @ApiParam(value = "The encryption key type", required = true) @RequestHeader(value = "x-key-type", required = true) String xKeyType, @ApiParam(value = "", required = true) @RequestBody ModelApiClient client) {
        return handleExceptions(() -> clientService.create(client, xKey, KeyTypeEnumeration.valueOf(xKeyType)).cast());
    }
}
