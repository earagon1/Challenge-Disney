package com.challenge.Auth.service;

import com.challenge.Auth.dto.UserDTO;
import com.challenge.Auth.entity.UserEntity;
import com.challenge.Auth.repository.UserRepository;
import com.challenge.Repository.Service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collections;

public class UserDetailsCustomService implements UserDetailService {

    @Autowired
    private UserRepository userRepository;

    @Autowired

    private EmailService emailService;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException{
        UserEntity userEntity = userRepository.findByUsername(userName);
        if(userEntity == null){
            throw new UsernameNotFoundException("Username or password not found");
        }
        return new User(userEntity.getUserName(),userEntity.getPassword(), Collections.emptyListIterator());
    }

    public boolean save(UserDTO userDTO){
        UserEntity userEntity = new UserEntity();
        userEntity.setUserName(userDTO.getUserName());
        userEntity.setPassword(userDTO.getPassword());
        userEntity =this.userRepository.save(userEntity);
        if(userEntity != null){
            emailService.sendWelcomeEmailTo(userEntity.getUserName());
        }
        return userEntity != null;
    }
}
