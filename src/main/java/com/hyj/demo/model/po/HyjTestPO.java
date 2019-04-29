package com.hyj.demo.model.po;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "t_hyj_test")
@Data
public class HyjTestPO {
	@Column(name = "create_date")
    private String createDate;

	@Column(name = "update_date")
	private String updateDate;
	
	@Id
	@Column(name = "id")
    private Long id;


	@Override
	public String toString() {
		return "HyjTestPO{" +
				"createDate='" + createDate + '\'' +
				", id=" + id +
				'}';
	}
}
