package org.example;

import java.util.ArrayList;

public class User {

	private UserId id;
	private ArrayList<Basket> basket;


	public User(UserId id) {
		this.id = id;
		this.basket = new ArrayList<>();
	}

	public UserId getUserId() {
		return id;
	}

//	public void addToBasket(UserId userId, ProductId productId, int quantity) {
//		basket.add(new BasketElement(userId, productId, quantity));
//	}
}
