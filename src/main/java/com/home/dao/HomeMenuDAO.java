package com.home.dao;

import java.util.List;

import com.home.vo.MenuVO;
/**
 * 홈 메뉴 DAO 인터페이스 입니다.
 * @author 김영제
 *
 */
public interface HomeMenuDAO {
	public int insertMenu(MenuVO menuVO) throws Exception;
	public int deleteMenu(MenuVO menuVO) throws Exception;
	public int updateMenu(MenuVO menuVO) throws Exception;
	public List<MenuVO> selectMenu(Integer parent) throws Exception;
	public MenuVO readMenu(String menu_type) throws Exception;
}
