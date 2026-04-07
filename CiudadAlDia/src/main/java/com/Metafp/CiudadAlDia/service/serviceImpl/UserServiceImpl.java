package com.Metafp.CiudadAlDia.service.serviceImpl;

import com.Metafp.CiudadAlDia.dto.UserDto;
import com.Metafp.CiudadAlDia.entity.User;
import com.Metafp.CiudadAlDia.exception.ResourceNotFoundException;
import com.Metafp.CiudadAlDia.mapper.UserTransformer;
import com.Metafp.CiudadAlDia.repository.UserRepository;
import com.Metafp.CiudadAlDia.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;// alt+enter
    private final UserTransformer userTransformer;

    public UserServiceImpl(UserRepository userRepository, UserTransformer userTransformer) {
        this.userRepository = userRepository;
        this.userTransformer = userTransformer;
    }

    @Override
    public UserDto save(UserDto userDto) {
        Optional<User> byEmail = userRepository.findByEmail(userDto.getEmail());
        if (byEmail.isPresent()){
            throw new ResourceNotFoundException("User is already registered!");
        }
        User entity = userTransformer.toEntity(userDto);
        entity.setId(UUID.randomUUID().toString());
        User save = userRepository.save(entity);
        return userTransformer.toDto(save);
    }

    @Override
    public UserDto findById(String id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id));
        return userTransformer.toDto(user);
    }

    @Override
    public void delete(String id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id));
        userRepository.deleteById(id);
    }

    @Override
    public UserDto findByEmail(String email) {
        User byEmail = userRepository.findByEmail(email).orElseThrow(() -> new ResourceNotFoundException("User Not Found"));
        return userTransformer.toDto(byEmail);
    }
    public List<UserDto> findBySubName(String subName) {
        List<User> byNameContaining = userRepository.findByNombreContaining(subName);
        return userTransformer.toDtoList(byNameContaining);
    }

    @Override
    public UserDto update(String id, UserDto userDto) {//faraz fraz
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User Not Found With This Id =" + id));
        User update = userTransformer.toUpdate(user, userDto);
        User save = userRepository.save(update);

        return userTransformer.toDto(save);
    }

}
