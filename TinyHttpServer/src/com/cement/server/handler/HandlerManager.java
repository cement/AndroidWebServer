package com.cement.server.handler;

import java.io.IOException;
import java.util.ArrayList;

import com.cement.server.HttpRequest;
import com.cement.server.HttpRespons;

public class HandlerManager{
	
	
	protected static ArrayList<ISessionHandler> handlers = new ArrayList<ISessionHandler>();
	
	public static void disapcthHandler(HttpRequest request,HttpRespons respons) throws IOException{
		String method = request.statu.getMethod();
		for (ISessionHandler handler:handlers) {
			System.out.println("..............disapcthHandler............."+handler.getHandleMethodName());
			if (method.equals(handler.getHandleMethodName())) {
				handler.reply(request, respons);
				return;
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
