package com.hyj.demo.po;

import java.util.List;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import net.sf.json.JSONObject;

@Data
@Entity
@Table(name="user_po")
public class UserPO2 {
	
	@Id
	@GeneratedValue
	private String id;
	
	@Column
	private String name;
	@Column
	private String age;
	@Column(columnDefinition="createTime")
	private Long createTime;
	@Column(columnDefinition="updateTime")
	private Long updateTime;
	@Column(columnDefinition="arr")
	private String arr;
	
	
	
//	public List<UserVO> getArr() {
//		return arr;
//	}
//	public void setArr(String arr) {
//		if(arr!=null&&!"".equals(arr)) {
//			net.sf.json.JSONArray jsonArray = net.sf.json.JSONArray.fromObject(arr);
//			List<UserVO> inCpList = (List) net.sf.json.JSONArray.toCollection(jsonArray, UserVO.class);
//			this.arr = inCpList;
//		}
//	}


}
