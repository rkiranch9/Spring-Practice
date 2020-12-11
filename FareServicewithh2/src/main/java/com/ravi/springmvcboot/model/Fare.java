package com.ravi.springmvcboot.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="fare")
public class Fare {
	
	@Id
	private String bustype;
	private int fareperkm;
	
	public Fare() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Fare(String bustype, int fareperkm) {
		super();
		this.bustype = bustype;
		this.fareperkm = fareperkm;
	}

	public String getBustype() {
		return bustype;
	}

	public void setBustype(String bustype) {
		this.bustype = bustype;
	}

	public int getFareperkm() {
		return fareperkm;
	}

	public void setFareperkm(int fareperkm) {
		this.fareperkm = fareperkm;
	}

	@Override
	public String toString() {
		return "Fare [bustype=" + bustype + ", fareperkm=" + fareperkm + "]";
	}
	
		
}
