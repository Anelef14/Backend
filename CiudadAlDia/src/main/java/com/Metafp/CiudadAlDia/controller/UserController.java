package com.Metafp.CiudadAlDia.controller;

import com.Metafp.CiudadAlDia.dto.UserDto;
import com.Metafp.CiudadAlDia.payload.ApiResponseMessage;
import com.Metafp.CiudadAlDia.service.serviceImpl.UserServiceImpl;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserController {
private final UserServiceImpl userService;

    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<ApiResponseMessage> create(@Valid @RequestBody UserDto userDto){
        UserDto save = userService.save(userDto);
        ApiResponseMessage apiResponseMessage = ApiResponseMessage.builder()
                .message("Successfully Created!")
                .status(HttpStatus.CREATED)
                .success(true)
                .data(save)
                .build();
        return new ResponseEntity<>(apiResponseMessage,HttpStatus.CREATED);
    }

//    //users/37483784389
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponseMessage> findById(@PathVariable String id) {
        UserDto byId = userService.findById(id);
        ApiResponseMessage apiResponseMessage = ApiResponseMessage.builder()
                .message("User Found")
                .status(HttpStatus.OK)
                .success(true)
                .data(byId)
                .build();
        return new ResponseEntity<>(apiResponseMessage, HttpStatus.OK);
    }
        @DeleteMapping("/{id}")
        public ResponseEntity<ApiResponseMessage> delete(@PathVariable String id) {
            userService.delete(id);
            ApiResponseMessage apiResponseMessage = ApiResponseMessage.builder()
                    .message("User Deleted")
                    .status(HttpStatus.OK)
                    .success(true)
                    .data(null)
                    .build();
            return new ResponseEntity<>(apiResponseMessage, HttpStatus.OK);
        }

        @GetMapping("email/{email}")
        public ResponseEntity<ApiResponseMessage> getUserByEmail(@PathVariable String email){
            UserDto byEmail = userService.findByEmail(email);
            ApiResponseMessage apiResponseMessage = ApiResponseMessage.builder()
                    .success(true)
                    .status(HttpStatus.OK)
                    .data(byEmail)
                    .message("User Found")
                    .build();

            return new ResponseEntity<>(apiResponseMessage,HttpStatus.OK);
        }

        @GetMapping("bySubName/{subName}")
        public ResponseEntity<List<UserDto>>  findAllBySubName(@PathVariable String subName){
            List<UserDto> bySubName = userService.findBySubName(subName);
            for(UserDto data:bySubName){
                System.out.println(data);
            }
            return new ResponseEntity<>(bySubName,HttpStatus.OK);
        }

        @PutMapping("/{id}")
        public ResponseEntity<ApiResponseMessage> update(@PathVariable String id,@RequestBody UserDto userDto){
            UserDto update = userService.update(id, userDto);

            ApiResponseMessage apiResponseMessage = ApiResponseMessage.builder()
                    .success(true)
                    .status(HttpStatus.OK)
                    .data(update)
                    .message("User Updated")
                    .build();
            return new ResponseEntity<>(apiResponseMessage,HttpStatus.OK);
        }

}
