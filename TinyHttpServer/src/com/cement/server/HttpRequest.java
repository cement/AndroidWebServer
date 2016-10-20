package com.cement.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import com.cement.constants.Constant;

public class HttpRequest {

	private  RequestStatus status;
	
	private  HttpHeader header ;

	private InputStream inStream;
	
	public HttpRequest(InputStream inStream) throws IOException {
		this.inStream = inStream;
		BufferedReader reader = new BufferedReader(new InputStreamReader(inStream));
    	this.status = readStatus(reader);
    	this.header = readHeader(reader);
	}
	private RequestStatus readStatus(BufferedReader reader) throws IOException{
		String strStatu = reader.readLine();
		RequestStatus status  = new RequestStatus(strStatu);
		return status;
		
	}
	private HttpHeader readHeader(BufferedReader reader) throws IOException{
		HttpHeader header = new HttpHeader();
		this.header = new HttpHeader();
    	String line = null;
    	while(!(line = reader.readLine()).equals(Constant.EMPTY)){
    		String[] arr = line.split(Constant.COLON);
    		if(arr.length == 2){
    			header.put(arr[0], arr[1]);
    		}
    	}
		return header;
		
	}
	public RequestStatus getStatus() {
		return status;
	}
	public HttpHeader getHeader() {
		return header;
	}
	public InputStream getInStream() {
		return inStream;
	}
	@Override
	public String toString() {
		return "HttpRequest [statu=" + status + ", header=" + header + "]";
	}
}
