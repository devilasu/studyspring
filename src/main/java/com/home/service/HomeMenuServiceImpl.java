package com.home.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.home.dao.HomeMenuDAO;
import com.home.vo.MenuVO;

@Service
public class HomeMenuServiceImpl implements HomeMenuService{

	@Inject
	HomeMenuDAO menuDAO;
	
	@Override
	public List<MenuVO> selectHomeMenu(Integer parent) throws Exception {
		// TODO Auto-generated method stub
		return menuDAO.selectMenu(parent);
	}
}
