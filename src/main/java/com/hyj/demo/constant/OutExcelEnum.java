package com.hyj.demo.constant;


import java.util.Objects;

/**
 * 导出Excel列表
 * @author huyuanjia
 * @date 2018/9/19 16:16
 */
public enum OutExcelEnum {

    DORM_INFO_LIST(1,"报表管理-导出公寓信息列表"),
    DORM_INFO_LIST2(2,"报表管理-导出公寓信息列表");;

    private int outType;
    private String typeDesc;

    OutExcelEnum(int outType,String typeDesc) {
        this.outType = outType;
        this.typeDesc=typeDesc;
    }

    public int getOutType() {
        return outType;
    }

    public void setOutType(int outType) {
        this.outType = outType;
    }

    public String getTypeDesc() {
        return typeDesc;
    }

    public void setTypeDesc(String typeDesc) {
        this.typeDesc = typeDesc;
    }

    public static String getTypeDescByOutType(int outType) {
        for (OutExcelEnum e : OutExcelEnum.values()) {
            if (Objects.equals(e.getOutType(),outType)) {
                return e.typeDesc;
            }
        }
        return null;
    }
}
