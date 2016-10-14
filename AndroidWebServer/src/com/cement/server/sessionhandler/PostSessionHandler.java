package com.cement.server.sessionhandler;

import java.io.File;

import com.cement.server.HttpRequest;
import com.cement.server.HttpRespons;

public class PostSessionHandler extends ASessionHandler{

	protected PostSessionHandler(String methodName) {
		super(methodName);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void handle(HttpRequest request, HttpRespons respons) {
		// TODO Auto-generated method stub
	}

	@Override
	public boolean writeHeader(HttpRequest request, HttpRespons respons, File outFile) {
		// TODO Auto-generated method stub
		return false;
	}

}
