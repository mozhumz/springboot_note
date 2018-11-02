package com.hyj.demo.web.controller;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.hyj.demo.po.UserPO;
import com.hyj.demo.service.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(description = "user相关接口")
public class UserController {
  @Autowired
  IUserService service;

  @GetMapping("/getUserList")
  @ApiOperation(value = "获取user列表", notes = "查询mysql中的用户列表")
  public List<UserPO> getUserList() {
    List<UserPO> userList = service.getList();
    System.out.println(userList);
    return userList;
  }
  
  @PostMapping("/arrTest")
  public int addUserPO(@RequestBody Map<String,Object>params) {
    return  service.addUserPO(params);
  }
  
  @GetMapping("/addUserPOList")
  public int addUserPOList() {
    return  service.addUserPOList();
    
  }
}
