package com.restapi.airlines.service;

import com.restapi.airlines.model.request.UserDetailsRequestModel;
import com.restapi.airlines.model.response.UserResponseModel;

import java.util.Collection;

public interface UserService {
    UserResponseModel createUser(UserDetailsRequestModel userDetails);
    UserResponseModel getUser(String userId);
    Collection<UserResponseModel> getAllUser();
    UserResponseModel updatePhoneNumUser(String userId, UserDetailsRequestModel userDetails);
    UserResponseModel deleteUser(String userId);
}
