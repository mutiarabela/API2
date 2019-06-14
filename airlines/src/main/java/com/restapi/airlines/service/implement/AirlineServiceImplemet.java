package com.restapi.airlines.service.implement;

import com.restapi.airlines.model.request.AirlineDetailsRequestModel;
import com.restapi.airlines.model.response.AirlineResponseModel;
import com.restapi.airlines.service.AirlineService;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;

@Service
public class AirlineServiceImplemet implements AirlineService {
    AirlineResponseModel returnValue;

    HashMap<String, AirlineResponseModel> airlines;

    public AirlineServiceImplemet(){
        AirlineResponseModel airlineResponseModel1 = new AirlineResponseModel();

        airlineResponseModel1.setIdAirline("1");
        String idAirline1 = airlineResponseModel1.getIdAirline();

        airlineResponseModel1.setNameAirline("Garuda");
        airlineResponseModel1.setTypeAirline("Boeing G1");
        airlineResponseModel1.setAirportOriginAirline("Seokarno Hatta");
        airlineResponseModel1.setAirportDestinationAirline("Adi Soetjipto");
        airlineResponseModel1.setDestinationAirline("Yogyakarta");
        airlineResponseModel1.setPriceAirline(1550000.00);
        airlineResponseModel1.setDiscountAirline(10);

        if(airlines == null){
            airlines = new HashMap<>();
        }

        airlines.put(idAirline1, airlineResponseModel1);

        AirlineResponseModel airlineResponseModel2 = new AirlineResponseModel();

        airlineResponseModel2.setIdAirline("2");
        String idAirline2 = airlineResponseModel2.getIdAirline();

        airlineResponseModel2.setNameAirline("Citilink");
        airlineResponseModel2.setTypeAirline("Boeing C1");
        airlineResponseModel2.setAirportOriginAirline("Halim Perdana Kusuma");
        airlineResponseModel2.setAirportDestinationAirline("Adi Soetjipto");
        airlineResponseModel2.setDestinationAirline("Yogyakarta");
        airlineResponseModel2.setPriceAirline(750000.00);
        airlineResponseModel2.setDiscountAirline(20);

        airlines.put(idAirline2, airlineResponseModel2);

        AirlineResponseModel airlineResponseModel3 = new AirlineResponseModel();

        airlineResponseModel3.setIdAirline("3");
        String idAirline3 = airlineResponseModel3.getIdAirline();

        airlineResponseModel3.setNameAirline("Citilink");
        airlineResponseModel3.setTypeAirline("Boeing C2");
        airlineResponseModel3.setAirportOriginAirline("Halim Perdana Kusuma");
        airlineResponseModel3.setAirportDestinationAirline("Juanda");
        airlineResponseModel3.setDestinationAirline("Surabaya");
        airlineResponseModel3.setPriceAirline(1050000.00);
        airlineResponseModel3.setDiscountAirline(30);

        airlines.put(idAirline3, airlineResponseModel3);

    }

    @Override
    public AirlineResponseModel createAirline(AirlineDetailsRequestModel airlineDetails) {
        returnValue = new AirlineResponseModel();

        returnValue.setIdAirline(airlineDetails.getIdAirline());
        String idAirline = returnValue.getIdAirline();

        returnValue.setIdAirline(airlineDetails.getIdAirline());
        returnValue.setNameAirline(airlineDetails.getNameAirline());
        returnValue.setTypeAirline(airlineDetails.getTypeAirline());
        returnValue.setDestinationAirline(airlineDetails.getDestinationAirline());
        returnValue.setAirportOriginAirline(airlineDetails.getAirportOriginAirline());
        returnValue.setAirportDestinationAirline(airlineDetails.getAirportDestinationAirline());
        returnValue.setDestinationAirline(airlineDetails.getDestinationAirline());
        returnValue.setPriceAirline(airlineDetails.getPriceAirline());
        returnValue.setDiscountAirline(airlineDetails.getDiscountAirline());

        if (airlines == null) {
            airlines = new HashMap<>();
        }

        airlines.put(idAirline, returnValue);
        return returnValue;
    }

    public AirlineResponseModel getAirline (String idAirline) {
        return airlines.get(idAirline);
    }

    public Collection<AirlineResponseModel> getAllAirline() {
        return airlines.values();
    }

    public AirlineResponseModel deleteAirline(String idAirline){ return airlines.remove(idAirline); }

    public AirlineResponseModel updatePriceAirline (String idAirline, AirlineDetailsRequestModel airlineDetails) {
        if(airlines.containsKey(idAirline)){
            AirlineResponseModel storedUser = airlines.get(idAirline);
            storedUser.setPriceAirline(airlineDetails.getPriceAirline());

            airlines.put(idAirline, storedUser);
        }
        return airlines.get(idAirline);
    }
}
