package com.cement.server.handler;

import java.io.IOException;
import java.util.ArrayList;

import com.cement.server.HttpSession;

public class SessionManager{
	
	protected static DefaultSessionHander defaltHandler = new DefaultSessionHander();
	protected static ArrayList<ISessionHandler> handlers = new ArrayList<ISessionHandler>();
	
	public static void dispatchHandler(HttpSession session) throws IOException{
		String reqMethod = session.getReqMethod();
		System.out.println("..............disapcthHandler............."+reqMethod);
		for (ISessionHandler handler:handlers) {
			if (reqMethod.equals(handler.getHandlerName())) {
				handler.reply(session);
				return;
			}
		}
		defaltHandler.reply(session);
    }
	public static void rigistSessionHandler(ISessionHandler handler){
		handlers.add(handler);
	}
	public static void unRigistSessionHandler(ISessionHandler handler){
		handlers.remove(handler);
	}
	
}
