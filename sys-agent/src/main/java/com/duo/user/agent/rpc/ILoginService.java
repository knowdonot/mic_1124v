package com.duo.user.agent.rpc;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.duo.common.po.User;
import com.duo.user.agent.rpc.hystrix.LoginRemoteHystrix;


/**
 * ${DESCRIPTION}
 *
 */
@FeignClient(name = "sys-api",fallback = LoginRemoteHystrix.class)
public interface ILoginService {
 
  
  @RequestMapping(value = "/loginapi/login",method = RequestMethod.POST)
  public User login(@RequestParam(value = "username") String username,@RequestParam(value = "password") String password);
  
  
}
