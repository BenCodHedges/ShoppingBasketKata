package org.example;

import java.util.ArrayList;

public class Basket {

	UserId userId;
	ArrayList<BasketProduct> basketProducts;

	public Basket(UserId userId) {
		this.userId = userId;
		basketProducts = new ArrayList<>();
	}

	public void addProductToBasket(ProductId productId, int quantity) {
		basketProducts.add(new BasketProduct(productId, quantity));
	}

	public UserId getUserId() {
		return userId;
	}
}
