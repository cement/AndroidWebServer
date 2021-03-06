package com.cement.server;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.cement.server.handler.SessionManager;
import com.cement.constants.Settings;
import com.cement.constants.Settings.MODE;
import com.cement.server.handler.ISessionHandler;


public class EmbedHttpServer{
	
	private ExecutorService mThreadPool;
	private ServerRnnable mServerRunnabe;
    
	public EmbedHttpServer(int port) {
		mServerRunnabe = new ServerRnnable(port);
		Runtime.getRuntime().addShutdownHook(new ShutdownHookThread());
		mThreadPool = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
	}
	public void setWebRoot(String webroot){
		Settings.WEBROOT = webroot;
	}
	public void setVisitMode(MODE mode){
		Settings.VISITMODE = mode;
	}
	public void setNotFindPage(String notfind){
		Settings.NOTFIND_PAGE_PATH = notfind;
		Settings.NOTFIND_PAGE_FILE = new File(Settings.NOTFIND_PAGE_PATH);
	}
	public void start() {
		mServerRunnabe.startSelf();
	}
	public void stop() {
		mServerRunnabe.stopSelf();  
	}
	public void addHandler(ISessionHandler handler){
		SessionManager.rigistSessionHandler(handler);
	}
	public void removeHandler(ISessionHandler handler){
		SessionManager.unRigistSessionHandler(handler);
	}
	private class ServerRnnable implements Runnable{
		
		private boolean exit;
		private int port = 8080;
        private ServerSocket ssocket;
        private boolean starting;

		public ServerRnnable(int port) {
			this.port = port;
		}

		@Override
		public void run() {
			try {
				ssocket = new ServerSocket(port);
				//ssocket.setSoTimeout(timeout);
				while(!exit){
					Socket socket = ssocket.accept();
					System.out.println("..............ssocket.accept().............");
					SessionRunnable session = new SessionRunnable(socket);
					mThreadPool.execute(session);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}finally {
				starting = false;
				stopSelf();
			}
			
		}

		public void startSelf(){
			 if(!starting){
				   starting = true;
				   mThreadPool.execute(this);
			  }
		}
		public void stopSelf(){
			exit = true;
			Socket socket = null;
			try {
				socket = new Socket("127.0.0.1",port+1);
				socket.getOutputStream().write(0);
			} catch (UnknownHostException e) {
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
//			try {
//				if(ssocket!=null&&!ssocket.isClosed()){
//					starting = false;
//					ssocket.close();
//				}
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
			//this.interrupt();
			Scanner s;
		}
	}
	private class SessionRunnable implements Runnable{

		private Socket socket;
		private OutputStream outStream;
		private InputStream inStream;

		public SessionRunnable(Socket socket) {
			// TODO Auto-generated constructor stub
			this.socket = socket;
		}

		
		@Override
		public void run() {
			try {
				HttpSession session = new HttpSession(socket);
				SessionManager.dispatchHandler(session);
			} catch (IOException e) {
				e.printStackTrace();
			}finally {
				this.close();
			}
		}
		public void close(){
			try {
				if (inStream != null) {
					inStream.close();
				}
				if (outStream != null) {
					outStream.close();
				}
				if(socket!=null&&!socket.isClosed()){
					socket.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	private class ShutdownHookThread extends Thread{

		@Override
		public void run() {
			System.out.println("............server is  shutdowning.............");
		}
		
	}
}
