package com.home.service;

import java.util.List;

import com.home.vo.MenuVO;

public interface HomeMenuService  {
	public List<MenuVO> selectHomeMenu(Integer parent) throws Exception;
}
