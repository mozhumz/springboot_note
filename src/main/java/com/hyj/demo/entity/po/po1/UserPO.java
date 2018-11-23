package com.hyj.demo.entity.po.po1;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.sun.javafx.beans.IDProperty;
import lombok.Data;
import net.sf.json.JSONObject;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "user_po")
public class UserPO implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@Column
	private String name;
	@Column
	private String age;
	@Column
	private String arr;
	
	@Column
	private String json;
	
	@Column
	private String state;
	
	@Column(name="createTime")
	private Long createTime;

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
