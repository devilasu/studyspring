package com.home.vo;

public class BoardTypeVO {
	private String type;
	private String name;
	private String order;
	@Override
	public String toString() {
		return "BoardTypeVO [type=" + type + ", name=" + name + ", order=" + order + "]";
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getOrder() {
		return order;
	}
	public void setOrder(String order) {
		this.order = order;
	}
	
}
