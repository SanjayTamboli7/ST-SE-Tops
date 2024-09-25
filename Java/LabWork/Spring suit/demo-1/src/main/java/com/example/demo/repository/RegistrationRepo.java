package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.Registration;

public interface RegistrationRepo extends CrudRepository<Registration, Integer> {

}
