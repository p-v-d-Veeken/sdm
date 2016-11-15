package com.tudelft.sdm.controller;

import com.tudelft.sdm.controller.core.ExceptionController;
import io.swagger.annotations.ApiParam;
import io.swagger.api.KeyringApi;
import io.swagger.model.ApiRetrievalAnswer;
import io.swagger.model.ApiRetrievalResponse;
import io.swagger.model.KeyringData;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@SuppressWarnings("unchecked")
public class KeyringController extends ExceptionController implements KeyringApi {

    @Override
    public ResponseEntity<Void> keyringPostPost(@ApiParam(value = "", required = true) @RequestBody KeyringData keyringData) {
        // TODO verify call and store new keyring
        return null;
    }

    @Override
    public ResponseEntity<ApiRetrievalResponse> keyringRetrieve1GetPost(@ApiParam(value = "", required = true) @RequestBody ApiRetrievalAnswer answer) {
        // TODO Verify first answer
        return null;
    }

    @Override
    public ResponseEntity<ApiRetrievalAnswer> keyringRetrieve2GetPost(@ApiParam(value = "", required = true) @RequestBody ApiRetrievalResponse answer) {
        // TODO verify second answer
        return null;
    }

    @Override
    public ResponseEntity<KeyringData> keyringRetrieve3GetPost(@ApiParam(value = "Answer to the current step", required = true) @RequestParam(value = "answer", required = true) String answer, @ApiParam(value = "The hashed answer to the previous step", required = true) @RequestParam(value = "previous", required = true) String previous) {
        // TODO verify third answer and return keyring
        return null;
    }
}
