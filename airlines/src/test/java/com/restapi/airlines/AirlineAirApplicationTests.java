package com.restapi.airlines;

import com.restapi.airlines.controller.AirlineController;
import com.restapi.airlines.exception.AirlineNotFoundException;
import com.restapi.airlines.model.request.AirlineDetailsRequestModel;
import com.restapi.airlines.model.response.AirlineResponseModel;
import com.restapi.airlines.service.AirlineService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collection;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class AirlineAirApplicationTests {
    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @Autowired
    AirlineService airlineService;

    @Autowired
    AirlineController airlineController;

    @Test
    public void createAirline(){
        AirlineDetailsRequestModel airline = new AirlineDetailsRequestModel();
        airline.setIdAirline("1");
        airline.setNameAirline("Garuda");
        airline.setTypeAirline("Airplane");
        airline.setAirportOriginAirline("Soekarno Hatta");
        airline.setAirportDestinationAirline("Adi Soetjipto");
        airline.setDestinationAirline("Yogyakarta");
        airline.setPriceAirline(1250000.00);
        airline.setDiscountAirline(10);

        log.info("-------- Parameter that we POST [Airline] --------");
        log.info("idAirline="+airline.getIdAirline());
        log.info("nameAirline="+airline.getNameAirline());
        log.info("typeAirline="+airline.getTypeAirline());
        log.info("airportOriginAirline="+airline.getAirportOriginAirline());
        log.info("airportDestinationAirline="+airline.getAirportDestinationAirline());
        log.info("destinationAirline="+airline.getDestinationAirline());
        log.info("priceAirline="+airline.getPriceAirline());
        log.info("discountAirline="+airline.getDiscountAirline());

        AirlineResponseModel create = airlineService.createAirline(airline);

        assertThat(create.getIdAirline()).isEqualTo(airline.getIdAirline());
        assertThat(create.getNameAirline()).isEqualTo(airline.getNameAirline());
        assertThat(create.getTypeAirline()).isEqualTo(airline.getTypeAirline());
        assertThat(create.getAirportOriginAirline()).isEqualTo(airline.getAirportOriginAirline());
        assertThat(create.getAirportDestinationAirline()).isEqualTo(airline.getAirportDestinationAirline());
        assertThat(create.getDestinationAirline()).isEqualTo(airline.getDestinationAirline());
        assertThat(create.getPriceAirline()).isEqualTo(airline.getPriceAirline());
        assertThat(create.getDiscountAirline()).isEqualTo(airline.getDiscountAirline());

        log.info("----------- Posted Parameter [Airline] -----------");
        log.info(create.toString());
    }

    @Test
    public void getAirline() {

        createAirline();
        log.info("");

        String idAirline  = "1";
        log.info("GET idAirline=1");

        AirlineResponseModel result = airlineService.getAirline(idAirline);
        assertThat(result.getIdAirline()).isEqualTo("1");
        assertThat(result.getNameAirline()).isEqualTo("Garuda");
        assertThat(result.getTypeAirline()).isEqualTo("Airplane");
        assertThat(result.getAirportOriginAirline()).isEqualTo("Soekarno Hatta");
        assertThat(result.getAirportDestinationAirline()).isEqualTo("Adi Soetjipto");
        assertThat(result.getDestinationAirline()).isEqualTo("Yogyakarta");
        assertThat(result.getPriceAirline()).isEqualTo(1250000.00);
        assertThat(result.getDiscountAirline()).isEqualTo(10);

        log.info("-------- Parameter that we GET [Airline] --------");
        log.info(result.toString());
    }

    @Test
    public void getAllAirline(){
        createAirline();

        Collection getCreatedAirlines = airlineService.getAllAirline();
        assertThat(getCreatedAirlines.size()).isEqualTo(3);

        log.info("------ Get All Airlines Success ------");
    }

    @Test
    public void updatePriceAirline(){
        createAirline();

        log.info("Update priceAirline=1150000.00 for idAirline=1");

        String idAirline = "1";
        AirlineResponseModel airlineResponseModel = airlineService.getAirline(idAirline);
        String updatedIdAirline = airlineResponseModel.getIdAirline();
        double updatedPriceAirline = airlineResponseModel.getPriceAirline();
        String updatedNameAirline = airlineResponseModel.getNameAirline();
        String updatedTypeAirline = airlineResponseModel.getTypeAirline();
        String updatedAirportOriginAirline = airlineResponseModel.getAirportOriginAirline();
        String updatedAirportDestinationAirline = airlineResponseModel.getAirportDestinationAirline();
        String updatedDestinationAirline = airlineResponseModel.getDestinationAirline();
        double updatedDiscountAirline = airlineResponseModel.getDiscountAirline();

        AirlineDetailsRequestModel airlineDetailsRequestModel = new AirlineDetailsRequestModel();
        AirlineResponseModel updatedAirline = airlineService.updatePriceAirline(idAirline, airlineDetailsRequestModel);

        updatedAirline.setPriceAirline(1150000.00);

        log.info("------------- Posted Parameter------------- ");
        log.info(updatedAirline.toString());

        log.info("------------- Compared Parameter------------- ");
        log.info(" idAirline="                 + updatedIdAirline                 + " nameAirline="          + updatedNameAirline +
                 " typeAirline="               + updatedTypeAirline               + " airportOriginAirline=" + updatedAirportOriginAirline +
                 " airportDestinationAirline=" + updatedAirportDestinationAirline + " destinationAirline="   + updatedDestinationAirline +
                 " priceAirline="              + updatedPriceAirline              + " discountAirline="      + updatedDiscountAirline);

        assertThat(updatedAirline.getIdAirline()).isEqualTo(updatedIdAirline);
        assertThat(updatedAirline.getPriceAirline()).isNotEqualTo(updatedPriceAirline);
    }

    @Test
    public void deleteAirline(){
        createAirline();

        AirlineResponseModel getCreatedAirline = airlineService.getAirline("1");
        String idAirline = getCreatedAirline.getIdAirline();

        log.info("------ Airline ID that we created is = " + idAirline + " ------");
        log.info("--------------- Delete Airline for idAirline=1 ----------------");

        airlineService.deleteAirline(idAirline);
        assertThat(airlineService.getAirline(idAirline)).isNull();

        log.info("------------------- Delete Airline Success -------------------");
    }

    @Test(expected = AirlineNotFoundException.class)
    public  void AirlineNotFoundExceptionGet(){
        createAirline();
        String idAirline = "5";
        ResponseEntity create = airlineController.getAirline(idAirline);
        log.info(create.toString());
    }

    @Test
    public void deleteNotFound(){
        exceptionRule.expect(AirlineNotFoundException.class);
        exceptionRule.expectMessage("Delete Airline Failed, Airline Not Found");

        String idAirline = "9";

        ResponseEntity deleteUser = airlineController.deleteAirline(idAirline);

    }

    @Test
    public void getAirlineCont() {

        createAirline();
        log.info("");

        String idAirline  = "1";
        log.info("GET idAirline=1");

        ResponseEntity getAirline = airlineController.getAirline(idAirline);
        String status = "200 OK";
        assertThat(getAirline.getStatusCode().toString()).isEqualTo(status);

    }

    @Test
    public void getAllAirlineCont(){
        createAirline();

        ResponseEntity getAllAirline = airlineController.getAllAirline();
        assertThat(getAllAirline.toString()).contains("Garuda");
    }

}
