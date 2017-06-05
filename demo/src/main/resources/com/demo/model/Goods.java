package com.demo.model;

public class Goods {
private int id;
private String name;
private String code;
private String other;
private int product_id;
public Goods(){
}
public Goods(String name, String code, String other, int product_id) {
	this.name = name;
	this.code = code;
	this.other = other;
	this.product_id = product_id;
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
public String getOther() {
	return other;
}
public void setOther(String other) {
	this.other = other;
}
public int getProduct_id() {
	return product_id;
}
public void setProduct_id(int product_id) {
	this.product_id = product_id;
}

}
