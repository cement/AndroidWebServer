package com.cement.server.sessionhandler;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;

import com.cement.app.App;
import com.cement.server.HttpRequest;
import com.cement.server.HttpRespons;

import android.net.Uri;
import android.util.Log;

public class SessionHandler extends AbsSessionHandler{


	@Override
	public void doGetMethod(HttpRequest request, HttpRespons respons) {
		Uri  uri = Uri.parse(request.statu.getStrurl());
		File outFile = new File(App.WEBROOT+uri.getEncodedPath());
		Log.e(getClass().getSimpleName(), outFile.getAbsolutePath());
		
		if(outFile.isDirectory()){
			outFile = new File(outFile,"index.html");
		}
		OutputStream outStream = respons.outStream;
		if(!outFile.exists()){
			outFile = new File("/W404.html");
			writeHeader(respons,outFile);
			writeEmptyLine(outStream);
			writeFile(outStream, outFile);
		}else{
			writeHeader(respons,outFile);
			  
			writeEmptyLine(outStream);
			
			writeFile(outStream, outFile);
		}	
	}

	private void writeEmptyLine(OutputStream outStream) {
		try {
			outStream.write("\r\n".getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private boolean writeHeader(HttpRespons respons,File outFile){
		respons.statu.putStatu("HTTP/1.1 200 OK");
		respons.header.put("Date",new Date().toString());
		String contentType = outFile.getName().substring(outFile.getName().lastIndexOf("."));
		respons.header.put("Content-Type",ContentType.getType(contentType));
		respons.header.put("Content-Length",outFile.length());
		try {
			respons.outStream.write(respons.statu.toString().getBytes());
			respons.outStream.write(respons.header.toString().getBytes());
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	private boolean writeFile(OutputStream outStream, File outFile){
	   FileInputStream fileInStream = null;
		try{
			fileInStream = new FileInputStream(outFile);
			byte[] buffer = new byte[1024];
			int readed = 0;
			while((readed = fileInStream.read(buffer))!=-1){
				outStream.write(buffer,0,readed);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return false;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}


	@Override
	public void doPostMethod(HttpRequest request, HttpRespons respons) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doPutMethod(HttpRequest request, HttpRespons respons) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doHeadMethod(HttpRequest request, HttpRespons respons) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doDeleteMethod(HttpRequest request, HttpRespons respons) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doTrackMethod(HttpRequest request, HttpRespons respons) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doOptionsMethod(HttpRequest request, HttpRespons respons) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doConnectMethod(HttpRequest request, HttpRespons respons) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doCopyMethod(HttpRequest request, HttpRespons respons) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doPatchMethod(HttpRequest request, HttpRespons respons) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doLinkMethod(HttpRequest request, HttpRespons respons) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doUnlinkMethod(HttpRequest request, HttpRespons respons) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doPurgeMethod(HttpRequest request, HttpRespons respons) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doLockMethod(HttpRequest request, HttpRespons respons) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doUnlockMethod(HttpRequest request, HttpRespons respons) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doPropfindMethod(HttpRequest request, HttpRespons respons) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doViewMethod(HttpRequest request, HttpRespons respons) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doUnknownMethod(HttpRequest request, HttpRespons respons) {
		// TODO Auto-generated method stub
		
	}

}
