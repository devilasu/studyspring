package com.home.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.home.dao.BoardTypeDAO;
import com.home.vo.BoardTypeVO;

@Service
public class BoardTypeServiceImpl implements BoardTypeService{
	@Inject
	private BoardTypeDAO boardTypeDAO;
	@Override
	public List<BoardTypeVO> selectBoardType() throws Exception {
		// TODO Auto-generated method stub
		return boardTypeDAO.selectBoardType();
	}

	@Override
	public BoardTypeVO readBoardType(String board_type) throws Exception {
		// TODO Auto-generated method stub
		return boardTypeDAO.readBoardType(board_type);
	}

	@Override
	public int insertBoardType(BoardTypeVO boardTypeVO) throws Exception {
		// TODO Auto-generated method stub
		return boardTypeDAO.insertBoardType(boardTypeVO);
	}

	@Override
	public int deleteBoardType(String board_type) throws Exception {
		// TODO Auto-generated method stub
		return boardTypeDAO.deleteBoardType(board_type);
	}

	@Override
	public int updateBoardType(BoardTypeVO boardTypeVO) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

}
