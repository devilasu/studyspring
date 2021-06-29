package com.home.vo;

import java.util.Date;

public class BoardVO {
	private Integer board_index;
	private String board_title;
	private String board_content;
	private String board_writer;
	private Integer board_viewcount;
	private Date board_reg_date;
	private Date board_update_date;
	private String board_type;
	@Override
	public String toString() {
		return "BoardVO [board_index=" + board_index + ", board_title=" + board_title + ", board_content="
				+ board_content + ", board_writer=" + board_writer + ", board_viewcount=" + board_viewcount
				+ ", board_reg_date=" + board_reg_date + ", board_update_date=" + board_update_date + ", board_type="
				+ board_type + "]";
	}
	public Integer getBoard_index() {
		return board_index;
	}
	public void setBoard_index(Integer board_index) {
		this.board_index = board_index;
	}
	public String getBoard_title() {
		return board_title;
	}
	public void setBoard_title(String board_title) {
		this.board_title = board_title;
	}
	public String getBoard_content() {
		return board_content;
	}
	public void setBoard_content(String board_content) {
		this.board_content = board_content;
	}
	public String getBoard_writer() {
		return board_writer;
	}
	public void setBoard_writer(String board_writer) {
		this.board_writer = board_writer;
	}
	public Integer getBoard_viewcount() {
		return board_viewcount;
	}
	public void setBoard_viewcount(Integer board_viewcount) {
		this.board_viewcount = board_viewcount;
	}
	public Date getBoard_reg_date() {
		return board_reg_date;
	}
	public void setBoard_reg_date(Date board_reg_date) {
		this.board_reg_date = board_reg_date;
	}
	public Date getBoard_update_date() {
		return board_update_date;
	}
	public void setBoard_update_date(Date board_update_date) {
		this.board_update_date = board_update_date;
	}
	public String getBoard_type() {
		return board_type;
	}
	public void setBoard_type(String board_type) {
		this.board_type = board_type;
	}
	

}
