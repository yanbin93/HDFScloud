package com.demo.model;

public class Manufacturers {
	private int id;
	private String name;
	private String code;
	private String type;
	private String permit_starttime;
	private String permit_endtime;
	private String permit_range;
	private String permit_pic;
	private String other;
	private int seller_id;
	private int supplier_id;
	
	public Manufacturers(){}
	public Manufacturers(String name, String code, String type, String permit_starttime, String permit_endtime,
			String pemit_range, String permit_pic, String other, int seller_id, int supplier_id) {
		super();
		this.name = name;
		this.code = code;
		this.type = type;
		this.permit_starttime = permit_starttime;
		this.permit_endtime = permit_endtime;
		this.permit_range = pemit_range;
		this.permit_pic = permit_pic;
		this.other = other;
		this.seller_id = seller_id;
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
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getPermit_starttime() {
		return permit_starttime;
	}
	public void setPermit_starttime(String permit_starttime) {
		this.permit_starttime = permit_starttime;
	}
	public String getPermit_endtime() {
		return permit_endtime;
	}
	public void setPermit_endtime(String permit_endtime) {
		this.permit_endtime = permit_endtime;
	}
	public String getPermit_range() {
		return permit_range;
	}
	public void setPermit_range(String pemit_range) {
		this.permit_range = pemit_range;
	}
	public String getPermit_pic() {
		return permit_pic;
	}
	public void setPermit_pic(String permit_pic) {
		this.permit_pic = permit_pic;
	}
	public String getOther() {
		return other;
	}
	public void setOther(String other) {
		this.other = other;
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
