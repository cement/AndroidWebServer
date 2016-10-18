package com.cement.server;

import com.cement.constants.Constant;

public class ResponsStatu {
	private  String proctrol;
	private  String rescode;
	private  String resmsg;
	
	
	public void setStatus(String strStatu){
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
