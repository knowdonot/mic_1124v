package com.duo.user.agent.rpc;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.duo.common.po.Menu;


/**
 * ${DESCRIPTION}
 *
 */
@FeignClient("sys-api")
@RequestMapping("menuapi")
public interface IMenuService {
 
  @RequestMapping(value = "/{userId}/sys", method = RequestMethod.GET)
  public String getSysByUser(@PathVariable("userId") String userId);
  
  @RequestMapping(value = "/{userId}/menu/parent/{parentId}", method = RequestMethod.GET)
  public String getMenusByuserId(@PathVariable("userId") String userId,@PathVariable("parentId") String parentId);
  
  
  @RequestMapping(value = "/{userId}/menu/list", method = RequestMethod.GET)
  public String getMenusList(@PathVariable("userId") String userId);
  
  @RequestMapping(value = "/{userId}/menu/all", method = RequestMethod.GET)
  public String getMenuAll(@RequestParam(value = "userId",required=false) String userId);
  
  
  @RequestMapping(value = "/menu/save", method = RequestMethod.POST)
  public int addMenu(@RequestBody Menu menu);
  
  @RequestMapping(value = "/menu/{id}", method = RequestMethod.DELETE)
  public int deleteMenu(@PathVariable("id")String id);
  
  @RequestMapping(value = "/menu/update", method = RequestMethod.PUT)
  public int updateMenu(@RequestBody Menu menu);
  
  @RequestMapping(value = "/menu/{id}", method = RequestMethod.GET)
  public String getMenu(@PathVariable("id") String id);
  
  
  
}
