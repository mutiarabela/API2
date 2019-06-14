package com.restapi.airlines.controller;

import com.restapi.airlines.model.request.TransactionRequestModel;
import com.restapi.airlines.model.response.AllTransactionResponseModel;
import com.restapi.airlines.model.response.TransactionResponseModel;
import com.restapi.airlines.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/Transactions")
public class TransactionController {

    @Autowired
    TransactionService transactionService;

    @PostMapping(consumes = { MediaType.APPLICATION_XML_VALUE,
                              MediaType.APPLICATION_JSON_VALUE },
                 produces = { MediaType.APPLICATION_XML_VALUE,
                              MediaType.APPLICATION_JSON_VALUE }
    )
    public ResponseEntity createTransaction(@Valid @RequestBody TransactionRequestModel transactionRequestModel){
        TransactionResponseModel returnValue = transactionService.createTransaction(transactionRequestModel);
        return new ResponseEntity<>(returnValue, HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity getAllTransaction(){
        AllTransactionResponseModel returnValue = transactionService.getAllTransaction();
        return new ResponseEntity<>(returnValue, HttpStatus.OK);
    }
}
