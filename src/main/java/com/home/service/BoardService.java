package com.home.service;

import java.util.List;

import com.home.vo.BoardVO;
import com.home.vo.SearchVO;

public interface BoardService {
	Integer deleteBoard(Integer idx) throws Exception;
	int insertBoard(BoardVO boardVO) throws Exception;
	List<BoardVO> selectBoard() throws Exception;
	BoardVO selectBoard(Integer idx) throws Exception;
	List<BoardVO> selectBoard(String type) throws Exception;
	List<BoardVO> searchBoard(SearchVO searchVO) throws Exception;
}
