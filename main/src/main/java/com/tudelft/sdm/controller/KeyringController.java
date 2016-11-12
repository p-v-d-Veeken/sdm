package com.tudelft.sdm.controller;

import com.tudelft.sdm.controller.core.ExceptionController;
import io.swagger.annotations.ApiParam;
import io.swagger.api.KeyringApi;
import io.swagger.model.ApiRetrievalAnswer;
import io.swagger.model.ApiRetrievalResponse;
import io.swagger.model.Keyring;
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
    public ResponseEntity<Void> keyringPost(@ApiParam(value = "", required = true) @RequestBody KeyringData keyringData) {
        // TODO verify call and store new keyring
        return null;
    }

    @Override
    public ResponseEntity<ApiRetrievalResponse> keyringRetrieve1Get(@ApiParam(value = "", required = true) @RequestBody ApiRetrievalAnswer answer) {
        // TODO Verify first answer
        return null;
    }

    @Override
    public ResponseEntity<ApiRetrievalAnswer> keyringRetrieve2Get(@ApiParam(value = "", required = true) @RequestBody ApiRetrievalResponse answer) {
        // TODO verify second answer
        return null;
    }

    @Override
    public ResponseEntity<Keyring> keyringRetrieve3Get(@ApiParam(value = "Answer to the current step", required = true) @RequestParam(value = "answer", required = true) String answer, @ApiParam(value = "The hashed answer to the previous step", required = true) @RequestParam(value = "previous", required = true) String previous) {
        // TODO generate AES key from the answer and return the decrypted keyring bundle
        return null;
    }
}
