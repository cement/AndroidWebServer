package com.cement.server;

import java.io.OutputStream;


public class HttpRespons {

	public  OutputStream outStream;
	public  HttpHeader header;
	public  ResponsStatu statu;

	public HttpRespons(OutputStream outStream) {
		this.outStream = outStream;
		header = new HttpHeader();
		statu = new ResponsStatu();
	}
	public void setHeader(String key,String value){
		header.put(key, value);
	}
	public void setstatus(String status){
		statu.setStatus(status);
	}
	
}
