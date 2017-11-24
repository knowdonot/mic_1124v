package com.duo.user.api.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.duo.common.dao.BaseDao;
import com.duo.common.po.Menu;
/**
 * 
 * @author Josiah
 *
 */
@Mapper
public interface MenuDao extends BaseDao<Menu>{
	

	/**
	 * 根据条件查询查询，userId必填，无层级关系
	 * 2017年7月25日
	 * By duoduo
	 * @param menu
	 * @return
	 */
	public List<Menu> findMenuByway(Menu menu);
	
	/**
	 * 
	 * @param userId
	 * @return
	 */
	public List<Menu> findMenuSelect(String userId);
	
	
	/**
	 * 获取用户菜单
	 * 2017年7月18日
	 * By duoduo
	 * @param id
	 * @return
	 */
	public List<Menu> findUserMenusByUserId(String userId);
	
	/**
	 * @author Josiah
	 * @param userId
	 * @return
	 */
	public List<Menu> findUserSysByUserId(String userId);
}
