package com.cement.server;

import com.cement.utils.Constant;

public class ResponsStatu {
	private  String proctrol;
	private  String rescode;
	private  String resmsg;
	
	
	public ResponsStatu() {
		super();
	}
//	public ResponsStatu(String proctrol, String rescode, String resmsg) {
//		this.proctrol = proctrol;
//		this.rescode = rescode;
//		this.resmsg = resmsg;
//	}
//	public ResponsStatu(String strStatu) {
//		String[] arry = strStatu.split(" ");
//		if(arry.length == 3){
//			this.proctrol = arry[0];
//			this.rescode = arry[1];
//			this.resmsg = arry[2];	
//		}
//	}
	public void putStatu(String strStatu){
		String[] arry = strStatu.split(" ");
		if(arry.length == 3){
			this.proctrol = arry[0];
			this.rescode = arry[1];
			this.resmsg = arry[2];	
		}
	}
	public void setProctrol(String proctrol) {
		this.proctrol = proctrol;
	}
	public String getRescode() {
		return rescode;
	}
	public void setRescode(String rescode) {
		this.rescode = rescode;
	}
	public String getResmsg() {
		return resmsg;
	}
	public void setResmsg(String resmsg) {
		this.resmsg = resmsg;
	}
	@Override
	public String toString() {
		return  proctrol + " " + rescode + " " + resmsg + Constant.CRLF;
	}
	
}
