package com.qa.ims.persistence.domain;

public class Orders {

	private Long oid;
	private Long fk_cid;
	private Long fk_oid;
	private Long pid;
	private Long quantity;

	public Orders (Long oid) {
		this.setOid(oid);
	}
	
	public Orders(Long oid, Long fk_cid) {
		this.setOid(oid);
		this.setFk_cid(fk_cid);
	}

	public Orders(Long fk_oid, Long pid, Long quantity) {
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

	 @Override
	public String toString() {
		return "OID: " + oid + " |" + "CID: " + fk_cid; 
		
	}
	
	public String tooString() {
		return "fk_oid: " + fk_oid + " |" + "pid: " + pid +  " |" + "quantity: " + quantity;
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
		return true;
	}

}
