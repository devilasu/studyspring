package com.home.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.home.vo.BoardVO;
import com.home.vo.SearchVO;

@Repository
public class BoardDAOImpl implements BoardDAO{
	@Inject
	SqlSession sqlSession;
	@Override
	public List<BoardVO> selectBoard() throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList("boardMapper.selectBoard");
	}
	@Override
	public List<BoardVO> selectBoard(SearchVO searchVO) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList("boardMapper.selectBoard", searchVO);
	}
}