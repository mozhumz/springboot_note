package com.hyj.demo.po;

import lombok.Data;

import javax.persistence.*;

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
