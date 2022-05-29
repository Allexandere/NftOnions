package com.rocket.onionnft.model.service;

import com.rocket.onionnft.model.dto.ExternalUserDto;
import com.rocket.onionnft.model.entity.UserEntity;
import com.rocket.onionnft.model.exception.UserException;
import com.rocket.onionnft.model.mapper.UserMapper;
import com.rocket.onionnft.repository.UserRepository;
import org.apache.catalina.User;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserMapper userMapper;

    private static final String USER_WITH_THIS_NAME_ALREADY_EXISTS = "User with %s username already exists";
    private static final String USER_DOES_NOT_EXIST = "User does not exist";


    public ExternalUserDto createUser(ExternalUserDto user) throws UserException {
        if(userRepository.existsByUsername(user.getUsername())){
            throw new UserException(String.format(USER_WITH_THIS_NAME_ALREADY_EXISTS,user.getUsername()));
        }
        UserEntity userEntity = UserEntity.builder()
                .password(user.getPassword())
                .username(user.getUsername())
                .build();
        return userMapper.mapUserEntity(userRepository.save(userEntity));
    }

    public ExternalUserDto getUser(UUID id) throws UserException {
        Optional<UserEntity> foundUser = userRepository.findById(id);
        if(foundUser.isPresent()){
            return userMapper.mapUserEntity(foundUser.get());
        }
        throw new UserException(USER_DOES_NOT_EXIST);
    }
}
