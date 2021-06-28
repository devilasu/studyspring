package com.home.service;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import com.home.vo.MenuVO;

@Service
public class AdminServiceImpl implements AdminService{
	@Inject
	private SqlSession sqlSession;
	@Override
	public List<MenuVO> selectAdminMenu(Integer parent) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList("adminMenuMapper.selectMenu", parent);
	}
	
}
