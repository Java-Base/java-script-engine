package com.ibm;

import java.io.FileNotFoundException;
import java.io.FileReader;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import com.alibaba.fastjson.JSONObject;

/**
 * 
 * 
 * @author 	Lian
 * @date	2016年4月14日
 * @since	1.0	
 */
public class ScriptTest {
	public static void main(String[] args) throws FileNotFoundException, ScriptException, NoSuchMethodException {
		FileReader scriptReader = new FileReader(System.getProperty("user.dir") + "/src/main/resources/script.js");
		ScriptEngine engine = new ScriptEngineManager().getEngineByName("javascript");
		engine.eval(scriptReader);
		engine.eval("importPackage(com.ibm.jsr.util);");

		if (engine instanceof Invocable) {
			Invocable in = (Invocable) engine;
			// String url = "http://wall.jpmob.com/wall/adjustidfa.do?source=xxx&appid=xxx&idfa=xxx";
			String url = "http://lianxinzhong.site/test/state/return";
			JSONObject json = new JSONObject();
			json.put("user", "lian");
			json.put("age", 20);

			double result = (double) in.invokeFunction("script", url, json);
			int state = (int) result;

			System.out.println(state);
		}
	}
}
