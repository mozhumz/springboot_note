package com.hyj.demo.model.po;


import lombok.Data;

import java.io.Serializable;

@Data
public class StudentPO implements Serializable {

    private Long id;

    private String sn;

    private String studentName;

    private Integer sex;

    private String schoolAddress;

    private Long collegeId;

    private String collegeName;

    private String gradeName;

    private Long majorId;

    private String majorName;

    private Long classId;

    private String className;

    private Long dormId;
    private String dormName;

    private Long roomId;

    private String roomName;

    private String bedNumber;

    private Integer stdType;

    private String remark;

    private Long createTime;

    private Long updateTime;

    private Integer state;



}