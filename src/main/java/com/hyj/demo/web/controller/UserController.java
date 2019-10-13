package com.hyj.demo.web.controller;

import com.hyj.demo.entity.po.po1.UserPO;
import com.hyj.demo.service.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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

	@GetMapping("/getMysqlUserList")
	@ApiOperation(value = "获取mysql user列表", notes = "查询mysql中的用户列表")
	public Map getMysqlUserList() {
		return service.getAllMysqlUser();
	}

	@PostMapping("/arrTest")
	public int addUserPO(@RequestBody Map<String, Object> params) {
		return service.addUserPO(params);
	}

	@GetMapping("/addUserPOList")
	public int addUserPOList() {
		return service.addUserPOList();
	}

	@GetMapping("/getOne")
	public UserPO getOne() {
		return service.getOneUser();
	}
	
	@PostMapping("/test1109")
	public UserPO test1106(UserPO us) {
		service.saveUser(us);
 		System.out.println(us);
		return us;
	}

	@GetMapping("/test0317")
	public Integer test0317() {
		return 1;
	}
	
	@ApiOperation(value = "用工单位管理-设岗单位列表-编辑设岗单位," +
            "name: 单位名称" +
            "     * limitOfPeople: 单位人数上限" +
            "     * monthlySalaryCap: 月发放工资上限" +
            "     * remark: 备注")
	@RequestMapping(value = "/haha", method = RequestMethod.POST)
	public UserPO test1106_post(@RequestParam("unitId") String unitId,@RequestBody UserPO us) {
		System.out.println(unitId);
		System.out.println(us);
		return us;
	}

}
