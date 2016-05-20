package com.util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * 
 * 
 * @author 	Lian
 * @date	2016年4月14日
 * @since	1.0	
 */
public class HttpUtil {

	public static String httpGet(String strurl) {
		String encoding = "UTF-8";
		HttpURLConnection http = null;
		String responseContent = "";
		try {
			URL url = new URL(strurl);
			http = (HttpURLConnection) url.openConnection();
			http.setRequestMethod("GET");
			http.setConnectTimeout(1000 * 3);
			http.setRequestProperty("Charset", encoding);

			http.setDefaultUseCaches(false);
			http.setDoOutput(true);
			http.connect();
			InputStream in = http.getInputStream();

			BufferedReader rd = new BufferedReader(new InputStreamReader(in, encoding));
			String tempLine = rd.readLine();
			StringBuffer tempStr = new StringBuffer();
			String crlf = "";
			while (tempLine != null) {
				tempStr.append(tempLine);
				tempStr.append(crlf);
				tempLine = rd.readLine();
			}

			responseContent = tempStr.toString().trim();
			rd.close();
			in.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (http != null) {
				http.disconnect();
			}
		}
		return responseContent;
	}
}
