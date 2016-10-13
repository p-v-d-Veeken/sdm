package com.tudelft.sdm.controller.core;

import lombok.extern.log4j.Log4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Log4j
public class ExceptionController {
    protected interface Func<T> {
        T func() throws Exception;
    }

    protected ResponseEntity handleExceptions(Func proc) {
        try {
            return ResponseEntity.ok(proc.func());
        } catch (NullPointerException e) {
            log.error(e.getLocalizedMessage());
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            log.error(e.getLocalizedMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
