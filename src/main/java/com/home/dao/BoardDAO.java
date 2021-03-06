package com.home.dao;

import java.util.List;

import com.home.vo.BoardVO;
import com.home.vo.SearchVO;

public interface BoardDAO {
	int insertBoard(BoardVO boardVO) throws Exception;
	Integer deleteBoard(Integer idx) throws Exception;
	List<BoardVO> selectBoard() throws Exception;
	BoardVO selectBoard(Integer idx) throws Exception;
	List<BoardVO> selectBoard(String type) throws Exception;
	List<BoardVO> selectBoard(SearchVO searchVO) throws Exception;
	int totalCount(SearchVO searchVO) throws Exception;
}
