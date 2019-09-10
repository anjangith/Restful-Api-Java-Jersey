package com.anjan.api.restapi;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Item {

	private String name;
	private int point;
	private int id;
	
	
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
	
	public int getpoint() {
		return point;
	}
	
	public void setpoint(int point) {
		this.point = point;
	}

	@Override
	public String toString() {
		return "Item [name=" + name + ", point=" + point + ", id=" + id + "]";
	}
}
