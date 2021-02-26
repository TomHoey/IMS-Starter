package com.qa.ims.persistence.domain;

public class Items {

	private Long pid;
	private String productName;
	private Double price;

	public Items () {
		
	}
	
	public Items(Long pid, String productName, Double price) {
		this.setPid(pid);
		this.setItem(productName);
		this.setPrice(price);

	}

	public Items(String productName, Double price) {
		this.setItem(productName);
		this.setPrice(price);

	}

	public Long getPid() {
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

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) { 
		this.price = price;

	}

	@Override
	public String toString() {
		return "ProductID: " + pid + " |" + "Product: " + productName + " |" + "Price: £" + price;
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((productName == null) ? 0 : productName.hashCode());
		result = prime * result + ((pid == null) ? 0 : pid.hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		return result;
		
	}
	
	// This will stop duplicate Items being added to the database.

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Items other = (Items) obj;
		if (getProductName() == null) {
			if (other.getProductName() != null)
				return false;
		} else if (!getProductName().equals(other.getProductName()))
				return false;
		if (getPid() == null) {
			if (other.getPid() != null)
				return false;
		}else if (!getPid().equals(other.getPid()))
			return false;
		if (getPrice() == null) {
			if (other.getPrice() != null)
				return false;
		} else if (!getPrice().equals(other.getPrice()))
			return false;
		return true;
	}

}
