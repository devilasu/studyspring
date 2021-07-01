package com.home.service;

import java.util.List;

import com.home.vo.BoardVO;

public interface BoardService {
	List<BoardVO> selectBoard() throws Exception;
	List<BoardVO> selectBoard(String type) throws Exception;
}
