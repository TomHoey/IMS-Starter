package com.qa.ims.persistence.domain;

public class Orders {

	private Long id;
	private Long oid;
	private Long pid;
	private Long quantity;
	private Double totalPrice;
	
	public Orders(Long id) {
		this.setId(id);
	}
	
	public Orders (Long oid, Long pid, Long quantity) {
		this.setOid(oid);
		this.setPid(pid);
		this.setQuantity(quantity);
	}
	
	public Orders (Long pid, Long quantity) {
		this.setPid(pid);
		this.setQuantity(quantity);
	}
	
	public Orders (Long pid, Long quantity, Double totalPrice) {
		this.setPid(pid);
		this.setQuantity(quantity);
		this.setTotal(totalPrice);
	
	}
	
	public Long getPid() {
		return pid;
	}

	public void setPid(Long pid) {
		this.pid = pid;
	}

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	public Double getTotal() {
		return totalPrice;
	}

	public void setTotal(Double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getOid() {
		return oid;
	}
	public void setOid(Long oid) {
		this.oid = oid;
	}

	@Override
	public String toString() {
		return "ID: " + " |" + "OID: " + oid;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((oid == null) ? 0 : oid.hashCode());
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
		if (getId() == null) {
			if (other.getId() != null)
				return false;
		} else if (!getId().equals(other.getId()))
			return false;
		if (oid == null) {
			if (other.oid != null)
				return false;
		} else if (!oid.equals(other.oid))
			return false;
		return true;
	}

}
