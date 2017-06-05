package com.demo.model;

public class Suppliers {
	private int id;
	private String name;
	private String pemit;
	private String code;
	private String address;
	private String phone;
	private String mail;
	private String contact;
	private String other;
	public Suppliers(){}
	public Suppliers(String name, String pemit, String code, String address, String phone, String mail, String contact,
			String other) {
		super();
		this.name = name;
		this.pemit = pemit;
		this.code = code;
		this.address = address;
		this.phone = phone;
		this.mail = mail;
		this.contact = contact;
		this.other = other;
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
	public String getPemit() {
		return pemit;
	}
	public void setPemit(String pemit) {
		this.pemit = pemit;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getOther() {
		return other;
	}
	public void setOther(String other) {
		this.other = other;
	}
}
