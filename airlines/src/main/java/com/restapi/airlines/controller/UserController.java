package com.restapi.airlines.controller;

import com.restapi.airlines.exception.UserNotFoundException;
import com.restapi.airlines.model.request.UserDetailsRequestModel;
import com.restapi.airlines.model.response.UserResponseModel;
import com.restapi.airlines.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;

@RestController
@RequestMapping("/Users")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping(path = "/{idUser}",
                produces = { MediaType.APPLICATION_JSON_VALUE,
                             MediaType.APPLICATION_XML_VALUE  })
    public ResponseEntity getUser(@PathVariable String idUser){
        UserResponseModel returnValue = userService.getUser(idUser);
        if (returnValue != null) {
            return new ResponseEntity<>(returnValue, HttpStatus.OK);
        } else {
            throw new UserNotFoundException();
        }
    }

    @GetMapping()
    public ResponseEntity getAllUser(){
        Collection returnValue = userService.getAllUser();
        return new ResponseEntity<>(returnValue, HttpStatus.OK);
    }

    @PostMapping(consumes = { MediaType.APPLICATION_XML_VALUE,
                              MediaType.APPLICATION_JSON_VALUE },
                 produces = { MediaType.APPLICATION_XML_VALUE,
                              MediaType.APPLICATION_JSON_VALUE }
    )
    public ResponseEntity createUser(@Valid @RequestBody UserDetailsRequestModel userDetails){
        UserResponseModel returnValue = userService.createUser(userDetails);
        return new ResponseEntity<>(returnValue, HttpStatus.CREATED);
    }

    @PutMapping(path = "/{idUser}",
                consumes = { MediaType.APPLICATION_XML_VALUE,
                             MediaType.APPLICATION_JSON_VALUE },
                produces = { MediaType.APPLICATION_XML_VALUE,
                             MediaType.APPLICATION_JSON_VALUE }
    )
    public ResponseEntity<UserResponseModel> updatePhoneNumUser(@PathVariable String idUser, @Valid @RequestBody UserDetailsRequestModel userDetails){
        UserResponseModel returnValue = userService.updatePhoneNumUser(idUser, userDetails);
        if (returnValue != null) {
            return new ResponseEntity<>(returnValue, HttpStatus.OK);
        } else {
            throw new UserNotFoundException("Update Failed, User Not Found");
        }
    }

    @DeleteMapping(path = "/{idUser}")
    public ResponseEntity deleteUser(@PathVariable String idUser){
        UserResponseModel returnValue = userService.deleteUser(idUser);
        if (returnValue != null) {
            return new ResponseEntity<>(returnValue, HttpStatus.OK);
        } else {
            throw new UserNotFoundException("Delete Failed, User Not Found");
        }
    }
}