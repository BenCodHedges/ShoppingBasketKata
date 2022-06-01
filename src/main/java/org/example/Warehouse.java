package org.example;

import java.util.*;


public class Warehouse {

	private ArrayList<Product> products = new ArrayList<Product>();


	public Warehouse() {
		fillWarehouse();
	}

	private void fillWarehouse() {
		products.add(new Product(new ProductId(10001), "Lord of the Rings", 10.00f ));
		products.add(new Product(new ProductId(10002), "The Hobbit", 5.00f));
		products.add(new Product(new ProductId(20001), "Game of Thrones", 9.00f));
		products.add(new Product(new ProductId(20110), "Breaking Bad", 7.00f));
	}


}
