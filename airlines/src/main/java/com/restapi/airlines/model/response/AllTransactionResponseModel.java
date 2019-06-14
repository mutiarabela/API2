package com.restapi.airlines.model.response;

import lombok.Getter;
import lombok.Setter;

import java.util.Collection;

@Setter
@Getter
public class AllTransactionResponseModel {
    private Collection transaction;
    private double totalTransaction = 0.00;
}
