/**
 * 
 */
package com.hyj.demo.util;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import com.hyj.util.param.CheckParamsUtil;
import org.apache.commons.codec.binary.Base64;
import org.springframework.stereotype.Component;

import com.hyj.demo.dao.mapper.mapper1.IUserMapper;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * @author huyuanjia
 *
 */
@Component
public class CommonUtil
{
    @Resource
    IUserMapper userMapper;
    
    public void test()
    {
        System.out.println(userMapper.getUserList());
    }

    /**
     * 处理中文乱码
     * @param request
     * @param name
     * @return
     */
    public static String getName(HttpServletRequest request, String name){
        String agent = (String) request.getHeader("USER-AGENT");
        if (CheckParamsUtil.check(name)) {
            try {

                if (agent != null && agent.indexOf("Firefox") > -1) {// 处理火狐乱码
                    name = "=?UTF-8?B?" + (new String(Base64
                            .encodeBase64(name.getBytes("UTF-8")))) + "?=";
                } else {
                    //其他浏览器
                    name = URLEncoder.encode(name, "UTF-8");
                }
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        return name;
    }
}
