package com.cement.server;

import java.io.OutputStream;


public class HttpRespons {

	private  OutputStream outStream;
	private  HttpHeader header;
	
	private  ResponsStatus status;

	public HttpRespons(OutputStream outStream) {
		this.outStream = outStream;
		header = new HttpHeader();
		status = new ResponsStatus();
	}
	public void addHeader(String key,String value){
		header.put(key, value);
	}
	public HttpHeader getHeader() {
		return header;
	}
	public OutputStream getOutStream() {
		return outStream;
	}
	public ResponsStatus getStatus() {
		return status;
	}
//	public void setResponesStatus(int code){
//		String key = String.valueOf(code);
//		String statu = Constant.PROCTROL11+Constant.SPACE+key+Constant.SPACE+Constant.RESPONES_STATUS.get(key)+Constant.CRLF;
//		status.setStatus(statu);
//	}
}
