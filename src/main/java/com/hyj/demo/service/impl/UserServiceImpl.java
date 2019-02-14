package com.hyj.demo.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;

import com.hyj.demo.dao.mapper.mapper2.IMysqlMapper;
import com.hyj.demo.dao.repositry.repositry1.IUserRepositry;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import com.hyj.demo.dao.mapper.mapper1.IUserMapper;
import com.hyj.demo.entity.po.po1.UserPO;
import com.hyj.demo.service.IUserService;
import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;

import net.sf.json.JSONArray;

@Service
public class UserServiceImpl implements IUserService {
	@Resource
	IUserMapper userMapper;

	@Resource
	IMysqlMapper mysqlMapper;

	@Resource
	IUserRepositry userRepositry;

	@Override
	public List<UserPO> getList() {
		// TODO Auto-generated method stub
		List<UserPO> list = userMapper.getUserList();
		// JSONArray arr =new JSONArray(list.get(0).getArr());
		// List<Map<String,Object>>arr =(List<Map<String,Object>>)list.get(0).getArr();
		for (UserPO user : list) {

			JSONArray arr = net.sf.json.JSONArray.fromObject(user.getArr());
			List arrlist = new ArrayList<>();
			for (int i = 0; i < arr.size(); i++) {
				arrlist.add(arr.getJSONObject(i));
			}

			// user.setArrList(arrlist);
			// for(JSONObject obj : arr.iterator().) {
			//
			// }
			System.out.println("list: " + list);
		}
		return list;
	}

	@Override
	public int addUserPO(Map<String, Object> params) {
		// TODO Auto-generated method stub
		try {
			System.out.println(params);
			// String arr=params.get("arr")+"";
			params.put("arr", com.alibaba.fastjson.JSONObject.toJSONString(params.get("arr")));
			System.out.println(userMapper.addUserPO(params));
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
		return 0;
	}

	@Override
	public int addUserPOList() {
		try {
			List<UserPO> list = new ArrayList<>();
			for (int i = 0; i < 3; i++) {
				UserPO po = new UserPO("name" + i, "" + i, "arr" + i);
				list.add(po);
			}
			int lines = userMapper.insertList(list);
			System.out.println(lines);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	@Scheduled(cron = "0 0 2 1 * ?")
	public void testSchedule() {
		// TODO Auto-generated method stub
		System.out.println("service testSchedule ok");

	}

	@Override
	public Map getAllMysqlUser() {
		Map<String, Object> res = new HashMap<>();
		List list = mysqlMapper.findAllUser();
		res.put("data", list);
		return res;
	}

	@Override
	public UserPO getOneUser() {
		UserPO po = new UserPO();
		// System.out.println(userRepositry.findOne(1));
		return po;
	}

	@Override
	public void saveUser(UserPO userPO) {
		// TODO Auto-generated method stub
		try {

			userRepositry.save(userPO);
		} catch (DataIntegrityViolationException e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("----------------------------------");
			System.out.println(e.getMessage());
		}
		System.out.println(userPO);
	}

}
