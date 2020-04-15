package com.hyj.demo.model.qo;

import lombok.Data;

/**
 * @author huyuanjia
 * @date 2018/12/13 15:13
 */
@Data
public class BaseQo {
    private Integer size=1000;

    private Integer page;

    private Integer start;
}
