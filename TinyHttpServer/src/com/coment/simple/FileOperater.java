package com.coment.simple;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;

import com.cement.constants.Settings;

public class FileOperater {

	
	
	public static void writeOutFile(OutputStream outStream, File outFile){
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
			} catch (IOException e) {
				e.printStackTrace();
			}
	}
	
}
