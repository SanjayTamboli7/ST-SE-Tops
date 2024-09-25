package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.Books;

public interface BooksRepository extends CrudRepository<Books, Integer> {

}
