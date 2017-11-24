package com.duo.user.agent.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.duo.common.po.User;
import com.duo.common.util.AESCode;
import com.duo.common.util.DateUtils;
import com.duo.common.util.IdGen;
import com.duo.user.agent.rpc.ILoginService;

/**
 * 提供用户信息数据
 * 
 * @Class Name UserController
 * @author yourname
 * @Create In 2017年7月11日
 */
@RestController
@RequestMapping("")
public class LoginController {

	@Autowired
	private ILoginService loginService;
	
	@Value("${login.url}")
	private String indexUrl ;
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String toLogin() {
		return "login";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String loginSubmit(@RequestParam(value = "username") String username,@RequestParam(value = "password") String password,
			HttpServletResponse response,HttpServletRequest request) {
		password = AESCode.encrypt(password);
		System.out.println("sessionId============"+request.getSession().getId());
		User user = loginService.login(username, password);
		if(user == null){
			return "用户名或密码错误";
		}else{
			try {
				StringBuffer token = new StringBuffer();
				username = AESCode.encrypt(username);
				String userKey = AESCode.encrypt(user.getId());
				token.append(userKey).append(DateUtils.formatDate(new Date(), "yyyyMMddHHmmss"))
						.append(IdGen.uuid());
				//登录成功查询用户角色、菜单写入缓存
				request.getSession().setAttribute("token", token.toString());
				String url ;
				if(indexUrl == null){
					url = "http://localhost:5555/admin/index";
				}else{
					url = indexUrl;
				}
				response.sendRedirect(url);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return "1";
	}           


}
