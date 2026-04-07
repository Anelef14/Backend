package com.Metafp.CiudadAlDia.service;

import com.Metafp.CiudadAlDia.dto.UserDto;

import java.util.List;

public interface UserService {
    UserDto save(UserDto userDto);
    UserDto findById(String id);
    void delete(String id);
    UserDto findByEmail(String email);
    List<UserDto> findBySubName(String subName);
    public UserDto update(String id, UserDto userDto);
}
