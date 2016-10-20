package com.cement.server;

import com.cement.constants.Constant;

public class RequestStatus {
	
	private String method;
	private String strurl;
//	private String search;
//	private String fragment;
//	private String baseurl;
	private String proctrol;
	
	public RequestStatus(String method, String strurl, String proctrol) {
		this.method = method;
		this.strurl = strurl;
		this.proctrol = proctrol;
	}
	public RequestStatus(String strStatu) {
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
