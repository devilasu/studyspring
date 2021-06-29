package com.home.vo;

import java.util.Date;

public class BoardAttach {
	private String save_file_name;
	private String real_file_name;
	private Date reg_date;
	private Integer board_index;
	@Override
	public String toString() {
		return "BoardAttach [save_file_name=" + save_file_name + ", real_file_name=" + real_file_name + ", reg_date="
				+ reg_date + ", board_index=" + board_index + "]";
	}
	public String getSave_file_name() {
		return save_file_name;
	}
	public void setSave_file_name(String save_file_name) {
		this.save_file_name = save_file_name;
	}
	public String getReal_file_name() {
		return real_file_name;
	}
	public void setReal_file_name(String real_file_name) {
		this.real_file_name = real_file_name;
	}
	public Date getReg_date() {
		return reg_date;
	}
	public void setReg_date(Date reg_date) {
		this.reg_date = reg_date;
	}
	public Integer getBoard_index() {
		return board_index;
	}
	public void setBoard_index(Integer board_index) {
		this.board_index = board_index;
	}
	

}
