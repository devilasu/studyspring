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

	@Override
	public List<BoardVO> selectBoard(SearchVO searchVO) throws Exception {
		// TODO Auto-generated method stub
		return boardDAO.selectBoard(searchVO);
	}

}
