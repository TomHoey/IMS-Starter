package com.qa.ims.persistence.domain;

public class Items {

	private Long pid;
	private String productName;
	private Float price;

	
	public Items(Long pid, String productName, Float price) {
		this.setPid(pid);
		this.setItem(productName);
		this.setPrice(price);
		
	}


	public long getPid() {
		return pid;
	}

	public void setPid(long pid) {
		this.pid = pid;
	}

	public String getProductName() {
		return productName;
	}

	public void setItem(String productName) {
		this.productName = productName;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;

	}
	
	@Override
	public String toString() {
		return "ProductID: " + pid + " |" + "Product: " + productName + " |" + "Price: " + price;
	}
}
