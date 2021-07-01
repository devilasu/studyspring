package com.home.vo;

/**
 * 페이징처리를 위한 VO perPageNum, pageListNum, page, totalcount는 필수 값이다.
 * @author 김영제
 *
 */
public class PageVO {
	private int perPageNum = 5;		//한페이지당 게시물 수.		필수
	private int pageListNum = 3;	//페이징리스트 갯수			필수
	private int page = 1;			//현재페이지				필수
	private int totalcount;		//게시물 총 갯수.(페이징 리스트처리를 위해 필요.)	필수(세팅후 나머지 변수 자동 계산)
	private int startNum;		//시작페이지
	private int startPageNum;	//페이징리스트 시작값
	private int endPageNum;		//페이징리스트 마지막 값
	private boolean prev;		//페이징에서 이전칸으로 이동
	private boolean next;		//페이징에서 다음칸으로 이동
	
	@Override
	public String toString() {
		return "PageVO [perPageNum=" + perPageNum + ", pageListNum=" + pageListNum + ", page=" + page + ", totalcount="
				+ totalcount + ", startNum=" + startNum + ", prev=" + prev + ", next=" + next + "]";
	}
	public int getPerPageNum() {
		return perPageNum;
	}
	public void setPerPageNum(int perPageNum) {
		this.perPageNum = perPageNum;
	}
	public int getPageListNum() {
		return pageListNum;
	}
	public void setPageListNum(int pageListNum) {
		this.pageListNum = pageListNum;
	}
	public int getStartNum() {
		return startNum;
	}
	public void setStartNum(int startNum) {
		this.startNum = startNum;
	}
	
	public int getStartPageNum() {
		return startPageNum;
	}
	public void setStartPageNum(int startPageNum) {
		this.startPageNum = startPageNum;
	}
	public int getEndPageNum() {
		return endPageNum;
	}
	public void setEndPageNum(int endPageNum) {
		this.endPageNum = endPageNum;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getTotalcount() {
		return totalcount;
	}
	public void setTotalcount(int totalcount) {
		this.totalcount = totalcount;
		
		calcPaging();
	}
	public boolean isPrev() {
		return prev;
	}
	public void setPrev(boolean prev) {
		this.prev = prev;
	}
	public boolean isNext() {
		return next;
	}
	public void setNext(boolean next) {
		this.next = next;
	}
	
	public void calcPaging() {
		startNum = (page-1)*perPageNum;
		startPageNum = 1+(int)(Math.floor(page/pageListNum)*pageListNum);
		double tmp = Math.ceil(page/pageListNum)*pageListNum;
		double tmp2 = Math.ceil(totalcount/perPageNum);
		endPageNum = (tmp<tmp2)?(int)tmp:(int)tmp2;
		prev = (page>pageListNum)?true:false;
		next = (endPageNum%pageListNum==0)?true:false;
	}
	
}
