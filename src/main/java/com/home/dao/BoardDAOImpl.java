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
	public Integer deleteBoard(Integer idx) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.delete("boardMapper.delete",idx);
	}
	
	@Override
	public int insertBoard(BoardVO boardVO) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.insert("boardMapper.insert",boardVO); 
		return boardVO.getIdx();
	}
	
	@Override
	public List<BoardVO> selectBoard() throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList("boardMapper.selectAll");
	}
	
	@Override
	public List<BoardVO> selectBoard(String type) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList("boardMapper.selectType", type);
	}
	
	@Override
	public List<BoardVO> selectBoard(SearchVO searchVO) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList("boardMapper.selectSearchVO", searchVO);
	}

	@Override
	public BoardVO selectBoard(Integer idx) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("boardMapper.selectIdx",idx);
	}
	
	@Override
	public int totalCount(SearchVO searchVO) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("boardMapper.totalCount",searchVO);
	}

}
