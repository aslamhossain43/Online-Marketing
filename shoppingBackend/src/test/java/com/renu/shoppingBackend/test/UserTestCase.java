package com.renu.shoppingBackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.renu.shoppingBackend.dao.UserDAO;
import com.renu.shoppingBackend.dto.Address;
import com.renu.shoppingBackend.dto.Cart;
import com.renu.shoppingBackend.dto.User;


public class UserTestCase {

	private static AnnotationConfigApplicationContext context;
	private static UserDAO userDAO;
	private User user = null;
	private Cart cart = null;
	private Address address = null;
	
	
	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.renu.shoppingBackend");
		context.refresh();
		
		userDAO = (UserDAO) context.getBean("userDAO");
	}
	

/*	@Test
	public void testAddUser() {
		
		user = new User() ;
		user.setFirstName("Hrithik");
		user.setLastName("Roshan");
		user.setEmail("hr@gmail.com");
		user.setContactNumber("1234512345");
		user.setRole("USER");
		
		user.setPassword("123456");
		// add the user
	assertEquals("Failed to add the user!", true, userDAO.add(user));	
		
		address = new Address();
		address.setAddressLineOne("101/B Jadoo Society, Krissh Nagar");
		address.setAddressLineTwo("Near Kaabil Store");
		address.setCity("Mumbai");
		address.setState("Maharashtra");
		address.setCountry("India");
		address.setPostalCode("400001");
		address.setBilling(true);
		
	
		
		// linked the address with the user
		address.setUserId(user.getId());
		
		
		// add the address
assertEquals("Failed to add the  address!", true, userDAO.addAddress(address));
		
		
		if (user.getRole().equals("USER")) {
			cart = new Cart();
		
		// linked the cart with the user
		cart.setUserId(user.getId());
		
		
		assertEquals("Failed to add the  cart!", true, userDAO.addCart(cart));
		// link the user with the cart
		user.setCart(cart);
		
		*/
		

	
		/*// add the shipping address
		address = new Address();
		address.setAddressLineOne("201/B Jadoo Society, Kishan Kanhaiya Nagar");
		address.setAddressLineTwo("Near Kudrat Store");
		address.setCity("Mumbai");
		address.setState("Maharashtra");
		address.setCountry("India");
		address.setPostalCode("400001");
		address.setUserId(user);
		assertEquals("Failed to add the shipping address!", true, userDAO.addAddress(address));
		*/
	}
	
	

	// working for uni-directional
/*
	@Test
	public void testAddAddress() {
		user = userDAO.get(1);
		
		address = new Address();
		address.setAddressLineOne("301/B Jadoo Society, King Uncle Nagar");
		address.setAddressLineTwo("Near Store");
		address.setCity("Mumbai");
		address.setState("Maharashtra");
		address.setCountry("India");
		address.setPostalCode("400001");
				
		address.setUser(user);
		// add the address
		assertEquals("Failed to add the address!", true, userDAO.addAddress(address));	
	}
	
	@Test
	public void testUpdateCart() {
		user = userDAO.get(1);
		cart = user.getCart();
		cart.setGrandTotal(10000);
		cart.setCartLines(1);
		assertEquals("Failed to update the cart!", true, userDAO.updateCart(cart));			
	} 

*/
	

	

