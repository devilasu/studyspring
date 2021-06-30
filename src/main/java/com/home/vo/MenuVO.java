package com.home.vo;
/**
 * 이 클래스는 admin, home 메뉴 관리를 위한 오브젝트 입니다.
 * @author 김영제
 *
 */
public class MenuVO {
	private String type;
	private String name;
	private int orders;
	private int parent;
	@Override
	public String toString() {
		return "MenuVO [type=" + type + ", name=" + name + ", orders=" + orders + ", parent=" + parent + "]";
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
	public int getOrders() {
		return orders;
	}
	public void setOrders(int orders) {
		this.orders = orders;
	}
	public int getParent() {
		return parent;
	}
	public void setParent(int parent) {
		this.parent = parent;
	}
	
	
	
}