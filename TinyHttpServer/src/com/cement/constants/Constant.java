package com.cement.constants;

import java.util.HashMap;

public class Constant {

	public static final String PROCTROL11 = "HTTP/1.1";
	public static final String PROCTROL10 = "HTTP/1.0";
	public static final String CRLF = "\r\n";
	public static final String DOT = ".";
	public static final String EMPTY= "";
	public static final String SPACE= " ";
	public static final String COLON= ": ";
	
	
	public static String getResponesStatus(int code){
		String key = String.valueOf(code);
		return Constant.PROCTROL11+Constant.SPACE+key+Constant.SPACE+RESPONES_STATUS.get(key)+Constant.CRLF;
	}
   public static final HashMap<String, String> RESPONES_STATUS = new HashMap<String, String>(){
	
	
	private static final long serialVersionUID = 1L;
		{
	    put("100",	"Continue 继续。");
		put("101",	"Switching Protocols 切换协议。");
		put("200",	"OK");
		put("201",	"Created 已创建。");
		put("202",	"Accepted 已接受。");
		put("203",	"Non-Authoritative Information 非授权信息。");
		put("204",	"No Content	无内容。");
		put("205",	"Reset Content 重置内容。");
		put("206",	"Partial Content 部分内容。");
		put("300",  "Multiple Choices 多种选择。");
		put("301",	"Moved Permanently 永久移动。");
		put("302",	"Found 临时移动。");
		put("303",	"See Other 查看其它地址。");
		put("304",	"Not Modified 未修改。");
		put("305",	"Use Proxy 使用代理。");
		put("306",	"Unused	已经被废弃的HTTP状态码。");
		put("307",	"Temporary Redirect	临时重定向。");
		put("400",	"Bad Request 客户端请求的语法错误，服务器无法理解。");
		put("401",	"Unauthorized 请求要求用户的身份认证。");
		put("402",	"Payment Required 保留，将来使用。");
		put("403",	"Forbidden 服务器理解请求客户端的请求，但是拒绝执行此请求。");
		put("404",	"Not Found");
		put("405",	"Method Not Allowed	客户端请求中的方法被禁止。");
		put("406",	"Not Acceptable	服务器无法根据客户端请求的内容特性完成请求.");
		put("407",	"Proxy Authentication Required	请求要求代理的身份认证。");
		put("408",	"Request Time-out 服务器等待客户端发送的请求时间过长，超时。");
		put("409",	"Conflict 服务器处理请求时发生了冲突。");
		put("410",	"Gone 客户端请求的资源已经不存在。");
		put("411",	"Length Required 服务器无法处理客户端发送的不带Content-Length的请求信息。");
		put("412",	"Precondition Failed 客户端请求信息的先决条件错误。");
		put("413",	"Request Entity Too Large 由于请求的实体过大，服务器无法处理，因此拒绝请求。");
		put("414",	"Request-URI Too Large 请求的URI过长（URI通常为网址），服务器无法处理。");
		put("415",	"Unsupported Media Type 服务器无法处理请求附带的媒体格式。");
		put("416",	"Requested range not satisfiable 客户端请求的范围无效。");
		put("417",	"Expectation Failed 服务器无法满足Expect的请求头信息。");
		put("500",	"Internal Server Error 服务器内部错误，无法完成请求。");
		put("501",	"Not Implemented 服务器不支持请求的功能，无法完成请求。");
		put("502",	"Bad Gateway 充当网关或代理的服务器，从远端服务器接收到了一个无效的请求。");
		put("503",	"Service Unavailable 由于超载或系统维护，服务器暂时的无法处理客户端的请求。");
		put("504",	"Gateway Time-out 充当网关或代理的服务器，未及时从远端服务器获取请求。");
	    put("505",	"HTTP Version not supported	服务器不支持请求的HTTP协议的版本，无法完成处理。");
		}
	};
}

