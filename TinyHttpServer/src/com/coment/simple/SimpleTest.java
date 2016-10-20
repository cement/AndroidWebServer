package com.coment.simple;

import java.io.IOException;

import com.cement.constants.Settings.MODE;
import com.cement.server.EmbedHttpServer;

public class SimpleTest {

	public static void main(String[] args) throws IOException {
		
		EmbedHttpServer server = new EmbedHttpServer(9999);
//		server.addHandler(new PostSessionHandler("POST"));
//		server.addHandler(new GetSessionHandler2("GET"));
		server.setWebRoot("W:\\WebRoot\\static");
		server.setNotFindPage("W:\\WebRoot\\static\\page404.html");
		server.setVisitMode(MODE.FILE);
		server.start();
	}
}
