package com.cloud;

import java.io.File;

/**
 * 
 * 
 * @author 	Lian
 * @date	2016年4月18日
 * @since	1.0	
 */
public class PathTest {

	public static void main(String[] args) {

		File file = new File(".");
		System.out.println(file.getAbsolutePath());
		System.out.println(file.getPath());
		System.out.println(PathTest.class.getResource("").getPath()  );
	}
}
