package com.ibm;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 * 展示如何通过 Java 语言来运行脚本程序
 * 
 * @author 	Lian
 * @date	2016年4月14日
 * @since	1.0	
 */
public class HelloWorld {

	public static void main(String[] args) throws ScriptException {
		ScriptEngineManager manager = new ScriptEngineManager();
		ScriptEngine engine = manager.getEngineByName("javascript");

		// 解析JS脚本, 输出运行结果
		engine.eval("print('Hello World')");
	}
}
