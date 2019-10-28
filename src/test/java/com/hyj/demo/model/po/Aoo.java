package com.hyj.demo.model.po;

import com.hyj.demo.util.CommonUtil;
import lombok.Data;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

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
        return Objects.equals(name, aoo.name) &&
                Objects.equals(pub, aoo.pub);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, pub);
    }

    public static void main(String[] args) {
        Aoo aoo1=new Aoo();
        aoo1.setName("1");
        aoo1.setId(1L);
        Aoo aoo2=new Aoo();
        aoo2.setName("1");
        aoo2.setId(12L);
        Set set=new HashSet();
        set.add(aoo1);
        set.add(aoo2);
//        set.forEach(i-> System.out.println(i));
        HashMap hashMap=new HashMap();
        hashMap.put(aoo1,aoo1);
        hashMap.put(aoo2,aoo2);
        hashMap.forEach((k,v)-> System.out.println("k:"+k+",v:"+v));

    }
    static {

        CommonUtil.initLog("static block");
    }
}
