package com.duo.user.agent.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.duo.common.po.Menu;
import com.duo.common.util.AESCode;
import com.duo.user.agent.rpc.IMenuService;

/**
 * 提供用户信息数据
 * 
 * @Class Name UserController
 * @author yourname
 * @Create In 2017年7月11日
 */
@RestController
@RequestMapping("/menu")
public class MenuController {

	String url = "http://localhost:5555/admin/index";
	
	@Autowired
	private IMenuService menuService;

	@RequestMapping(value = "/user/parent/{parentId}", method = RequestMethod.GET)
	@ResponseBody
	public String getUserMenu(@RequestParam(defaultValue = "1") String parentId,
			HttpServletRequest req,HttpServletResponse res) {
		
		return menuService.getMenusByuserId(getCurrentUserId(req,res), parentId);
	}

	@RequestMapping(value = "/user/sys", method = RequestMethod.GET)
	@ResponseBody
	public String getUserTopMenu(HttpServletRequest req,HttpServletResponse res) {
		return menuService.getSysByUser(getCurrentUserId(req,res));
	}

	@RequestMapping(value = "/user/list", method = RequestMethod.GET)
	@ResponseBody
	public String getMenuList(HttpServletRequest req,HttpServletResponse res) {
		return menuService.getMenusList(getCurrentUserId(req,res));
	}

	@RequestMapping(value = "/user/all", method = RequestMethod.GET)
	@ResponseBody
	public String getMenuAll(HttpServletRequest req,HttpServletResponse res) {
		return menuService.getMenuAll(getCurrentUserId(req,res));
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	@ResponseBody
	public int add(Menu entity) {
		System.out.println("entity" + entity);
		return menuService.addMenu(entity);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public String getMenu(@PathVariable("id") String id) {
		System.out.println("entity" + id);
		return menuService.getMenu(id);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	public int deleteMenu(@PathVariable("id") String id) {
		System.out.println("entity" + id);
		return menuService.deleteMenu(id);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	@ResponseBody
	public int updateMenu(@PathVariable("id") String id, Menu menu) {
		System.out.println("entity" + menu);
		return menuService.updateMenu(menu);
	}

	/**
	 * 获取当前用户id
	 * @param req
	 * @return
	 */
	public String getCurrentUserId(HttpServletRequest req,HttpServletResponse res) {
		try {
			System.out.println("sessionId====2========"+req.getSession().getId());
			String token = req.getSession().getAttribute("token").toString();
			if(token == null){
				System.out.println("========token ==========="+token);
				//解密token
				String tokenStr = AESCode.decrypt(token);
				System.out.println("========token after==========="+tokenStr);
				String userId = tokenStr.substring(0,tokenStr.indexOf(";"));
				if(userId == null){
					res.sendRedirect(url);
				}else{
					return userId;
				}
			}else{
				res.sendRedirect(url);
			}
		} catch (Exception e) {
			e.printStackTrace();
			try {
				res.sendRedirect(url);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			return "";
		}
		return url;
		
	}

}
