package com.home.service;

import java.util.List;

import com.home.vo.MenuVO;
/**
 * 서비스 인터페이스
 * @author 김영제
 *
 */
public interface AdminService {
	public int insertAdminMenu(MenuVO menuVO) throws Exception;
	public int deleteAdminMenu(MenuVO menuVO) throws Exception;
	public int updateAdminMenu(MenuVO menuVO) throws Exception;
	public List<MenuVO> selectAdminMenu(Integer parent) throws Exception;
	public MenuVO readAdminMenu(String menu_type) throws Exception;
}
