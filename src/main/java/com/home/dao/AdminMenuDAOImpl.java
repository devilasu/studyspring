package com.home.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.home.vo.MenuVO;
/**
 * 관리자메뉴 DAO Impl입니다.
 * @author 김영제
 *
 */

@Repository
public class AdminMenuDAOImpl implements AdminMenuDAO{
	@Inject
	SqlSession sqlSession;
	
	@Override
	public int insertMenu(MenuVO menuVO) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.insert("adminMenuMapper.insert",menuVO);
	}

	@Override
	public int deleteMenu(String menu_type) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.delete("adminMenuMapper.delete",menu_type);
	}

	@Override
	public int updateMenu(MenuVO menuVO) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.update("adminMenuMapper.update",menuVO);
	}

	@Override
	public List<MenuVO> selectMenu(Integer parent) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList("adminMenuMapper.selectParent",parent);
	}

	@Override
	public MenuVO readMenu(String menu_type) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("adminMenuMapper.read", menu_type);
	}

}
