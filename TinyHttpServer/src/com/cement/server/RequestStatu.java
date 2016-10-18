package com.cement.server;

import com.cement.utils.Constant;

public class RequestStatu {
	
	private String method;
	private String strurl;
//	private String search;
//	private String fragment;
//	private String baseurl;
	private String proctrol;
	
	public RequestStatu() {
		super();
	}
	public RequestStatu(String method, String strurl, String proctrol) {
		this.method = method;
		this.strurl = strurl;
		this.proctrol = proctrol;
	}
	public RequestStatu(String strStatu) {
		String[] arry = strStatu.split(Constant.SPACE);
		if(arry.length == 3){
			this.method = arry[0];
			this.strurl = arry[1];
			this.proctrol = arry[2];	
		}
	}
	
	public String getMethod() {
		return method;
	}
	public String getProctrol() {
		return proctrol;
	}
	public String getStrurl() {
		return strurl;
	}
	@Override
	public String toString() {
		return method + " " + strurl + " " + proctrol + Constant.CRLF;
	}
	
}
