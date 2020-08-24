package com.github.zawadamatt.dateapp.repository;

import com.github.zawadamatt.dateapp.model.UserGeolocation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserGeolocationRepository extends JpaRepository<UserGeolocation, Long> {

}
