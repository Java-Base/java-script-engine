package com.cloud;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 * 在Java中直接调用JS代码
 * 
 * @author 	Lian
 * @date	2016年4月14日
 * @since	1.0	
 */
public class ScriptEngineTest {

	public static void main(String[] args) {
		ScriptEngineManager manager = new ScriptEngineManager();
		ScriptEngine engine = manager.getEngineByName("javascript");

		try {
			engine.eval("var a=3; var b=4; print(a+b)");

//			engine.eval("alert(\"js alert\");"); // 不能调用浏览器中定义的js函数 , 错误，会抛出"alert" is not defined
		} catch (ScriptException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
