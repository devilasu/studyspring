package com.home.vo;

public class MenuVO {
	private String menu_type;
	private String menu_name;
	private int menu_order;
	private int menu_parent;
	
	@Override
	public String toString() {
		return "MenuVO [menu_type=" + menu_type + ", menu_name=" + menu_name + ", menu_order=" + menu_order
				+ ", menu_parent=" + menu_parent + "]";
	}
	public String getMenu_type() {
		return menu_type;
	}
	public void setMenu_type(String menu_type) {
		this.menu_type = menu_type;
	}
	public String getMenu_name() {
		return menu_name;
	}
	public void setMenu_name(String menu_name) {
		this.menu_name = menu_name;
	}
	public int getMenu_order() {
		return menu_order;
	}
	public void setMenu_order(int menu_order) {
		this.menu_order = menu_order;
	}
	public int getMenu_parent() {
		return menu_parent;
	}
	public void setMenu_parent(int menu_parent) {
		this.menu_parent = menu_parent;
	}
	
}