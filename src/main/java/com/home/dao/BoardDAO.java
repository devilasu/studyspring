package com.home.dao;

import java.util.List;

import com.home.vo.BoardVO;

public interface BoardDAO {
	List<BoardVO> selectBoard() throws Exception;
	List<BoardVO> selectBoard(String type) throws Exception;
}
