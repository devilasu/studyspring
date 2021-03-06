package com.home.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.home.vo.MenuVO;

@Repository
public class HomeMenuDAOImpl implements HomeMenuDAO {
	@Inject
	SqlSession sqlSession;

	@Override
	public int insertMenu(MenuVO menuVO) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.insert("homeMenuMapper.insert", menuVO);
	}

	@Override
	public int deleteMenu(String menu_type) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.delete("hoemMenuMapper.delete",menu_type);
	}

	@Override
	public int updateMenu(MenuVO menuVO) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.update("homeMenuMapper.update", menuVO);
	}

	@Override
	public List<MenuVO> selectMenu(Integer parent) throws Exception {
		// parent는 null이면 최상위 메뉴.
		return sqlSession.selectList("homeMenuMapper.selectParent", parent);
	}

	@Override
	public MenuVO readMenu(String menu_type) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("homeMenuMapper.readType",menu_type);
	}

}
