package com.hyj.demo.dao.mapper.mapper1;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.hyj.demo.entity.po.po1.UserPO;

public interface IUserMapper {
  List<UserPO> getUserList();
  int addUserPO(Map<String,Object>map);
  int insertList(@Param("list")List<UserPO> polist);
}
