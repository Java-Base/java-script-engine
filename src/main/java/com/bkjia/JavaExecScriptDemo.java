package com.bkjia;

import java.io.File;
import java.lang.reflect.Field;
import java.util.Arrays;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 * JAVA使用脚本引擎执行JS，java脚本引擎js
 * @url		http://www.bkjia.com/webzh/1005131.html
 * 
 * @author 	Lian
 * @date	2016年4月18日
 * @since	1.0	
 */
public class JavaExecScriptDemo {

	public static void main(String[] args) {
		System.out.println(jsObjFunc());
		System.out.println(Arrays.toString(getArray()));
		System.out.println(jsCalculate("a=1+2+3+(2*2)"));
	}

	/**
	 * 运行JS对象中的函数
	 *
	 * @return
	 */
	public static Object jsObjFunc() {
		String script = "var obj={run:function(){return 'run method : return:\"abc'+this.next('test')+'\"';},next:function(str){return ' 我来自next function('+str+')'}}";
		ScriptEngineManager sem = new ScriptEngineManager();
		ScriptEngine scriptEngine = sem.getEngineByName("js");
		try {
			scriptEngine.eval(script);
			Object object = scriptEngine.get("obj");
			Invocable inv2 = (Invocable) scriptEngine;
			return inv2.invokeMethod(object, "run");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 获取JS对象数组类型属性
	 *
	 * @return
	 */
	public static Object[] getArray() {
		ScriptEngineManager sem = new ScriptEngineManager();
		String script = "var obj={array:['test',true,1,1.0,2.111]}";
		ScriptEngine scriptEngine = sem.getEngineByName("js");
		try {
			scriptEngine.eval(script);
			Object object = scriptEngine.eval("obj.array");
			Class<?> clazz = object.getClass();
			Field denseField = clazz.getDeclaredField("dense");
			denseField.setAccessible(true);
			return (Object[]) denseField.get(object);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * JS计算
	 *
	 * @param script
	 * @return
	 */
	public static Object jsCalculate(String script) {
		ScriptEngineManager sem = new ScriptEngineManager();
		ScriptEngine scriptEngine = sem.getEngineByName("js");
		try {
			return scriptEngine.eval(script);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 运行JS基本函数
	 */
	public static void jsFunction() {
		ScriptEngineManager sem = new ScriptEngineManager();
		ScriptEngine scriptEngine = sem.getEngineByName("js");
		try {
			String script = "function say(name) {return 'hello, ' + name; }";
			scriptEngine.eval(script);

			Invocable inv = (Invocable) scriptEngine;
			String res = (String) inv.invokeFunction("say", "lian");
			System.out.println(res);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * JS中变量使用
	 */
	public static void jsVariables() {
		ScriptEngineManager sem = new ScriptEngineManager();
		ScriptEngine engine = sem.getEngineByName("javascript");
		File file = new File("/data/js.txt");
		engine.put("file", file);
		try {
			engine.eval("println('path:'+file.getAbsoluteFile())");
		} catch (ScriptException e) {
			e.printStackTrace();
		}

	}
}
