package com.duo.user.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.duo.common.po.Menu;
import com.duo.user.api.service.IMenuApiService;

/**
 * 提供用户信息数据
 * 
 * @Class Name UserController
 * @author yourname
 * @Create In 2017年7月11日
 */
@RestController
@RequestMapping("/menuapi")
public class MenuApiController {
	
	@Autowired
	private IMenuApiService menuService;
	
	
	 public String getCurrentUserId(){
       return "1";
   }
	
	@RequestMapping(value = "/{userId}/sys",method = RequestMethod.GET)
    @ResponseBody
    public String queryUserSys(@PathVariable("userId") String userId){
		try {
			List<Menu> list = menuService.findSysByUser(userId);
			return JSON.toJSONString(list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
    }
    
   
    @RequestMapping(value = "/{userId}/menu/parent/{parentId}",method = RequestMethod.GET)
    @ResponseBody
    public String queryUserLeftMenu(@PathVariable("userId") String userId,@PathVariable("parentId") String parentId){
    	List<Menu> list = menuService.getMenusByUserId(userId, parentId);
    	for (int i = 0; i < list.size(); i++) {
    		Menu menu = list.get(i);
    		List<Menu> childMenu = menuService.getMenusByUserId(userId, menu.getId());
    		menu.setChildren(childMenu);
		}
    	 return JSON.toJSONString(list);
    }
    
    
   
    @RequestMapping(value = "/{userId}/menu/list",method = RequestMethod.GET)
    @ResponseBody
    public String queryMenuList(@PathVariable("userId") String userId){
    	List<Menu> list = menuService.getMenusList(getCurrentUserId());
        return JSON.toJSONString(list);
    }
    
    @RequestMapping(value = "/{userId}/menu/all",method = RequestMethod.GET)
    @ResponseBody
    public String queryMenuAll(@PathVariable("userId") String userId){
    	List<Menu> list = menuService.getMenuAll(getCurrentUserId());
    	return JSON.toJSONString(list);
    }
    


    @RequestMapping(value = "/menu/save",method = RequestMethod.POST)
    @ResponseBody
    public int add(Menu entity){
       System.out.println("entity"+entity);
       return menuService.addMenu(getCurrentUserId(), entity);
    }
    
    @RequestMapping(value = "/menu/{id}",method = RequestMethod.GET)
    @ResponseBody
    public String getMenu(@PathVariable("id")String id){
       System.out.println("entity"+id);
       Menu menu = menuService.getMenu(id);
       return JSON.toJSONString(menu);
    }
    
    @RequestMapping(value = "/menu/{id}",method = RequestMethod.DELETE)
    @ResponseBody
    public int deleteMenu(@PathVariable("id")String id){
       System.out.println("entity"+id);
       return menuService.deleteMenu(getCurrentUserId(), id);
    }
    
    @RequestMapping(value = "/menu/update",method = RequestMethod.PUT)
    @ResponseBody
    public int updateMenu(Menu menu){
       System.out.println("entity"+menu);
       return menuService.updateMenu(getCurrentUserId(), menu);
    }
}
