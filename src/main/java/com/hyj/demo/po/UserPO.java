package com.hyj.demo.po;

import java.util.List;
import java.util.Map;
import lombok.Data;
import net.sf.json.JSONObject;

@Data
public class UserPO {
  
  private String id;
  private String name;
  private String age;
  private String arr;
  public UserPO(String name, String age, String arr) {
    super();
    this.name = name;
    this.age = age;
    this.arr = arr;
  }
  public UserPO() {
    super();
    // TODO Auto-generated constructor stub
  }
  
  
}

