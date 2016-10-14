package com.cement.app;

import java.io.File;

import android.app.Application;
import android.content.Context;
import android.os.Environment;

public class App extends Application{
	public static final String CRLF = System.getProperty("line.separator", "\r\n");
	public static String WEBROOT;
	public static Context sContext;
	
	public static Application sApp;
	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
		sContext = getApplicationContext();
		sApp = this;
		String sdRoot = Environment.getExternalStorageDirectory().getAbsolutePath();
	    File webroot = new File(sdRoot,"WebRoot");
		if(!webroot.exists()){
			webroot.mkdirs();
	    }
		WEBROOT = webroot.getAbsolutePath();
	}
	@Override
	public void onLowMemory() {
		// TODO Auto-generated method stub
		super.onLowMemory();
	}
	public static Context getContext() {
		return sContext;
	}
	public static Application getApp() {
		return sApp;
	}
}
