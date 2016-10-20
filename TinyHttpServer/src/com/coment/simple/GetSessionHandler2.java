package com.coment.simple;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import com.cement.constants.Constant;
import com.cement.constants.ContentType;
import com.cement.constants.Settings;
import com.cement.server.HttpSession;
import com.cement.server.handler.BaseSessionHandler;


public class GetSessionHandler2 extends BaseSessionHandler{

	public GetSessionHandler2(String methodName) {
		super(methodName);
	}
	
	@Override
	public boolean reply(HttpSession session) throws IOException {
		String strurl = session.getReqUrl();
		File outFile = new File(Settings.WEBROOT,strurl);
		 if(!outFile.exists()){
		    	
				outFile = new File(Settings.WEBROOT,"page404.html");
				session.writeStatus(404);
				session.writeHeader("Content-Type", ContentType.getType(outFile));
				session.writeHeader("Last-Modified", String.valueOf(outFile.lastModified()));
				session.writeHeader("Date", new Date().toString());
//				session.writeHeader("Content-Length", String.valueOf(outFile.length()));
//				session.writeHeader("Connection", "close");
				session.writeEmptyLine();
				session.writeOutFile(outFile);
			}else{
				if(outFile.isDirectory()){
					session.writeStatus(200);
					session.writeHeader("Connection", "close");
					session.writeHeader("Date", new Date().toString());
					session.writeHeader("Content-Type", "text/html");
					session.writeEmptyLine();
					session.write("<html><body><ul><h2>");
					for (String filePath: outFile.list()) {
						filePath = (strurl+"/"+filePath).replaceAll("//", "/");
						session.write("<a href = "+filePath+"><li>"+filePath+"</li></a>");
					}
					session.write("</h2></ul></body></html>");
				}else if(outFile.isFile()){
					session.writeStatus(200);
					session.writeHeader("Date", new Date().toString());
					session.writeHeader("Connection", "close");
					session.writeHeader("Content-Length", String.valueOf(outFile.length()));
					session.writeHeader("Content-Type", ContentType.getType(outFile));
					session.writeEmptyLine();
//					RandomAccessFile randomFile = new RandomAccessFile(outFile, "r");
					session.writeOutFile(outFile);
				}
			}
		return false;	
	}

	private void dcq(HttpSession session, File outFile) throws IOException {
		
	   
	}
}
