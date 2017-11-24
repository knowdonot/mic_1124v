package com.duo.user.api.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.duo.common.po.Menu;
import com.duo.user.api.dao.MenuDao;
import com.duo.user.api.service.IMenuApiService;
@Service
public class MenuApiServiceImpl implements IMenuApiService {
	
	@Autowired
	private MenuDao menuDao;

	@Override
	public List<Menu> findSysByUser(String userId) {
		return menuDao.findUserSysByUserId(userId);
	}

	@Override
	public List<Menu> getMenusByUserId(String userId, String parentId) {
		Menu menu = new Menu();
		menu.setUserId(userId);
		menu.setParentId(parentId);
		return menuDao.findMenuByway(menu);
	}

	@Override
	public List<Menu> getMenusList(String userId) {
		return menuDao.findUserMenusByUserId(userId);
	}

	@Override
	public List<Menu> getMenuAll(String userId) {
		return menuDao.findMenuSelect(userId);
	}

	@Override
	public int addMenu(String username, Menu menu) {
		
		return menuDao.insert(menu);
	}

	@Override
	public int deleteMenu(String username, String id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateMenu(String username, Menu menu) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Menu getMenu(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	
	

}
