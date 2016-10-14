package com.cement.server.sessionhandler;

import java.util.ArrayList;

import com.cement.server.HttpRequest;
import com.cement.server.HttpRespons;

public class HandlerManager{
	
	
	protected static ArrayList<ISessionHandler> handlers = new ArrayList<ISessionHandler>();
	
	public static void disapcthHandler(HttpRequest request,HttpRespons respons){
		String method = request.statu.getMethod();
		for (ISessionHandler handler:handlers) {
			if (method.equals(handler.getHandleMethodName())) {
				handler.handle(request,respons);
			}
		}
    }
	public static void rigistSessionHandler(ISessionHandler handler){
		handlers.add(handler);
	}
	public static void unRigistSessionHandler(ISessionHandler handler){
		handlers.remove(handler);
	}
	
}
