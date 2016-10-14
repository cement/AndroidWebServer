package com.cement.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

import android.content.ContentValues;
import android.util.Log;

public class HttpRequest {

	public static final String CRLF = "\r\n";
	public static final String EMPTY_LINE = "";
	public  RequestStatu statu;
	public  HttpHeader header ;
	

	private BufferedReader reader;
	public HttpRequest(InputStream inStream) throws IOException {
		this.reader = new BufferedReader(new InputStreamReader(inStream));
		
		String strStatu = reader.readLine();
    	this.statu  = new RequestStatu(strStatu);
    	Log.v(getClass().getSimpleName(), strStatu);
    	
    	this.header = new HttpHeader();
    	String line = null;
    	while(!(line = reader.readLine()).equals(EMPTY_LINE)){
    		Log.v(getClass().getSimpleName(), line);
    		String[] arr = line.split(": ");
    		if(arr.length == 2){
    			header.put(arr[0], arr[1]);
    		}
    	}
	}
//	
//    public HttpRequest resolve() throws IOException{
//    	
//		return this;
//    }

	public HttpHeader getRequestInHeader() {
		return header;
	}
	
	
	
}
