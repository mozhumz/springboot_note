package com.hyj.demo.dao.mapper.mapper1;

import com.hyj.demo.entity.po.po1.UserPO;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface IUserMapper {
  List<UserPO> getUserList();
  int addUserPO(Map<String,Object>map);
  int insertList(@Param("list")List<UserPO> polist);
}
