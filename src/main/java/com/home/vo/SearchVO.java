package com.home.vo;

public class SearchVO {
	private PageVO pageVO;
	private String type;
	private String search_type;
	private String search_keyword;
	
	public SearchVO(String type){
		this.type = type;
	}
	
	@Override
	public String toString() {
		return "SearchVO [pageVO=" + pageVO + ", type=" + type + ", search_type=" + search_type + ", search_keyword="
				+ search_keyword + "]";
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public PageVO getPageVO() {
		return pageVO;
	}
	public void setPageVO(PageVO pageVO) {
		this.pageVO = pageVO;
	}
	public String getSearch_type() {
		return search_type;
	}
	public void setSearch_type(String search_type) {
		this.search_type = search_type;
	}
	public String getSearch_keyword() {
		return search_keyword;
	}
	public void setSearch_keyword(String search_keyword) {
		this.search_keyword = search_keyword;
	}
	
}
