package com.restapi.airlines.model.response;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class TransactionResponseModel {

    private String firstNameUser;
    private String lastNameUser;
    private String phoneNumUser;
    private String emailUser;
    private String nameAirline;
    private String destinationAirline;
    private String airportOriginAirline;
    private String airportDestinationAirline;
    private double priceAirline;
    private double discountAirline;
    private double totPriceAirline;
}
