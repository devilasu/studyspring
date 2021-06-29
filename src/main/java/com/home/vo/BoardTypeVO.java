package com.home.vo;

public class BoardTypeVO {
	private String board_type;
	private String board_name;
	private String board_order;
	
	@Override
	public String toString() {
		return "BoardTypeVO [board_type=" + board_type + ", board_name=" + board_name + ", board_order=" + board_order
				+ "]";
	}
	public String getBoard_type() {
		return board_type;
	}
	public void setBoard_type(String board_type) {
		this.board_type = board_type;
	}
	public String getBoard_name() {
		return board_name;
	}
	public void setBoard_name(String board_name) {
		this.board_name = board_name;
	}
	public String getBoard_order() {
		return board_order;
	}
	public void setBoard_order(String board_order) {
		this.board_order = board_order;
	}
	
}
