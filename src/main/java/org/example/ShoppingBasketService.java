package org.example;

public class ShoppingBasketService {

	private Printer printer;
	private Warehouse warehouse;
	private BasketRepository basketRepository;


	public ShoppingBasketService(Warehouse warehouse, Printer printer, BasketRepository basketRepository) {
		this.printer = printer;
		this.warehouse = warehouse;
		this.basketRepository = basketRepository;
	}

	public void addItem(UserId userId, ProductId productId, int quantity) {
		basketRepository.addToBasket(userId, productId, quantity);
	}

	public String basketFor(UserId userId) {
		throw new UnsupportedOperationException();
	}

}
