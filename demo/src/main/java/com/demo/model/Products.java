package com.demo.model;

public class Products {
private int id;
private String name;
private String other;
private int manufacturer_id;
private int seller_id;
public Products(){
	
}
public Products(String name, String other, int manufacturer_id, int seller_id, int supplier_id) {
	this.name = name;
	this.other = other;
	this.manufacturer_id = manufacturer_id;
	this.seller_id = seller_id;
	this.supplier_id = supplier_id;
}
private int supplier_id;
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
public String getOther() {
	return other;
}
public void setOther(String other) {
	this.other = other;
}
public int getManufacturer_id() {
	return manufacturer_id;
}
public void setManufacturer_id(int manufacturer_id) {
	this.manufacturer_id = manufacturer_id;
}
public int getSeller_id() {
	return seller_id;
}
public void setSeller_id(int seller_id) {
	this.seller_id = seller_id;
}
public int getSupplier_id() {
	return supplier_id;
}
public void setSupplier_id(int supplier_id) {
	this.supplier_id = supplier_id;
}

}
