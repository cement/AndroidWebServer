package com.cement.server;

import java.io.File;
import java.io.IOException;
import java.net.Socket;
import java.util.Date;

import com.cement.constants.Constant;
import com.cement.constants.ContentType;
import com.coment.simple.FileOperater;

public class HttpSession {

	private HttpRequest request;
	private HttpRespons respons;
   
	public HttpSession(Socket socket) throws IOException {
		request = new HttpRequest(socket.getInputStream());
		respons = new HttpRespons(socket.getOutputStream());
	}
	
	public String getReqUrl(){
		return request.getStatus().getStrurl();
	}
	public String getReqMethod() {
		return request.getStatus().getMethod();
	}
	public String getProctrol() {
		return request.getStatus().getProctrol();
	}
	public HttpHeader getReqHeader(){
		return request.getHeader();
	}
	
	
	public void addHeader(String key,String value) throws IOException{
		respons.addHeader(key, value);
	}
	public void writeHeader(String key,String value) throws IOException{
		respons.getOutStream().write((key+": "+value+Constant.CRLF).getBytes());
	}
	public void writeBaseHeader(File file) throws IOException{
		HttpHeader header = respons.getHeader().getBaseHeader(file);
		System.out.println(header);
		respons.getOutStream().write(header.toString().getBytes());
	}
	public void writeGeneralHeader() throws IOException{
		respons.getOutStream().write(HttpHeader.GeneralHeader.toString().getBytes());
	}
	public void writeHeader() throws IOException{
		respons.getOutStream().write(respons.getHeader().toString().getBytes());
	}
	public void writeStatus(int code) throws IOException{
		String statu = Constant.getResponesStatus(code);
		respons.getOutStream().write(statu.getBytes());
	}
	public void write(String string) throws IOException{
		respons.getOutStream().write(string.getBytes());
	}
	public void writeEmptyLine() throws IOException {
		respons.getOutStream().write(Constant.CRLF.getBytes());
	}
	public void writeOutFile(File outFile) throws IOException {
		FileOperater.writeOutFile(respons.getOutStream(), outFile);
	}
	
	
}
