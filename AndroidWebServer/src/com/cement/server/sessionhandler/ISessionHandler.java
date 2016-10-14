package com.cement.server.sessionhandler;

import java.io.File;

import com.cement.server.HttpRequest;
import com.cement.server.HttpRespons;

public interface ISessionHandler {
	public  void handle(HttpRequest request, HttpRespons respons);
	public  String getHandleMethodName();
	public boolean writeHeader(HttpRequest request, HttpRespons respons,File outFile);
}
