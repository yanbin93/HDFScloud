package com.demo.model;
import java.util.Date;
public class TestGoods {
		private int id;
		private int productId;
		private int productCode;
		private String productNo;
		private String productName;
		private int linkId;
		public TestGoods(){}
		public TestGoods(int productId, int productCode, String productNo, String productName) {
			this.productId = productId;
			this.productCode = productCode;
			this.productNo = productNo;
			this.productName = productName;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public int getProductId() {
			return productId;
		}
		public void setProductId(int productId) {
			this.productId = productId;
		}
		public int getProductCode() {
			return productCode;
		}
		public void setProductCode(int productCode) {
			this.productCode = productCode;
		}
		public String getProductNo() {
			return productNo;
		}
		public void setProductNo(String productNo) {
			this.productNo = productNo;
		}
		public int getLinkId() {
			return linkId;
		}
		public void setLinkId(int linkId) {
			this.linkId = linkId;
		}
		public String getProductName() {
			return productName;
		}
		public void setProductName(String productName) {
			this.productName = productName;
		}

	}