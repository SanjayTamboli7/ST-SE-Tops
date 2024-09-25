package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Wishlist;
import com.example.demo.service.WishlistService;

@RestController
public class WishlistController {

	@SuppressWarnings("unused")
	@Autowired
	WishlistService wishlistservice; 
	@GetMapping("/wishlist")
	private List<Wishlist> getAllWishlists() {
		return wishlistservice.getAllwishList();
	}

	@GetMapping("wishlist/{wishlistid}")
	private Wishlist getWishlist(@PathVariable("wishlistid") int wishlistid) {
		return wishlistservice.getWishlistById(wishlistid);
	}
	
	@DeleteMapping("wishlist/{wishlistid}")
	private void deletewishlist(@PathVariable("wishlistid") int wishlistid) {
		wishlistservice.delete(wishlistid);
	}
	
	@PostMapping("/wishlist")
	private int saveWishlist(@RequestBody Wishlist wishlist) {
		wishlistservice.saveOrUpdate(wishlist);
		return wishlist.getWishlistid();
	}
	
	@PutMapping("/wishlist")
	private Wishlist update(@RequestBody Wishlist wishlist) {
		wishlistservice.saveOrUpdate(wishlist);
		return wishlist;
	}
	
	
}
