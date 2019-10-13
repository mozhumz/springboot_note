package com.hyj.demo.model.po;

import com.hyj.demo.util.CommonUtil;
import lombok.Data;

import java.util.Objects;

@Data
public class Aoo {


    {
        CommonUtil.initLog("common block");
    }

    private Long id;

    private String name = CommonUtil.initLog("private field name");
    public String pub = CommonUtil.initLog("public field pub");
    protected String pro = CommonUtil.initLog("protected field pro");
    String def = CommonUtil.initLog("default field def");

    protected static String pro_s = CommonUtil.initLog("protected static pro_s");
    public static String s = CommonUtil.initLog("public static s");

    public Aoo() {
        CommonUtil.initLog("Aoo()");

    }

    public void test() {
        CommonUtil.initLog("common test method");
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Aoo aoo = (Aoo) o;
        return name.equals(aoo.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public static void main(String[] args) {
        new Aoo();
    }
    static {

        CommonUtil.initLog("static block");
    }
}
