package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.Dealers;

public interface DealerRepo extends CrudRepository<Dealers, Integer>{

}
