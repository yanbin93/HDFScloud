package com.demo.model;

public class Records_check {
private int id;
private String name;
private String results;
private int prodicts_id;
public Records_check(){}
public Records_check(String name, String results, int prodicts_id) {
	super();
	this.name = name;
	this.results = results;
	this.prodicts_id = prodicts_id;
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
public String getResults() {
	return results;
}
public void setResults(String esults) {
	this.results = esults;
}
public int getProdicts_id() {
	return prodicts_id;
}
public void setProdicts_id(int prodicts_id) {
	this.prodicts_id = prodicts_id;
}

}
