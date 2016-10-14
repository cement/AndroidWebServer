package com.cement.server.sessionhandler;

import java.util.HashMap;

import android.content.ContentValues;

public class ContentType {

	public static String getType(String key){
		return MemiType.get(key);
		
	}
	
	
		public static HashMap<String, String> MemiType = new HashMap<String, String>(){
		{
			put(".htm", "text/html;charset=utf-8");
			put(".html", "text/html;charset=utf-8");
			put(".xml", "text/xml;charset=utf-8");
			put(".txt", "text/plain;charset=utf-8");
			put(".json", "text/plain;charset=utf-8");
			put(".css", "text/css;charset=utf-8");
			put(".ico", "image/x-icon;charset=utf-8");
			put(".png", "image/png");
			put(".gif", "image/gif");
			put(".jpg", "image/jpg");
			put(".jpeg", "image/jpeg");
			put(".zip", "application/zip");
			put(".rar", "application/rar");
			put(".js", "text/javascript;charset=utf-8");
		}
	};
}
