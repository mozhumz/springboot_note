package com.hyj.demo.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import com.hyj.demo.mapper.IUserMapper;
import com.hyj.demo.po.UserPO;
import com.hyj.demo.service.IUserService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
@Service
public class UserServiceImpl implements IUserService {
  @Resource
  IUserMapper userMapper;

  @Override
  public List<UserPO> getList() {
    // TODO Auto-generated method stub
    List<UserPO>list=userMapper.getUserList();
//    JSONArray arr =new JSONArray(list.get(0).getArr());
//    List<Map<String,Object>>arr =(List<Map<String,Object>>)list.get(0).getArr();
    for(UserPO user : list) {
        
      JSONArray  arr=net.sf.json.JSONArray.fromObject(user.getArr());
      List arrlist =new ArrayList<>();
      for(int i=0;i<arr.size();i++) {
        arrlist.add(arr.getJSONObject(i));
      }
      
//      user.setArrList(arrlist);
//      for(JSONObject obj : arr.iterator().) {
//        
//      }
      System.out.println("list: "+list);
    }
    return list;
  }

  @Override
  public int addUserPO(Map<String, Object> params) {
    // TODO Auto-generated method stub
    try {
      System.out.println(params);
//      String arr=params.get("arr")+"";
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
      List<UserPO>list=new ArrayList<>();
      for(int i=0;i<3;i++) {
        UserPO po =new UserPO("name"+i,""+i,"arr"+i);
        list.add(po);
      }
      int lines=userMapper.insertList(list);
      System.out.println(lines);
      
    } catch (Exception e) {
      e.printStackTrace();
    }
    return 0;
  }

  @Override
  @Scheduled(initialDelay=1000*100,fixedRate=1000*100)
  public void testSchedule() {
    // TODO Auto-generated method stub
    System.out.println("service testSchedule ok");
    
  }

}
