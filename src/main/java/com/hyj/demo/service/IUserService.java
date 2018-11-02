package com.hyj.demo.service;

import java.util.List;
import java.util.Map;
import com.hyj.demo.po.UserPO;

public interface IUserService {
  List<UserPO> getList();
  int addUserPO(Map<String,Object>params);
  int addUserPOList();
  void testSchedule();
}
