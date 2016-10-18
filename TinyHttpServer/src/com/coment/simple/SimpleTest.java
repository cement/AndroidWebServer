package com.coment.simple;

import com.cement.constants.Constant;
import com.cement.server.EmbedHttpServer;

public class SimpleTest {

	public static void main(String[] args) {
		Constant.WEBROOT = "W:\\WebRoot\\static";
		EmbedHttpServer server = new EmbedHttpServer(9999);
		server.addHandler(new GetSessionHandler("GET"));
		server.addHandler(new PostSessionHandler("POST"));
		server.start();
	}
}
