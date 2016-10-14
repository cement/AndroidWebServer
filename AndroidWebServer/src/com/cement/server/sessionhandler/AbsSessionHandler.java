package com.cement.server.sessionhandler;

import com.cement.server.HttpRequest;
import com.cement.server.HttpRespons;

public abstract class AbsSessionHandler {

	public void dispathhander(HttpRequest request, HttpRespons respons){
		if(request.statu.getMethod().equals("GET")){
			doGetMethod(request, respons);
		}else if(request.statu.getMethod().equals("POST")){
			doPostMethod(request, respons);
		}else if(request.statu.getMethod().equals("PUT")){
			doPutMethod(request, respons);
		}else if(request.statu.getMethod().equals("HEAD")){
			doHeadMethod(request, respons);
		}else if(request.statu.getMethod().equals("DELETE")){
			doDeleteMethod(request, respons);
		}else if(request.statu.getMethod().equals("TRACK")){
			doTrackMethod(request, respons);
		}else if(request.statu.getMethod().equals("CONNECT")){
			doConnectMethod(request, respons);
		}else if(request.statu.getMethod().equals("OPTIONS")){
			doOptionsMethod(request, respons);
		}else if(request.statu.getMethod().equals("COPY")){
			doCopyMethod(request, respons);
		}else if(request.statu.getMethod().equals("PATCH")){
			doPatchMethod(request, respons);
		}else if(request.statu.getMethod().equals("LINK")){
			doLinkMethod(request, respons);
		}else if(request.statu.getMethod().equals("UNLINK")){
			doUnlinkMethod(request, respons);
		}else if(request.statu.getMethod().equals("PURGE")){
			doPurgeMethod(request, respons);
		}else if(request.statu.getMethod().equals("LOCK")){
			doLockMethod(request, respons);
		}else if(request.statu.getMethod().equals("UNLOCK")){
			doUnlockMethod(request, respons);
		}else if(request.statu.getMethod().equals("PROPFIND")){
			doPropfindMethod(request, respons);
		}else if(request.statu.getMethod().equals("VIEW")){
			doViewMethod(request, respons);
		}else{
			doUnknownMethod(request, respons);
		}
	}
	public abstract void doGetMethod(HttpRequest request,HttpRespons respons);
	public abstract void doPostMethod(HttpRequest request,HttpRespons respons);
	public abstract void doPutMethod(HttpRequest request,HttpRespons respons);
	public abstract void doHeadMethod(HttpRequest request,HttpRespons respons);
	public abstract void doDeleteMethod(HttpRequest request,HttpRespons respons);
	public abstract void doTrackMethod(HttpRequest request,HttpRespons respons);
	public abstract void doOptionsMethod(HttpRequest request,HttpRespons respons);
	public abstract void doConnectMethod(HttpRequest request,HttpRespons respons);
	public abstract void doCopyMethod(HttpRequest request,HttpRespons respons);
	public abstract void doPatchMethod(HttpRequest request,HttpRespons respons);
	public abstract void doLinkMethod(HttpRequest request,HttpRespons respons);
	public abstract void doUnlinkMethod(HttpRequest request,HttpRespons respons);
	public abstract void doPurgeMethod(HttpRequest request,HttpRespons respons);
	public abstract void doLockMethod(HttpRequest request,HttpRespons respons);
	public abstract void doUnlockMethod(HttpRequest request,HttpRespons respons);
	public abstract void doPropfindMethod(HttpRequest request,HttpRespons respons);
	public abstract void doViewMethod(HttpRequest request,HttpRespons respons);
	public abstract void doUnknownMethod(HttpRequest request,HttpRespons respons);
}
