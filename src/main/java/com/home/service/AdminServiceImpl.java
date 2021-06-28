package com.home.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.home.dao.AdminMenuDAO;
import com.home.vo.MenuVO;

@Service
public class AdminServiceImpl implements AdminService{
	@Inject
	private AdminMenuDAO adminMenuDAO;

	@Override
	public int insertAdminMenu(MenuVO menuVO) throws Exception {
		// TODO Auto-generated method stub
		return adminMenuDAO.insertMenu(menuVO);
	}

	@Override
	public int deleteAdminMenu(MenuVO menuVO) throws Exception {
		// TODO Auto-generated method stub
		return adminMenuDAO.deleteMenu(menuVO);
	}

	@Override
	public int updateAdminMenu(MenuVO menuVO) throws Exception {
		// TODO Auto-generated method stub
		return adminMenuDAO.updateMenu(menuVO);
	}

	@Override
	public List<MenuVO> selectAdminMenu(Integer parent) throws Exception {
		// TODO Auto-generated method stub
		return adminMenuDAO.selectMenu(parent);
	}

	@Override
	public MenuVO readAdminMenu(String menu_type) throws Exception {
		// TODO Auto-generated method stub
		return adminMenuDAO.readMenu(menu_type);
	}
	
	
}
