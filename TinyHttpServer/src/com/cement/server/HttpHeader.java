package com.cement.server;

import java.io.File;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.cement.constants.Constant;
import com.cement.constants.ContentType;


public class HttpHeader extends HashMap<String,String> {
	
	private static final long serialVersionUID = 1L;
	
	public static final String TAG = "HttpHeader";

   

	public HttpHeader() {
		super();
	}



	public HttpHeader(Map<? extends String, ? extends String> m) {
		super(m);
		// TODO Auto-generated constructor stub
	}

	public HttpHeader getBaseHeader(File file){
		HttpHeader header = new HttpHeader(GeneralHeader);
		header.put("Content-Length",String.valueOf(file.length()));
		header.put("Content-Type",ContentType.getType(file));
		//header.put("Content-Encoding","gzip");
		header.put("Last-Modified",String.valueOf(file.lastModified()));
		return header;
		
	}
	public HttpHeader getGeneralHeader(){
		return GeneralHeader;
	}
	
	public static HttpHeader GeneralHeader = new HttpHeader(){
		private static final long serialVersionUID = 1L;
		{
			put("server","DcqEmbedWebServer 1.0.0");
			put("Connection","Keep-Alive");
			//put("Connection","Close");
			put("Keep-Alive","60");
			put("Date",new Date().toString());
			put("Allow","GET,POST");
			put("Cache-Control","no-cache");
			put("Accept-Ranges","none");
			put("Content-language","zh,en");
		}
	};


	public String toString() {
        StringBuilder sb = new StringBuilder();
        for (String name : keySet()) {
            String value = get(name);
           // if (sb.length() > 0) sb.append(" ");
            sb.append(name + Constant.COLON + value +Constant.CRLF);
        }
        return sb.toString();
    }
	
	
}
