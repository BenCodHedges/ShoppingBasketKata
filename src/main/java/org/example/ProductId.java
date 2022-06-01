package org.example;

public class ProductId {

	private int id;

	public ProductId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public boolean equals(UserId userId) {
		return (userId.getId() == this.id) ? true : false;
	}

}
