package com.hyj.demo.entity.po.po1;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

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
