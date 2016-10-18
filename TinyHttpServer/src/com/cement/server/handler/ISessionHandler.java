package com.cement.server.handler;

import java.io.IOException;

import com.cement.server.HttpRequest;
import com.cement.server.HttpRespons;

public interface ISessionHandler {
	
	public String getHandleMethodName();
	public boolean reply(HttpRequest request,HttpRespons respons) throws IOException;
}
