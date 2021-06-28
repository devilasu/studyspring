package com.home.dao;

import java.util.List;

import com.home.vo.MenuVO;

/**
 * AdminMenuDAO입니다.
 * @author 김영제
 *
 */
public interface AdminMenuDAO {
	public int insertMenu(MenuVO menuVO) throws Exception;
	public int deleteMenu(MenuVO menuVO) throws Exception;
	public int updateMenu(MenuVO menuVO) throws Exception;
	public List<MenuVO> selectMenu(Integer parent) throws Exception;
	public MenuVO readMenu(Integer menuIndex) throws Exception;
}
