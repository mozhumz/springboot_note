package com.hyj.demo.mapper;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.hyj.demo.po.UserPO;

public interface IUserMapper {
  List<UserPO> getUserList();
  int addUserPO(Map<String,Object>map);
  int insertList(@Param("list")List<UserPO> polist);
}
