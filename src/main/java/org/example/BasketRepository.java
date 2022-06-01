package org.example;

import java.util.ArrayList;

public class BasketRepository {
	private ArrayList<Basket> baskets;

	public BasketRepository() {
		this.baskets = new ArrayList<>();
	}

	public void addToBasket(UserId userId, ProductId productId, int quantity) {
		if (!doesUserIdHaveBasket(userId)) {
			baskets.add(new Basket(userId));
		}
		getBasketByUserId(userId).addProductToBasket(productId, quantity);
	}

	private boolean doesUserIdHaveBasket(UserId userId) {
		for (Basket basketElement: baskets) {
			if (basketElement.getUserId().equals(userId)) {
				return true;
			}
		}
		return false;
	}

	private Basket getBasketByUserId(UserId userId) {
		for (Basket basketElement: baskets) {
			if (basketElement.getUserId().equals(userId)) {
				return basketElement;
			}
		}
		return null;
	}
}
