package com.home.vo;

import java.util.Date;

public class BoardReplyVO {
	private Integer idx;
	private String content;
	private String writer;
	private Date reg_date;
	private Date update_date;
	private Integer board_idx;
	
	@Override
	public String toString() {
		return "BoardReplyVO [idx=" + idx + ", content=" + content + ", writer=" + writer + ", reg_date=" + reg_date
				+ ", update_date=" + update_date + ", board_idx=" + board_idx + "]";
	}
	public Integer getIdx() {
		return idx;
	}
	public void setIdx(Integer idx) {
		this.idx = idx;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
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
	public Integer getBoard_idx() {
		return board_idx;
	}
	public void setBoard_idx(Integer board_idx) {
		this.board_idx = board_idx;
	}
	
}
