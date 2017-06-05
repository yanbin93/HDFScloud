package com.demo.model;

public class Stocks {
private int id;
private String name;
private String code;
private String person;
private String data;
private String quantity;
private String checkresult;
private int supplier_id;
public Stocks(){}
public Stocks(String name, String code, String person, String data, String quantity, String checkresult,
		int supplier_id) {
	super();
	this.name = name;
	this.code = code;
	this.person = person;
	this.data = data;
	this.quantity = quantity;
	this.checkresult = checkresult;
	this.supplier_id = supplier_id;
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
public String getCode() {
	return code;
}
public void setCode(String code) {
	this.code = code;
}
public String getPerson() {
	return person;
}
public void setPerson(String person) {
	this.person = person;
}
public String getData() {
	return data;
}
public void setData(String data) {
	this.data = data;
}
public String getQuantity() {
	return quantity;
}
public void setQuantity(String quantity) {
	this.quantity = quantity;
}
public String getCheckresult() {
	return checkresult;
}
public void setCheckresult(String checkresult) {
	this.checkresult = checkresult;
}
public int getSupplier_id() {
	return supplier_id;
}
public void setSupplier_id(int supplier_id) {
	this.supplier_id = supplier_id;
}

}
