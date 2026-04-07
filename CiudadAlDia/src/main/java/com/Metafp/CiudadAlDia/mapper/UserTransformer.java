package com.Metafp.CiudadAlDia.mapper;

import com.Metafp.CiudadAlDia.dto.UserDto;
import com.Metafp.CiudadAlDia.entity.User;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserTransformer implements Transformer<User, UserDto>{
    @Override
    public UserDto toDto(User entity) {
        UserDto userDto = new UserDto();
        userDto.setId(entity.getId());
        userDto.setDni(entity.getDni());
        userDto.setRole(entity.getRole());
        userDto.setNombre(entity.getNombre());
        userDto.setEmail(entity.getEmail());
        userDto.setPassword(entity.getPassword());
        return userDto;
    }

    @Override
    public User toEntity(UserDto dto) {
        User user = new User();
        user.setId(dto.getId());
        user.setDni(dto.getDni());
        user.setRole(dto.getRole());
        user.setPassword(dto.getPassword());
        user.setNombre(dto.getNombre());
        user.setEmail(dto.getEmail());
        return user;
    }

    public User toUpdate(User entity, UserDto userDto){
        if(userDto.getNombre()!=null){// faraz
            entity.setNombre(userDto.getNombre());
        }
        if (userDto.getEmail()!=null){
            entity.setEmail(userDto.getEmail());
        }
        if(userDto.getDni()!=null){
            entity.setDni(userDto.getDni());
        }
        if (userDto.getPassword()!=null){
            entity.setPassword(userDto.getPassword());
        }
        return entity;

    }



    @Override
    public List<UserDto> toDtoList(List<User> user) {
        return user.stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }
}
