package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.Wishlist;

public interface WishlistRepo extends CrudRepository<Wishlist, Integer> {

}
