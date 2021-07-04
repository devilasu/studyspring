package com.home.dao;

import java.util.List;

import com.home.vo.BoardVO;
import com.home.vo.SearchVO;

public interface BoardDAO {
	List<BoardVO> selectBoard() throws Exception;
	List<BoardVO> selectBoard(SearchVO searchVO) throws Exception;
}