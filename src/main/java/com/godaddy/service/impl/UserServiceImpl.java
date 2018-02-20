package com.godaddy.service.impl;

import com.godaddy.dto.UserDTO;
import com.godaddy.persistance.entity.PhoneEntity;
import com.godaddy.persistance.entity.UserEntity;
import com.godaddy.persistance.repository.PhoneRepository;
import com.godaddy.persistance.repository.UserRepository;
import com.godaddy.service.UserService;
import com.godaddy.utils.PhoneUtil;
import javassist.tools.web.BadHttpRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by sasha on 20.02.2018.
 */
@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

    private PhoneRepository phoneRepository;

    public UserServiceImpl(UserRepository userRepository, PhoneRepository phoneRepository) {
        this.userRepository = userRepository;
        this.phoneRepository = phoneRepository;
    }

    @Override
    public List<UserDTO> getAllUsers() {
        return userRepository
                .findAll()
                .stream()
                .map(this::parseUserIntoDto)
                .collect(Collectors.toList());
    }

    @Override
    public UserDTO getUser(Long userId) {
        return parseUserIntoDto(userRepository.findOne(userId));
    }

     @Override
    public void saveUser(UserDTO userDTO) {
        UserEntity entity = userRepository.save(parseUserDtoIntoEntity(userDTO));

       userDTO.getPhones().forEach(phone->{
            PhoneEntity phoneEntity = new PhoneEntity();
            phoneEntity.setPhone(phone);
            phoneEntity.setUser(entity);
           phoneRepository.save(phoneEntity);
        });


    }


    private UserEntity parseUserDtoIntoEntity(UserDTO userDTO){
        UserEntity entity = new UserEntity();
        entity.setName(userDTO.getName());
        return entity;
    }

    private UserDTO parseUserIntoDto(UserEntity userEntity) {
        if(Objects.isNull(userEntity)){
            throw new IllegalArgumentException("User not found");
        }
        UserDTO userDTO = new UserDTO();
        userDTO.setName(userEntity.getName());
        userDTO.setPhones(userEntity.getPhones()
                .stream()
                .filter(phone -> PhoneUtil.validatePhone(phone.getPhone()))
                .map(PhoneEntity::getPhone)
                .collect(Collectors.toSet()));
        return userDTO;

    }
}
