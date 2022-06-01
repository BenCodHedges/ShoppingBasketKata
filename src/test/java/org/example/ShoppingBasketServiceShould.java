package org.example;

import org.example.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;


public class ShoppingBasketServiceShould {


	@Test
	@DisplayName("verify total of items added to a basket")
	void verifyTotalOfItemsAddedToABasket() {
		Warehouse warehouse = new Warehouse();
		BasketRepository basketRepository = new BasketRepository();
		Printer printer = mock(Printer.class);

		ShoppingBasketService shoppingBasketService = new ShoppingBasketService(warehouse, printer, basketRepository);

		UserId userId = new UserId(1);

		ProductId hobbitItemId = new ProductId(10002);
		ProductId breakingBadItemId = new ProductId(20110);

		shoppingBasketService.addItem(userId, hobbitItemId, 2);
		shoppingBasketService.addItem(userId, breakingBadItemId, 5);

		shoppingBasketService.basketFor(userId);

		verify(printer).print("01/06/2022");
		verify(printer).print("2 x The Hobbit");
		verify(printer).print("5 x Breaking Bad");
		verify(printer).print("Total: £45.00");
	}

	@Test
	@DisplayName("create a basket if a new user adds an item")
	void createABasketIfANewUserAddsAnItem() {
		Warehouse warehouse = new Warehouse();
		BasketRepository basketRepository = mock(BasketRepository.class);
		Printer printer = mock(Printer.class);
		ShoppingBasketService shoppingBasketService = new ShoppingBasketService(warehouse, printer, basketRepository);

		User user = mock(User.class);
		given(user.getUserId()).willReturn(new UserId(1));

		ProductId breakingBadItemId = new ProductId(20110);
		shoppingBasketService.addItem(user.getUserId(), breakingBadItemId, 1);

		verify(basketRepository).addToBasket(user.getUserId(), breakingBadItemId, 1);
	}

	@Test
	@DisplayName("Add product to existing user's basket")
	void addProductToExistingUsersBasket() {
		Warehouse warehouse = new Warehouse();
		BasketRepository basketRepository = mock(BasketRepository.class);
		Printer printer = mock(Printer.class);
		ShoppingBasketService shoppingBasketService = new ShoppingBasketService(warehouse, printer, basketRepository);

		User user = mock(User.class);
		UserId userId = new UserId(1);
		given(user.getUserId()).willReturn(userId);

		ProductId breakingBadItemId = new ProductId(20110);
		ProductId hobbitItemId = new ProductId(10002);

		shoppingBasketService.addItem(user.getUserId(), breakingBadItemId, 1);
		shoppingBasketService.addItem(user.getUserId(), hobbitItemId, 1);

		verify(basketRepository).addToBasket(user.getUserId(), breakingBadItemId, 1);
		verify(basketRepository).addToBasket(user.getUserId(), hobbitItemId, 1);
	}

}