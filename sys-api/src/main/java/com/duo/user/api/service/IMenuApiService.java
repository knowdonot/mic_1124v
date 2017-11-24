package com.duo.user.api.service;

import java.util.List;

import com.duo.common.po.Menu;

public interface IMenuApiService {

	  public List<Menu> findSysByUser(String userId);
	  
	  public List<Menu> getMenusByUserId(String userId,String parentId);
	  
	  public List<Menu> getMenusList(String userId);
	  
	  public List<Menu> getMenuAll(String name);
	  
	  public int addMenu(String userId,Menu menu);
	  
	  public int deleteMenu(String userId,String id);
	  
	  public int updateMenu(String userId,Menu menu);
	  
	  public Menu getMenu(String id);
	  

}
