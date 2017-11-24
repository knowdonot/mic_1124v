package com.duo.user.agent.rpc;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * ${DESCRIPTION}
 *
 */
@FeignClient(name = "admin-ui")
//@RequestMapping("loginapi")
public interface IUIService {
 
  
  @RequestMapping(value = "/index",method = RequestMethod.GET)
  public String index();
  
  
}
