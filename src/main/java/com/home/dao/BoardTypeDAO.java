package com.home.dao;

import java.util.List;

import com.home.vo.BoardTypeVO;

public interface BoardTypeDAO {
	BoardTypeVO readBoardType(String board_type) throws Exception;
	List<BoardTypeVO> selectBoardType() throws Exception;
	int insertBoardType(BoardTypeVO boardTypeVO) throws Exception;
	int deleteBoardType(String boardType) throws Exception;
	int updateBoardType(BoardTypeVO boardTypeVO) throws Exception;
}
