package com.cement.constants;

import java.io.File;
import java.util.HashMap;

public class ContentType {

	public static String getType(String tail) {
		return MIME.get(tail);

	}
	public static String getType(File file) {
		if(file.isDirectory()){
			return "Directory";
		}else{
			String typekey = file.getName().substring(file.getName().lastIndexOf(Constant.DOT));
			return getType(typekey);
		}
	}
//	 public static Map<String, String> mimeTypes() {
//	        if (MIME_TYPES == null) {
//	            MIME_TYPES = new HashMap<String, String>();
//	            loadMimeTypes(MIME_TYPES, "mimetypes.properties");
//	            loadMimeTypes(MIME_TYPES, "META-INF/nanohttpd/mimetypes.properties");
//	            if (MIME_TYPES.isEmpty()) {
//	                LOG.log(Level.WARNING, "no mime types found in the classpath! please provide mimetypes.properties");
//	            }
//	        }
//	        return MIME_TYPES;
//	    }
//
//	    private static void loadMimeTypes(Map<String, String> result, String resourceName) {
//	        try {
//	            Enumeration<URL> resources = ContentType.class.getClassLoader().getResources(resourceName);
//	            while (resources.hasMoreElements()) {
//	                URL url = (URL) resources.nextElement();
//	                Properties properties = new Properties();
//	                InputStream stream = null;
//	                try {
//	                    stream = url.openStream();
//	                    properties.load(stream);
//	                } catch (IOException e) {
//	                    LOG.log(Level.SEVERE, "could not load mimetypes from " + url, e);
//	                } finally {
//	                    safeClose(stream);
//	                }
//	                result.putAll((Map) properties);
//	            }
//	        } catch (IOException e) {
//	            LOG.log(Level.INFO, "no mime types available at " + resourceName);
//	        }
//	    };

	public static HashMap<String, String> MIME = new HashMap<String, String>() {
		
		
		private static final long serialVersionUID = 1L;

		{
			put(".htm", "text/html;charset=utf-8");
			put(".html", "text/html;charset=utf-8");
			put(".xml", "text/xml;charset=utf-8");
			put(".txt", "text/plain;charset=utf-8");
			put(".json", "text/plain;charset=utf-8");
			put(".css", "text/css;charset=utf-8");
			put(".ico", "image/x-icon;charset=utf-8");
			put(".png", "image/png");
			put(".gif", "image/gif");
			put(".jpg", "image/jpg");
			put(".jpeg", "image/jpeg");
			put(".zip", "application/zip");
			put(".rar", "application/rar");
			put(".js", "text/javascript;charset=utf-8");
		}
	};
	
	
}
