package com.cement.server.handler;

public abstract class BaseSessionHandler implements ISessionHandler{
	
	protected String methodName ;
	
	protected BaseSessionHandler(String methodName) {
		this.methodName = methodName;
		SessionManager.rigistSessionHandler(this);
	}

	public String getHandlerName() {
		return methodName;
	}
	
}
