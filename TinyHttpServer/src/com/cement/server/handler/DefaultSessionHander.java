package com.cement.server.handler;

import java.io.File;
import java.io.IOException;

import com.cement.constants.Settings;
import com.cement.server.HttpSession;

public class DefaultSessionHander implements ISessionHandler {
	
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
			session.writeGeneralHeader();
			session.writeEmptyLine();
			session.writeOutFile(Settings.NOTFIND_PAGE_FILE);
		}else{
			if(outFile.isFile()){
				session.writeStatus(200);
				session.writeBaseHeader(outFile);
				session.writeEmptyLine();
				session.writeOutFile(outFile);
			}else if(outFile.isDirectory()){
				if(Settings.VISITMODE == Settings.MODE.WEB){
					File file = new File(outFile,"index.html");
					send(session,file);
				}else if(Settings.VISITMODE == Settings.MODE.FILE){
					session.writeStatus(200);
					session.writeGeneralHeader();
					session.writeHeader("Content-Type", "text/html");
					session.writeEmptyLine();
					session.write("<html><body><ul><h2>");
					for (String filePath: outFile.list()) {
						filePath = (session.getReqUrl()+"/"+filePath).replaceAll("//", "/");
						session.write("<a href = "+filePath+"><li>"+filePath+"</li></a>");
					}
					session.write("</h2></ul></body></html>");
				}
			}
		}
	}

	@Override
	public String getHandlerName() {
		// TODO Auto-generated method stub
		return "DEFAULT";
	}
}
