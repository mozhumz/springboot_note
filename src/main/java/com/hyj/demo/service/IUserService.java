package com.hyj.demo.service;

import com.hyj.demo.entity.po.po1.UserPO;

import java.util.List;
import java.util.Map;

public interface IUserService {
  List<UserPO> getList();
  int addUserPO(Map<String,Object>params);
  int addUserPOList();
  void testSchedule();
  Map getAllMysqlUser();
  UserPO getOneUser();
  void saveUser(UserPO userPO);
}
