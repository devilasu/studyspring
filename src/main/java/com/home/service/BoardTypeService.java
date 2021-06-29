package com.home.service;

import java.util.List;

import com.home.vo.BoardTypeVO;

public interface BoardTypeService {
	List<BoardTypeVO> selectBoardType() throws Exception;
	BoardTypeVO readBoardType(String board_type) throws Exception;
	int insertBoardType(BoardTypeVO boardTypeVO) throws Exception;
	int deleteBoardType(String board_type) throws Exception;
	int updateBoardType(BoardTypeVO boardTypeVO) throws Exception;
}
