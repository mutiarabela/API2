package com.restapi.airlines;

import com.restapi.airlines.controller.TransactionController;
import com.restapi.airlines.model.request.TransactionRequestModel;
import com.restapi.airlines.model.response.AllTransactionResponseModel;
import com.restapi.airlines.model.response.TransactionResponseModel;
import com.restapi.airlines.service.TransactionService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class TransactionAirApplicationTests {

    @Autowired
    TransactionService transactionService;

    @Autowired
    TransactionController transactionController;

    @Test
    public void createTransaction(){
        TransactionRequestModel getTransaction = new TransactionRequestModel();
        getTransaction.setIdUser("1");
        getTransaction.setIdAirline("1");
        getTransaction.setDestinationAirline("Yogyakarta");

        TransactionResponseModel responseTransaction = new TransactionResponseModel();
        responseTransaction.setFirstNameUser("Mutiara");
        responseTransaction.setLastNameUser("Bela");
        responseTransaction.setPhoneNumUser("082111711170");
        responseTransaction.setEmailUser("bela@gmail.com");
        responseTransaction.setNameAirline("Garuda");
        responseTransaction.setDestinationAirline("Yogyakarta");
        responseTransaction.setAirportOriginAirline("Soekarno Hatta");
        responseTransaction.setAirportDestinationAirline("Adi Soetjipto");
        responseTransaction.setPriceAirline(1250000.00);
        responseTransaction.setDiscountAirline(10);
        responseTransaction.setTotPriceAirline(1125000.00);

        log.info("-------- Parameter that we POST [Transaction] --------");
        log.info("idUser="+getTransaction.getIdUser());
        log.info("idAirline="+getTransaction.getIdAirline());
        log.info("destinationAirline="+getTransaction.getDestinationAirline());
        log.info("firstNameUser="+responseTransaction.getFirstNameUser());
        log.info("lastNameUser="+responseTransaction.getLastNameUser());
        log.info("phoneNumUser="+responseTransaction.getPhoneNumUser());
        log.info("emailUser="+responseTransaction.getEmailUser());
        log.info("nameAirline="+responseTransaction.getNameAirline());
        log.info("destinationAirline="+responseTransaction.getDestinationAirline());
        log.info("airportOriginAirline="+responseTransaction.getAirportOriginAirline());
        log.info("airportDestinationAirline="+responseTransaction.getAirportDestinationAirline());
        log.info("priceAirline="+responseTransaction.getPriceAirline());
        log.info("discountAirline="+responseTransaction.getDiscountAirline());
        log.info("totPriceAirline="+responseTransaction.getTotPriceAirline());

        TransactionResponseModel create = transactionService.createTransaction(getTransaction);

        assertThat(create.getFirstNameUser()).isEqualTo(responseTransaction.getFirstNameUser());
        assertThat(create.getLastNameUser()).isEqualTo(responseTransaction.getLastNameUser());
        assertThat(create.getPhoneNumUser()).isEqualTo(responseTransaction.getPhoneNumUser());
        assertThat(create.getEmailUser()).isEqualTo(responseTransaction.getEmailUser());
        assertThat(create.getNameAirline()).isEqualTo(responseTransaction.getNameAirline());
        assertThat(create.getDestinationAirline()).isEqualTo(responseTransaction.getDestinationAirline());
        assertThat(create.getAirportOriginAirline()).isEqualTo(responseTransaction.getAirportOriginAirline());
        assertThat(create.getAirportDestinationAirline()).isEqualTo(responseTransaction.getAirportDestinationAirline());
        assertThat(create.getPriceAirline()).isEqualTo(responseTransaction.getPriceAirline());
        assertThat(create.getDiscountAirline()).isEqualTo(responseTransaction.getDiscountAirline());
        assertThat(create.getTotPriceAirline()).isEqualTo(responseTransaction.getTotPriceAirline());

        log.info("----------- Posted Parameter [Transaction] -----------");
        log.info(create.toString());
    }

    @Test
    public void getAllTransaction(){
        createTransaction();

        AllTransactionResponseModel getAllTransaction = transactionService.getAllTransaction();
        assertThat(getAllTransaction.getTransaction().size()).isEqualTo(1);
        assertThat(getAllTransaction.getTotalTransaction()).isEqualTo(1125000.00);

    }

    @Test
    public void getAllTransactionCont(){
        createTransaction();

        ResponseEntity getAllAirline = transactionController.getAllTransaction();
        assertThat(getAllAirline.toString()).contains("200 OK");

    }

}
