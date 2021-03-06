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
	public Integer deleteBoard(Integer idx) throws Exception {
		// TODO Auto-generated method stub
		return boardDAO.deleteBoard(idx);
	}
	
	@Override
	public int insertBoard(BoardVO boardVO) throws Exception {
		// TODO Auto-generated method stub
		return boardDAO.insertBoard(boardVO);
	}
	
	@Override
	public List<BoardVO> selectBoard() throws Exception {
		// TODO Auto-generated method stub
		return boardDAO.selectBoard();
	}
	
	@Override
	public BoardVO selectBoard(Integer idx) throws Exception {
		// TODO Auto-generated method stub
		return boardDAO.selectBoard(idx);
	}
	
	public List<BoardVO> selectBoard(String type) throws Exception {
		// TODO Auto-generated method stub
		return boardDAO.selectBoard(type);
	}

	@Override
	public List<BoardVO> searchBoard(SearchVO searchVO) throws Exception {
		// TODO searchVO값을 받아 검색과 페이징 처리.
		searchVO.getPageVO().setTotalcount(boardDAO.totalCount(searchVO));
		return boardDAO.selectBoard(searchVO);
	}

}
