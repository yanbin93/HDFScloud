package com.demo.model;

public class Materials {
	private int id;
	private String name;
	private String quantity;
	private int stocks_id;
	private int products_id;
	public Materials(){}
	public Materials(String name, String quantity, int stocks_id, int products_id) {
		super();
		this.name = name;
		this.quantity = quantity;
		this.stocks_id = stocks_id;
		this.products_id = products_id;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public int getStocks_id() {
		return stocks_id;
	}
	public void setStocks_id(int stocks_id) {
		this.stocks_id = stocks_id;
	}
	public int getProducts_id() {
		return products_id;
	}
	public void setProducts_id(int products_id) {
		this.products_id = products_id;
	}

}
