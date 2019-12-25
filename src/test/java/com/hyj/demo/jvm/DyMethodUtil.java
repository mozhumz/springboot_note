package com.hyj.demo.jvm;

import org.apache.commons.jexl3.JexlContext;
import org.apache.commons.jexl3.JexlEngine;
import org.apache.commons.jexl3.JexlExpression;
import org.apache.commons.jexl3.MapContext;
import org.apache.commons.jexl3.internal.Engine;

import java.util.HashMap;
import java.util.Map;


/**
 * 动态加载方法
 *
 * @author ld
 */
public class DyMethodUtil {
	private static JexlEngine jexlEngine = new Engine();

	public static Object executeExpression(String jexlExpression, Map<String, Object> map) {
		JexlExpression expression = jexlEngine.createExpression(jexlExpression);
		JexlContext context = new MapContext();
		for (Map.Entry<String, Object> entry : map.entrySet()) {
			String key = entry.getKey();
			Object value = entry.getValue();
			context.set(key, value);
		}
		return expression.evaluate(context);
	}

	//	public static Object invokeMethod(String jexlExp,Map<String,Object> map){
//		JexlEngine jexl=new JexlEngine();
//		Expression e = jexl.createExpression(jexlExp);
//		JexlContext jc = new MapContext();
//		for(String key:map.keySet()){
//			jc.set(key, map.get(key));
//		}
//		if(null==e.evaluate(jc)){
//			return "";
//		}
//		return e.evaluate(jc);
//	}
	public static void main(String[] args) {
		Map<String, Object> map = new HashMap<>();
		map.put("alive", "coding every day");
		map.put("out1", System.out);
		String expression = "(alive == null)";
//		executeExpression(expression, map);
		System.out.println(executeExpression(expression, map));
	}
}
