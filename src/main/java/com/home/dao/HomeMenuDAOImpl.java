package com.home.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.home.vo.MenuVO;
/**
 * 홈메뉴 DAO Impl 입니다.
 * @author 김영제
 *
 */
@Repository
public class HomeMenuDAOImpl implements HomeMenuDAO{
	
	@Inject
	SqlSession sqlSession;

	@Override
	public int insertMenu(MenuVO menuVO) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.insert("homeMenuMapper.insertMenu",menuVO);
	}

	@Override
	public int deleteMenu(MenuVO menuVO) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.delete("homeMenuMapper.deleteMenu",menuVO);
	}

	@Override
	public int updateMenu(MenuVO menuVO) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.update("homeMenuMapper.updateMenu",menuVO);
	}

	@Override
	public List<MenuVO> selectMenu(Integer parent) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList("homeMenuMapper.selectMenu",parent);
	}

	@Override
	public MenuVO readMenu(Integer menuIndex) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("menuMapper.readMenu",menuIndex);
	}
	
	

}
