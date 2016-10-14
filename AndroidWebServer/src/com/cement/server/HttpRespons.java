package com.cement.server;

import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;

import android.content.Intent;

public class HttpRespons {

	public  OutputStream outStream;
	public  HttpHeader header;
	public  ResponsStatu statu;

	public HttpRespons(OutputStream outStream) {
		this.outStream = outStream;
		header = new HttpHeader();
		statu = new ResponsStatu();
	}
	public boolean writeHeader(){
		try {
			outStream.write(statu.toString().getBytes());
			outStream.write(header.toString().getBytes());
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
}
