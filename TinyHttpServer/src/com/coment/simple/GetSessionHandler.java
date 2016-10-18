package com.coment.simple;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;

import com.cement.constants.Constant;
import com.cement.constants.ContentType;
import com.cement.server.HttpRequest;
import com.cement.server.HttpRespons;
import com.cement.server.handler.BaseSessionHandler;
import com.coment.simple.FileOperater;


public class GetSessionHandler extends BaseSessionHandler{

	public GetSessionHandler(String methodName) {
		super(methodName);
	}
	private void writeEmptyLine(OutputStream outStream) {
		try {
			outStream.write(Constant.CRLF.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
   public void writeHeader(HttpRequest request, HttpRespons respons,File outFile) throws IOException{
		respons.statu.setStatus("HTTP/1.1 200 OK");
		respons.header.put("Date",new Date().toString());
		respons.header.put("Content-Type",ContentType.getType(outFile));
		respons.header.put("Content-Length",String.valueOf(outFile.length()));
		
		respons.outStream.write(respons.statu.toString().getBytes());
		respons.outStream.write(respons.header.toString().getBytes());
	}
   public void write404Header(HttpRequest request, HttpRespons respons,File outFile) throws IOException{
	   respons.statu.setStatus("HTTP/1.1 404 file not find!");
	   respons.header.put("Date",new Date().toString());
	   respons.header.put("Content-Type",ContentType.getType(outFile));
	   respons.header.put("Content-Length",String.valueOf(outFile.length()));
	   
	   respons.outStream.write(respons.statu.toString().getBytes());
	   respons.outStream.write(respons.header.toString().getBytes());
   }
	@Override
	public boolean reply(HttpRequest request, HttpRespons respons) throws IOException {
		
		String strurl = request.statu.getStrurl();
		File outFile = new File(Constant.WEBROOT,strurl);
		if(!outFile.exists()){
			outFile = new File(Constant.WEBROOT,"wrong_page.html");
			respons.statu.setStatus("HTTP/1.1 404 file not find!");
			FileOperater.writeOutFile(respons.outStream, outFile);
		}else{
			if(outFile.isDirectory()){
				respons.statu.setStatus("HTTP/1.1 200 OK");
				writeEmptyLine(respons.outStream);
				respons.outStream.write("<html><body><ul><h2>".getBytes());
				for (String filePath: outFile.list()) {
					filePath = (strurl+"/"+filePath).replaceAll("//", "/");
					respons.outStream.write(("<a href = "+filePath+"><li>"+filePath+"</li></a>").getBytes());
				}
				respons.outStream.write(("</h2></ul></body></html>").getBytes());
			}else if(outFile.isFile()){
				writeHeader(request,respons,outFile);
				writeEmptyLine(respons.outStream);
//				RandomAccessFile randomFile = new RandomAccessFile(outFile, "r");
				FileOperater.writeOutFile(respons.outStream, outFile);
			}
		}
		return false;	
	}
}
