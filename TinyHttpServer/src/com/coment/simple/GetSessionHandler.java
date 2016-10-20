package com.coment.simple;

import java.io.File;
import java.io.IOException;

import com.cement.constants.Settings;
import com.cement.server.HttpSession;
import com.cement.server.handler.BaseSessionHandler;


public class GetSessionHandler extends BaseSessionHandler{

	public GetSessionHandler(String methodName) {
		super(methodName);
	}
	
	@Override
	public boolean reply(HttpSession session) throws IOException {
		String requrl = session.getReqUrl();
		File outFile = new File(Settings.WEBROOT,requrl);
	    this.send(session, outFile);
		return false;	
	}

	private void send(HttpSession session, File outFile) throws IOException {
		if(!outFile.exists()){
			session.writeStatus(404);
//			session.writeBaseHeader(outFile);
			session.writeEmptyLine();
			session.writeOutFile(Settings.NOTFIND_PAGE_FILE);
		}else{
			if(outFile.isFile()){
				session.writeStatus(200);
				session.writeBaseHeader(outFile);
				session.writeEmptyLine();
				session.writeOutFile(outFile);
			}else if(outFile.isDirectory()){
				File file = new File(outFile,"index.html");
				send(session,file);
			}
		}
	}

}
