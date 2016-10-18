package com.cement.server.handler;

import java.io.IOException;

import com.cement.server.HttpRequest;
import com.cement.server.HttpRespons;

public abstract class BaseSessionHandler implements ISessionHandler{
	
	protected String methodName;
	
//	static{
//		//HandlerManager.rigistSessionHandler(this);
//		System.out.println(">>>>>>>>>>>>>>>BaseSessionHandler static:  ");
//	}

	protected BaseSessionHandler(String methodName) {
		this.methodName = methodName;
		HandlerManager.rigistSessionHandler(this);
	}

	@Override
	public String getHandleMethodName() {
		// TODO Auto-generated method stub
		return methodName;
	}

	@Override
	public abstract  boolean reply(HttpRequest request, HttpRespons respons) throws IOException;
	
}
