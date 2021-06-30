package com.home.service;

import java.util.List;

import com.home.vo.MenuVO;
/**
 * 서비스 인터페이스
 * @author 김영제
 *
 */
public interface AdminService {
	public int insertMenu(MenuVO menuVO) throws Exception;
	public int deleteMenu(String menu_type) throws Exception;
	public int updateMenu(MenuVO menuVO) throws Exception;
	public List<MenuVO> selectMenu(Integer parent) throws Exception;
	public MenuVO readMenu(String menu_type) throws Exception;
}
