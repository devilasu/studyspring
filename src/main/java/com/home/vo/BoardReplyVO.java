package com.home.vo;

import java.util.Date;

public class BoardReplyVO {
	private Integer reply_index;
	private String reply_content;
	private String reply_writer;
	private Date reg_date;
	private Date update_date;
	private Integer board_index;
	@Override
	public String toString() {
		return "BoardReplyVO [reply_index=" + reply_index + ", reply_content=" + reply_content + ", reply_writer="
				+ reply_writer + ", reg_date=" + reg_date + ", update_date=" + update_date + ", board_index="
				+ board_index + "]";
	}
	public Integer getReply_index() {
		return reply_index;
	}
	public void setReply_index(Integer reply_index) {
		this.reply_index = reply_index;
	}
	public String getReply_content() {
		return reply_content;
	}
	public void setReply_content(String reply_content) {
		this.reply_content = reply_content;
	}
	public String getReply_writer() {
		return reply_writer;
	}
	public void setReply_writer(String reply_writer) {
		this.reply_writer = reply_writer;
	}
	public Date getReg_date() {
		return reg_date;
	}
	public void setReg_date(Date reg_date) {
		this.reg_date = reg_date;
	}
	public Date getUpdate_date() {
		return update_date;
	}
	public void setUpdate_date(Date update_date) {
		this.update_date = update_date;
	}
	public Integer getBoard_index() {
		return board_index;
	}
	public void setBoard_index(Integer board_index) {
		this.board_index = board_index;
	}
	
}
