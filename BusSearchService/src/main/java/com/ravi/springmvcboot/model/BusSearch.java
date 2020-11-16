package com.ravi.springmvcboot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="bussearch")
public class BusSearch {
	
	@Id
	private int id;
	private String bustype;
	private int distance;
	@Column(name = "source_city")
	private String from;
	@Column(name = "destination_city")
	private String to;
	
	public BusSearch() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BusSearch(String bustype, int distance, String from, String to) {
		super();
		this.id = id;
		this.bustype = bustype;
		this.distance = distance;
		this.from = from;
		this.to = to;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBustype() {
		return bustype;
	}

	public void setBustype(String bustype) {
		this.bustype = bustype;
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	@Override
	public String toString() {
		return "BusSearch [id=" + id + ", bustype=" + bustype + ", distance=" + distance + ", from=" + from + ", to="
				+ to + "]";
	}

	
}
