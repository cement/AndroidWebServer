package com.cement.constants;

import java.io.File;

public class Settings {

	public static String WEBROOT = "/";
	public static MODE VISITMODE = MODE.WEB;
	public static String DEFAULT_PAGE_PATH = "index.html";
	public static String NOTFIND_PAGE_PATH = WEBROOT+"/page404.html";
	
	public static File NOTFIND_PAGE_FILE = new File(WEBROOT,NOTFIND_PAGE_PATH);
	
    public static enum MODE{
    	WEB,FILE;
    }
	
}
