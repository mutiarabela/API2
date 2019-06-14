package com.restapi.airlines.service;

import com.restapi.airlines.model.request.TransactionRequestModel;
import com.restapi.airlines.model.response.AllTransactionResponseModel;
import com.restapi.airlines.model.response.TransactionResponseModel;
import org.springframework.stereotype.Service;

@Service
public interface TransactionService {
    TransactionResponseModel createTransaction(TransactionRequestModel transactionRequestModel);
    AllTransactionResponseModel getAllTransaction();
}
