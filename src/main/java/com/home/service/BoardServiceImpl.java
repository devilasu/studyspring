package com.home.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.home.dao.BoardDAO;
import com.home.vo.BoardVO;
import com.home.vo.SearchVO;

@Service
public class BoardServiceImpl implements BoardService{
	@Inject
	BoardDAO boardDAO;
	
	@Override
	public List<BoardVO> selectBoard() throws Exception {
		// TODO Auto-generated method stub
		return boardDAO.selectBoard();
	}
	
	public List<BoardVO> selectBoard(String type) throws Exception {
		// TODO Auto-generated method stub
		return boardDAO.selectBoard(type);
	}

	@Override
	public List<BoardVO> searchBoard(SearchVO searchVO) throws Exception {
		// TODO Auto-generated method stub
		return boardDAO.selectBoard(searchVO);
	}

}
