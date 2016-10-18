package com.cement.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import com.cement.utils.Constant;

public class HttpRequest {

	public  RequestStatu statu;
	public  HttpHeader header ;
	

	public BufferedReader reader;
	public HttpRequest(InputStream inStream) throws IOException {
		this.reader = new BufferedReader(new InputStreamReader(inStream));
		
		String strStatu = reader.readLine();
		this.statu  = new RequestStatu(strStatu);
    	
    	this.header = new HttpHeader();
    	String line = null;
    	while(!(line = reader.readLine()).equals(Constant.EMPTY)){
    		String[] arr = line.split(Constant.COLON);
    		if(arr.length == 2){
    			header.put(arr[0], arr[1]);
    		}
    	}
	}
	@Override
	public String toString() {
		return "HttpRequest [statu=" + statu + ", header=" + header + "]";
	}

	
	
	
}
