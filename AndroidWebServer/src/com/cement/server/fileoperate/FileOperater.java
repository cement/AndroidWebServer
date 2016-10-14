package com.cement.server.fileoperate;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;

public class FileOperater {

	public static boolean writeOut(OutputStream outStream, File outFile){
		   FileInputStream fileInStream = null;
			try{
				fileInStream = new FileInputStream(outFile);
				byte[] buffer = new byte[1024];
				int readed = 0;
				while((readed = fileInStream.read(buffer))!=-1){
					outStream.write(buffer,0,readed);
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
				return false;
			} catch (IOException e) {
				e.printStackTrace();
				return false;
			}
			return true;
	}
}
