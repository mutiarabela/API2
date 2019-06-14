package com.restapi.airlines.service.implement;

import com.restapi.airlines.model.request.UserDetailsRequestModel;
import com.restapi.airlines.model.response.UserResponseModel;
import com.restapi.airlines.service.UserService;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;

@Service
public class UserServiceImplement implements UserService {
    UserResponseModel returnValue;

    HashMap<String, UserResponseModel> users;

    public UserServiceImplement(){
        UserResponseModel userResponseModel1 = new UserResponseModel();

        userResponseModel1.setIdUser("1");
        String idUser1 = userResponseModel1.getIdUser();

        userResponseModel1.setFirstNameUser("Mutiara");
        userResponseModel1.setLastNameUser("Bela");
        userResponseModel1.setPhoneNumUser("082111711170");
        userResponseModel1.setUserNameUser("mutiarabela");
        userResponseModel1.setEmailUser("bela@gmail.com");
        userResponseModel1.setPasswordUser("123456789");

        if(users == null){
            users = new HashMap<>();
        }

        users.put(idUser1, userResponseModel1);

        UserResponseModel userResponseModel2 = new UserResponseModel();

        userResponseModel2.setIdUser("2");
        String idUser2 = userResponseModel2.getIdUser();

        userResponseModel2.setFirstNameUser("Niall");
        userResponseModel2.setLastNameUser("Horan");
        userResponseModel2.setPhoneNumUser("0811212999970");
        userResponseModel2.setUserNameUser("niallhoran");
        userResponseModel2.setEmailUser("niall@gmail.com");
        userResponseModel2.setPasswordUser("11111111");

        users.put(idUser2, userResponseModel2);

        UserResponseModel userResponseModel3 = new UserResponseModel();

        userResponseModel3.setIdUser("3");
        String idUser3 = userResponseModel3.getIdUser();

        userResponseModel3.setFirstNameUser("Nur");
        userResponseModel3.setLastNameUser("Falah");
        userResponseModel3.setPhoneNumUser("081218077761");
        userResponseModel3.setUserNameUser("nurfalah");
        userResponseModel3.setEmailUser("falah@gmail.com");
        userResponseModel3.setPasswordUser("123123123");

        users.put(idUser3, userResponseModel3);
    }

    @Override
    public UserResponseModel createUser(UserDetailsRequestModel userDetails) {
        returnValue = new UserResponseModel();

        returnValue.setIdUser(userDetails.getIdUser());
        String idUser = returnValue.getIdUser();

        returnValue.setIdUser(userDetails.getIdUser());
        returnValue.setFirstNameUser(userDetails.getFirstNameUser());
        returnValue.setLastNameUser(userDetails.getLastNameUser());
        returnValue.setPhoneNumUser(userDetails.getPhoneNumUser());
        returnValue.setUserNameUser(userDetails.getUserNameUser());
        returnValue.setEmailUser(userDetails.getEmailUser());
        returnValue.setPasswordUser(userDetails.getPasswordUser());

        if (users == null) {
            users = new HashMap<>();
        }

        users.put(idUser, returnValue);
        return returnValue;
    }

    public UserResponseModel getUser (String idUser) {
        return users.get(idUser);
    }

    public Collection <UserResponseModel> getAllUser(){
        return users.values();
    }

    public UserResponseModel deleteUser(String idUser){
        return users.remove(idUser);
    }

    public UserResponseModel updatePhoneNumUser (String idUser, UserDetailsRequestModel userDetails) {
        if(users.containsKey(idUser)){
            UserResponseModel storedUser = users.get(idUser);
            storedUser.setPhoneNumUser(userDetails.getPhoneNumUser());

            users.put(idUser, storedUser);
        }
        return users.get(idUser);
    }
}
