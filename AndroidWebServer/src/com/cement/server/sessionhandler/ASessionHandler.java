package com.cement.server.sessionhandler;

public abstract class ASessionHandler implements ISessionHandler{

	protected String methodName;
	
	protected ASessionHandler(String methodName) {
		this.methodName = methodName;
//		HandlerManager.rigistSessionHandler(this);
	}

	@Override
	public String getHandleMethodName() {
		// TODO Auto-generated method stub
		return methodName;
	}
   
}
