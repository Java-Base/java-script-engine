package com.ibm;

import java.io.FileNotFoundException;
import java.io.FileReader;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 * 
 * 
 * @author 	Lian
 * @date	2016年4月14日
 * @since	1.0	
 */
public class RunScript {

	public static void main(String[] args) throws FileNotFoundException, ScriptException {
		FileReader scriptReader = new FileReader(System.getProperty("user.dir") + "/src/main/resources/run.js");
		ScriptEngine engine = new ScriptEngineManager().getEngineByName("javascript");
		engine.eval(scriptReader);	
	}
}
