package com.cement.utils;

import java.io.File;
import java.util.HashMap;

public class ContentType {

	public static String getType(String tail) {
		return MIME.get(tail);

	}
	public static String getType(File file) {
		String typekey = file.getName().substring(file.getName().lastIndexOf(Constant.DOT));
		return getType(typekey);
	}

	public static HashMap<String, String> MIME = new HashMap<String, String>() {
		private static final long serialVersionUID = 1L;

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
