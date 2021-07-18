package com.home.service;

import java.util.List;

import com.home.vo.BoardVO;
import com.home.vo.SearchVO;

public interface BoardService {
	int insertBoard(BoardVO boardVO) throws Exception;
	List<BoardVO> selectBoard() throws Exception;
	List<BoardVO> selectBoard(String type) throws Exception;
	List<BoardVO> searchBoard(SearchVO searchVO) throws Exception;
}
