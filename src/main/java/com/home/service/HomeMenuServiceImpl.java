package com.home.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.home.dao.HomeMenuDAO;
import com.home.vo.MenuVO;

@Service
public class HomeMenuServiceImpl implements HomeMenuService{
	@Inject
	HomeMenuDAO homeMenuDAO;
	@Override
	public int insertMenu(MenuVO menuVO) throws Exception {
		// TODO Auto-generated method stub
		return homeMenuDAO.insertMenu(menuVO);
	}

	@Override
	public int deleteMenu(String menu_type) throws Exception {
		// TODO Auto-generated method stub
		return homeMenuDAO.deleteMenu(menu_type);
	}

	@Override
	public int updateMenu(MenuVO menuVO) throws Exception {
		// TODO Auto-generated method stub
		return homeMenuDAO.updateMenu(menuVO);
	}

	@Override
	public List<MenuVO> selectMenu(Integer parent) throws Exception {
		// TODO Auto-generated method stub
		return homeMenuDAO.selectMenu(parent);
	}

	@Override
	public MenuVO readMenu(String menu_type) throws Exception {
		// TODO Auto-generated method stub
		return homeMenuDAO.readMenu(menu_type);
	}
	
}
