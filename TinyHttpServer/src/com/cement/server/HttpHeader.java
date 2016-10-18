package com.cement.server;

import java.util.HashMap;

import com.cement.constants.Constant;


public class HttpHeader extends HashMap<String,String> {
	
	private static final long serialVersionUID = 1L;
	
	public static final String TAG = "HttpHeader";

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (String name : keySet()) {
            String value = get(name);
           // if (sb.length() > 0) sb.append(" ");
            sb.append(name + Constant.COLON + value +Constant.CRLF);
        }
        return sb.toString();
    }
}
