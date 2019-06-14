package com.restapi.airlines.controller;

import com.restapi.airlines.exception.AirlineNotFoundException;
import com.restapi.airlines.model.request.AirlineDetailsRequestModel;
import com.restapi.airlines.model.response.AirlineResponseModel;
import com.restapi.airlines.service.AirlineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;

@RestController
@RequestMapping("/Airlines")
public class AirlineController {

    @Autowired
    AirlineService airlineService;

    @GetMapping(path = "/{idAirline}",
                produces = { MediaType.APPLICATION_JSON_VALUE,
                             MediaType.APPLICATION_XML_VALUE  })
    public ResponseEntity getAirline(@PathVariable String idAirline){
        AirlineResponseModel returnValue = airlineService.getAirline(idAirline);
        if (returnValue != null) {
            return new ResponseEntity<>(returnValue, HttpStatus.OK);
        } else {
            throw new AirlineNotFoundException();
        }
    }

    @GetMapping()
    public ResponseEntity getAllAirline(){
        Collection returnValue = airlineService.getAllAirline();
        return new ResponseEntity<>(returnValue, HttpStatus.OK);
    }

    @PostMapping(consumes = { MediaType.APPLICATION_XML_VALUE,
            MediaType.APPLICATION_JSON_VALUE },
            produces = { MediaType.APPLICATION_XML_VALUE,
                    MediaType.APPLICATION_JSON_VALUE }
    )
    public ResponseEntity createAirline(@Valid @RequestBody AirlineDetailsRequestModel airlineDetails){
        AirlineResponseModel returnValue = airlineService.createAirline(airlineDetails);
        return new ResponseEntity<>(returnValue, HttpStatus.CREATED);
    }

    @PutMapping(path = "/{idAirline}",
                consumes = { MediaType.APPLICATION_XML_VALUE,
                             MediaType.APPLICATION_JSON_VALUE },
                produces = { MediaType.APPLICATION_XML_VALUE,
                             MediaType.APPLICATION_JSON_VALUE }
    )
    public ResponseEntity<AirlineResponseModel> updatePriceAirline(@PathVariable String idAirline, @Valid @RequestBody AirlineDetailsRequestModel airlineDetails){
        AirlineResponseModel returnValue = airlineService.updatePriceAirline(idAirline, airlineDetails);
        if (returnValue != null) {
            return new ResponseEntity<>(returnValue, HttpStatus.OK);
        } else {
            throw new AirlineNotFoundException("Update Airline Failed, Airline Not Found");
        }
    }

    @DeleteMapping(path = "/{idAirline}")
    public ResponseEntity deleteAirline(@PathVariable String idAirline){
        AirlineResponseModel returnValue = airlineService.deleteAirline(idAirline);
        if (returnValue != null) {
            return new ResponseEntity<>(returnValue, HttpStatus.OK);
        } else {
            throw new AirlineNotFoundException("Delete Airline Failed, Airline Not Found");
        }
    }
}
