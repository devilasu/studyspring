package com.home.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;

import com.home.vo.BoardTypeVO;

public class BoardTypeDAOImpl implements BoardTypeDAO{
	@Inject
	private SqlSession sqlSession;
	@Override
	public BoardTypeVO readBoardType(String board_type) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("boardTypeMapper.readBoardType", board_type);
	}

	@Override
	public List<BoardTypeVO> selectBoardType() throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList("boardTypeMapper.selectBoardType");
	}

	@Override
	public int insertBoardType(BoardTypeVO boardTypeVO) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.insert("boardTypeMapper.insertBoardType",boardTypeVO);
	}

	@Override
	public int deleteBoardType(String boardType) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateBoardType(BoardTypeVO boardTypeVO) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

}
