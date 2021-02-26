package com.qa.ims.persistence.domain;

import java.util.ArrayList;

public class Orders {

	private Long oid;
	private Long fk_cid;
	private Long fk_oid;
	private ArrayList<Long> pid;
	private ArrayList<Long> quantity;
	private ArrayList<Double> totalPrice;

	public Orders() {
		pid = new ArrayList<>();
		quantity = new ArrayList<>();
		totalPrice = new ArrayList<>();
	}
	
	public ArrayList<Double> getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(ArrayList<Double> totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Orders (Long oid) {
		this.setOid(oid);
	}
	
	public Orders(Long oid, Long fk_cid) {
		this.setOid(oid);
		this.setFk_cid(fk_cid);
	}

	public Orders(Long fk_oid, ArrayList<Long> pid, ArrayList<Long> quantity) {
		this.setFk_oid(fk_oid);
		this.setPid(pid);
		this.setQuantity(quantity);
	}
		
	public Long getOid() {
		return oid;
	}

	public void setOid(Long oid) {
		this.oid = oid;
	}

	public Long getFk_cid() {
		return fk_cid;
	}

	public void setFk_cid(Long fk_cid) {
		this.fk_cid = fk_cid;
	}

	public Long getFk_oid() {
		return fk_oid;
	}

	public void setFk_oid(Long fk_oid) {
		this.fk_oid = fk_oid;
	}

	public ArrayList<Long> getPid() {
		return pid;
	}

	public void setPid(ArrayList<Long> pid) {
		this.pid = pid;
	}

	public ArrayList<Long> getQuantity() {
		return quantity;
	}

	public void setQuantity(ArrayList<Long> quantity) {
		this.quantity = quantity;
	}

	 @Override
	public String toString() {
		return "OID: " + oid + " |" + "CID: " + fk_cid; 
		
	}
	
	public String TransactionsString() {
		String string = "Oid: " + fk_oid;
		for (int i = 0; i < pid.size(); i++) {
			string = string + "\n pid " + pid.get(i) + " quantity " + quantity.get(i) + " Total_Price " + totalPrice.get(i);
		}			
	return string;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((oid == null) ? 0 : oid.hashCode());
		result = prime * result + ((fk_cid == null) ? 0 : fk_cid.hashCode());
		result = prime * result + ((fk_oid == null) ? 0 : fk_oid.hashCode());
		result = prime * result + ((pid == null) ? 0 : pid.hashCode());
		result = prime * result + ((quantity == null) ? 0 : quantity.hashCode());
		result = prime * result + ((totalPrice == null) ? 0 : totalPrice.hashCode());
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
		if (getOid() == null) {
			if (other.getOid() != null)
				return false;
		} else if (!getOid().equals(other.getOid()))
			return false;
		if (getFk_cid() == null) {
			if (other.getFk_cid() != null)
				return false;
		} else if (!getFk_cid().equals(other.getFk_cid()))
			return false;
		if (getFk_oid() == null) {
			if (other.getFk_oid() != null)
				return false;
		} else if (!getFk_oid().equals(other.getFk_oid()))
			return false;
		if (getPid() == null) {
			if (other.getPid() != null)
				return false;
		} else if (!getPid().equals(other.getPid()))
			return false;
		if (getQuantity() == null) {
			if (other.getQuantity() != null)
				return false;
		} else if (!getQuantity().equals(other.getQuantity()))
			return false;
		if (getTotalPrice() == null) {
			if (other.getTotalPrice() != null)
				return false;
		} else if (!getTotalPrice().equals(other.getTotalPrice()))
			return false;
		return true;
	}

}
