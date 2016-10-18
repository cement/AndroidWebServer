package com.cement.server.sessionhandler;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;

import com.cement.app.App;
import com.cement.server.HttpRequest;
import com.cement.server.HttpRespons;
import com.cement.server.fileoperate.FileOperater;
import com.cement.utils.Constant;

import android.app.admin.SystemUpdatePolicy;
import android.net.Uri;
import android.util.Log;

public class GetSessionHandler extends ASessionHandler{

	public GetSessionHandler(String methodName) {
		super(methodName);
	}
	@Override
	public void handle(HttpRequest request, HttpRespons respons) {
		System.out.println(">>>>>>>>>>>>>get>>>>>>>>>>>>>>>");
		Uri  uri = Uri.parse(request.statu.getStrurl());
		File outFile = new File(App.WEBROOT+uri.getEncodedPath());
		
		Log.e(getClass().getSimpleName(), outFile.getAbsolutePath());
		
		if(outFile.isDirectory()){
			outFile = new File(outFile,"index.html");
		}
		OutputStream outStream = respons.outStream;
		if(!outFile.exists()){
			outFile = new File(App.WEBROOT+File.separator+"wrong_page.html");
			writeHeader(request,respons,outFile);
			writeEmptyLine(outStream);
			FileOperater.writeOut(outStream, outFile);
		}else{
			writeHeader(request,respons,outFile);
			writeEmptyLine(outStream);
			FileOperater.writeOut(outStream, outFile);
		}	
		
	}
	private void writeEmptyLine(OutputStream outStream) {
		try {
			outStream.write(Constant.CRLF.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
   @Override
   public boolean writeHeader(HttpRequest request, HttpRespons respons,File outFile){
		respons.statu.putStatu("HTTP/1.1 200 OK");
		respons.header.put("Date",new Date().toString());
		String contentType = outFile.getName().substring(outFile.getName().lastIndexOf(Constant.DOT));
		respons.header.put("Content-Type",ContentType.getType(contentType));
		respons.header.put("Content-Length",outFile.length());
		
		return respons.writeHeader();
	}
}
