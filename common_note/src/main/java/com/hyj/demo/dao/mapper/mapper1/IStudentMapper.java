package com.hyj.demo.dao.mapper.mapper1;

import com.hyj.demo.model.po.StudentPO;
import com.hyj.demo.model.qo.BaseQo;

import java.util.List;

/**
 * @author huyuanjia
 * @date 2018/12/13 15:07
 */
public interface IStudentMapper {
    List<StudentPO> findStudentPOList(BaseQo qo);
    int findStudentPOListTotal();
}
