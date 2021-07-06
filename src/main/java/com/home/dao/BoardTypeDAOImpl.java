package com.home.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.home.vo.BoardTypeVO;

@Repository
public class BoardTypeDAOImpl implements BoardTypeDAO{
	@Inject
	private SqlSession sqlSession;
	@Override
	public BoardTypeVO readBoardType(String board_type) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("boardTypeMapper.readType", board_type);
	}

	@Override
	public List<BoardTypeVO> selectBoardType() throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList("boardTypeMapper.selectAll");
	}

	@Override
	public int insertBoardType(BoardTypeVO boardTypeVO) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.insert("boardTypeMapper.insert",boardTypeVO);
	}

	@Override
	public int deleteBoardType(String board_type) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.delete("boardTypeMapper.delete",board_type);
	}

	@Override
	public int updateBoardType(BoardTypeVO boardTypeVO) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.update("boardTypeMapper.update",boardTypeVO);
	}

}
