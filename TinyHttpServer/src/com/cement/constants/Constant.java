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
	    put("100",	"Continue ������");
		put("101",	"Switching Protocols �л�Э�顣");
		put("200",	"OK");
		put("201",	"Created �Ѵ�����");
		put("202",	"Accepted �ѽ��ܡ�");
		put("203",	"Non-Authoritative Information ����Ȩ��Ϣ��");
		put("204",	"No Content	�����ݡ�");
		put("205",	"Reset Content �������ݡ�");
		put("206",	"Partial Content �������ݡ�");
		put("300",  "Multiple Choices ����ѡ��");
		put("301",	"Moved Permanently �����ƶ���");
		put("302",	"Found ��ʱ�ƶ���");
		put("303",	"See Other �鿴������ַ��");
		put("304",	"Not Modified δ�޸ġ�");
		put("305",	"Use Proxy ʹ�ô���");
		put("306",	"Unused	�Ѿ���������HTTP״̬�롣");
		put("307",	"Temporary Redirect	��ʱ�ض���");
		put("400",	"Bad Request �ͻ���������﷨���󣬷������޷���⡣");
		put("401",	"Unauthorized ����Ҫ���û��������֤��");
		put("402",	"Payment Required ����������ʹ�á�");
		put("403",	"Forbidden �������������ͻ��˵����󣬵��Ǿܾ�ִ�д�����");
		put("404",	"Not Found");
		put("405",	"Method Not Allowed	�ͻ��������еķ�������ֹ��");
		put("406",	"Not Acceptable	�������޷����ݿͻ�����������������������.");
		put("407",	"Proxy Authentication Required	����Ҫ�����������֤��");
		put("408",	"Request Time-out �������ȴ��ͻ��˷��͵�����ʱ���������ʱ��");
		put("409",	"Conflict ��������������ʱ�����˳�ͻ��");
		put("410",	"Gone �ͻ����������Դ�Ѿ������ڡ�");
		put("411",	"Length Required �������޷�����ͻ��˷��͵Ĳ���Content-Length��������Ϣ��");
		put("412",	"Precondition Failed �ͻ���������Ϣ���Ⱦ���������");
		put("413",	"Request Entity Too Large ���������ʵ����󣬷������޷�������˾ܾ�����");
		put("414",	"Request-URI Too Large �����URI������URIͨ��Ϊ��ַ�����������޷�����");
		put("415",	"Unsupported Media Type �������޷��������󸽴���ý���ʽ��");
		put("416",	"Requested range not satisfiable �ͻ�������ķ�Χ��Ч��");
		put("417",	"Expectation Failed �������޷�����Expect������ͷ��Ϣ��");
		put("500",	"Internal Server Error �������ڲ������޷��������");
		put("501",	"Not Implemented ��������֧������Ĺ��ܣ��޷��������");
		put("502",	"Bad Gateway �䵱���ػ����ķ���������Զ�˷��������յ���һ����Ч������");
		put("503",	"Service Unavailable ���ڳ��ػ�ϵͳά������������ʱ���޷�����ͻ��˵�����");
		put("504",	"Gateway Time-out �䵱���ػ����ķ�������δ��ʱ��Զ�˷�������ȡ����");
	    put("505",	"HTTP Version not supported	��������֧�������HTTPЭ��İ汾���޷���ɴ���");
		}
	};
}

