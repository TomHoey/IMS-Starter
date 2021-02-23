package com.qa.ims.persistence.domain;

public class Orders {
	
	private Long id;
	private Long pid;
	private Long oid;
	private String productName;
	private Double subTotal;
	private Double tax;

	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getPid() {
		return pid;
	}
	public void setPid(Long pid) {
		this.pid = pid;
	}
	public Long getOid() {
		return oid;
	}
	public void setCid(Long oid) {
		this.oid = oid;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public Double getSubTotal() {
		return subTotal;
	}
	public void setSubTotal(Double subTotal) {
		this.subTotal = subTotal;
	}
	public double getTax() {
		return tax;
	}
	public void setTax(double tax) {
		this.tax = tax;
	}
	
	@Override
	public String toString() {
		return "OID: " + oid + " |" + "Product: " + productName + " |" + "Sub-Total: " + subTotal + " |" + "VAT: " + tax;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((productName == null) ? 0 : productName.hashCode());
		result = prime * result + ((oid == null) ? 0 : oid.hashCode());
		result = prime * result + ((subTotal == null) ? 0 : subTotal.hashCode());
		result = prime * result + ((tax == null) ? 0 : tax.hashCode());
		return result;
	
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Orders other = (Orders) obj;
		if (getProductName() == null) {
			if (other.getProductName() != null)
				return false;
		} else if (!getProductName().equals(other.getProductName()))
			return false;
		if (oid == null) {
			if (other.oid != null)
				return false;
		}else if (!oid.equals(other.oid))
			return false;
		return true;
	}
	
}
