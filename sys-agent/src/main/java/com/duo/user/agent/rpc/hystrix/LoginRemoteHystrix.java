package com.duo.user.agent.rpc.hystrix;

import org.springframework.stereotype.Component;

import com.duo.common.po.User;
import com.duo.user.agent.rpc.ILoginService;

@Component
public class LoginRemoteHystrix implements ILoginService{

	@Override
	public User login(String username, String password) {
		System.out.println("请求异常");
		return null;
	}


}
