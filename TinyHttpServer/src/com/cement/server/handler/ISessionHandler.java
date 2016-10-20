package com.cement.server.handler;

import java.io.IOException;

import com.cement.server.HttpRequest;
import com.cement.server.HttpRespons;
import com.cement.server.HttpSession;

public interface ISessionHandler {
	
	
	//public boolean reply(HttpRequest request,HttpRespons respons) throws IOException;
	public boolean reply(HttpSession session) throws IOException;
	
	default void Log(String str){
		System.out.println(Thread.currentThread().getStackTrace()[1].getClassName());
	}
	public String getHandlerName();
}
