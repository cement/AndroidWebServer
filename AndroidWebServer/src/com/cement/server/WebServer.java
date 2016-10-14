package com.cement.server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.cement.server.sessionhandler.GetSessionHandler;
import com.cement.server.sessionhandler.HandlerManager;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class WebServer extends Service{
	
	private ExecutorService mThreadPool;
	private ServerThread mServerThread;
	private boolean canStart = true;
	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
		mThreadPool = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
	    mServerThread = new ServerThread();
	    HandlerManager.rigistSessionHandler(new GetSessionHandler("GET"));
	}

	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		// TODO Auto-generated method stub
		String command = intent.getStringExtra("command");
		if(command.equals("start")){
			if(canStart){
				mServerThread = new ServerThread();
				mServerThread.start();
				canStart = false;
			}
		}else if(command.equals("stop")){
			mServerThread.stopSelf();
		}
		return super.onStartCommand(intent, flags, startId);
	}
	
	private class ServerThread extends Thread{
		
		private boolean exit;
		private int port = 9999;
        private ServerSocket ssocket;
		@Override
		public void run() {
			// TODO Auto-generated method stub
			try {
				ssocket = new ServerSocket(port);
				Log.i(getClass().getSimpleName(), "Server started and listening at : "+port);
				//ssocket.setSoTimeout(timeout);
				while(!exit){
					Socket socket = ssocket.accept();
					SessionRunnable session = new SessionRunnable(socket);
					mThreadPool.execute(session);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}finally {
				stopSelf();
				Log.i(getClass().getSimpleName(), "Server has stoped .............: "+port);
			}
			
		}

		public void stopSelf(){
			exit = true;
			try {
				if(ssocket!=null&&!ssocket.isClosed()){
					canStart = true;
					ssocket.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			//this.interrupt();
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
				inStream = socket.getInputStream();
				outStream = socket.getOutputStream();
				HttpRequest request = new HttpRequest(inStream);
				HttpRespons respons = new HttpRespons(outStream);
				HandlerManager.disapcthHandler(request, respons);
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
}
