package com.iteye.uuhorse;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 * Java语言的动态性支持（一）
 * @url		http://uuhorse.iteye.com/blog/1705684
 * 
 * @author 	Lian
 * @date	2016年4月18日
 * @since	1.0	
 */
public class BasicScripting {

	public static void main(String[] args) {
		try {
			new BasicScripting().greet();
		} catch (ScriptException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void greet() throws ScriptException {
		ScriptEngineManager manager = new ScriptEngineManager();
		// 通过脚本名称
		ScriptEngine engine = manager.getEngineByName("JavaScript");
		// 通过文件扩展名
//		ScriptEngine engine = manager.getEngineByExtension("js");
		// 通过MIME类型
//		ScriptEngine engine = manager.getEngineByMimeType("text/javascript");

		if(engine == null) {
			throw new RuntimeException("找不到JavaScript语言执行引擎");
		}

		// JavaScript脚本中的println是Rhino引擎额外提供的方法。 
		engine.eval("println('Hello!');");
	}
}
