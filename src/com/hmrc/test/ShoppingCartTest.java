package com.hmrc.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.hmrc.main.ShoppingCart;

public class ShoppingCartTest {
	
	ShoppingCart cart;
	
	@Before
	public void setup() throws Exception{
		cart = new ShoppingCart();
	}

	@Test
	public void testSimpleAddition() {
		String[] fr = {"Apple", "Apple", "Orange", "Apple"};
		List<String> fruits = new ArrayList<String>(Arrays.asList(fr));
		assertEquals("£2.05", cart.checkout(fruits));
	}

	@Test
	public void testNonsense() {
		String[] fr = {"Ape", "Ale", "Orge", "Ape"};
		List<String> fruits = new ArrayList<String>(Arrays.asList(fr));
		assertEquals("incorrect Entry. Try again: 'Apples or Oranges' ", cart.checkout(fruits));
	}
	
	@Test
	public void testDecimalPlacesAccuracy() {
		String[] fr = {"Orange", "Apple", "Orange", "Apple"};
		List<String> fruits = new ArrayList<String>(Arrays.asList(fr));
		assertEquals("£1.70", cart.checkout(fruits));
	}

	@Test
	public void testEmptyList() {
		String[] fr = {};
		List<String> fruits = new ArrayList<String>(Arrays.asList(fr));
		assertEquals(null, cart.checkout(fruits));
	}

	@Test
	public void testSingleInput() {
		String[] fr = {"Apple"};
		List<String> fruits = new ArrayList<String>(Arrays.asList(fr));
		assertEquals("£0.60", cart.checkout(fruits));
	}
}
