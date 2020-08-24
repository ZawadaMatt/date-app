package com.github.zawadamatt.dateapp.service;

import com.github.zawadamatt.dateapp.model.User;
import com.github.zawadamatt.dateapp.model.UserGeolocation;
import com.github.zawadamatt.dateapp.repository.UserGeolocationRepository;
import com.github.zawadamatt.dateapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
public class UserService {


    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;
    private UserGeolocationRepository userGeolocationRepository;

    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder, UserGeolocationRepository userGeolocationRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.userGeolocationRepository = userGeolocationRepository;
    }


    public void addUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }


    public void addInformationToUser(User user, HttpServletRequest request) {
        User oldUser = userRepository.findUserByUsername(user.getUsername());
        UserGeolocation userGeolocation = new UserGeolocation();
        user.setUsername(oldUser.getUsername());
        user.setPassword(oldUser.getPassword());
        userRepository.delete(oldUser);
        userRepository.save(user);
        /*userToDb.setName(user.getName());
        userToDb.setAge(user.getAge());
        userToDb.setSex(user.getSex());
        userToDb.setHeight(user.getHeight());
        userToDb.setHair(user.getHair());
        userToDb.setHairColor(user.getHairColor());
        userToDb.setSkinColor(user.getSkinColor());
        userToDb.setBodyType(userToDb.getBodyType());

        userToDb.setTattos(userToDb.isTattos());
        userToDb.setKids(userToDb.isKids());
        userToDb.setPersonality(userToDb.getPersonality());
        userToDb.setAnimals(userToDb.getAnimals());
        userToDb.setHobby(userToDb.getHobby());
        userToDb.setCarrer(userToDb.getCarrer());*/

        userGeolocation.setLatitude(Double.parseDouble(request.getParameter("latitude")));
        userGeolocation.setLongitude(Double.parseDouble(request.getParameter("longtitude")));
        userGeolocation.setUserId(user);
        userGeolocationRepository.save(userGeolocation);

    }


}
