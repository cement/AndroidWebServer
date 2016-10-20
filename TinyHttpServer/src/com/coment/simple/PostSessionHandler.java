package com.coment.simple;

import java.io.IOException;

import com.cement.server.HttpRequest;
import com.cement.server.HttpRespons;
import com.cement.server.HttpSession;
import com.cement.server.handler.BaseSessionHandler;

public class PostSessionHandler extends BaseSessionHandler{

	public PostSessionHandler(String methodName) {
		super(methodName);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean reply(HttpSession session) throws IOException {
		// TODO Auto-generated method stub
		return false;
	}

}
