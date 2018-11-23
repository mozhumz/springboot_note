package com.hyj.demo.service;

import java.util.List;
import java.util.Map;
import com.hyj.demo.entity.po.po1.UserPO;

public interface IUserService {
  List<UserPO> getList();
  int addUserPO(Map<String,Object>params);
  int addUserPOList();
  void testSchedule();
  Map getAllMysqlUser();
  UserPO getOneUser();
  void saveUser(UserPO userPO);
}
