package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Wishlist;
import com.example.demo.repository.WishlistRepo;

@Service
public class WishlistService {

	@Autowired
	WishlistRepo wishlistRepository;

	public List<Wishlist> getAllwishList() // all data fetch
	{
		List<Wishlist> wishlists=new ArrayList<Wishlist>();
		wishlistRepository.findAll().forEach(wishlists1 -> wishlists.add(wishlists1));
		return wishlists;
	}
	
	public Wishlist getWishlistById(int id) // Single wish list fetch
	{
		return wishlistRepository.findById(id).get(); 
	}

	public void saveOrUpdate(Wishlist wishlist) // insert new book
	{
		wishlistRepository.save(wishlist);
	}

	public void delete(int id) 
	{
		wishlistRepository.deleteById(id);
	}
	
	public void update(Wishlist wishlist, int wishlistid) 
	{
		wishlistRepository.save(wishlist);
	}

}
