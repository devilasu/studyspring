package com.home.service;

import java.util.List;

import com.home.vo.BoardVO;
import com.home.vo.SearchVO;

public interface BoardService {
	List<BoardVO> selectBoard() throws Exception;
	List<BoardVO> selectBoard(SearchVO searchVO) throws Exception;
}
