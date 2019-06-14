package com.restapi.airlines.service;

import com.restapi.airlines.model.request.AirlineDetailsRequestModel;
import com.restapi.airlines.model.response.AirlineResponseModel;

import java.util.Collection;

public interface AirlineService {
    AirlineResponseModel createAirline(AirlineDetailsRequestModel airlineDetails);
    AirlineResponseModel getAirline(String idAirline);
    Collection<AirlineResponseModel> getAllAirline();
    AirlineResponseModel updatePriceAirline(String idAirline, AirlineDetailsRequestModel airlineDetails);
    AirlineResponseModel deleteAirline(String airlineId);
}
