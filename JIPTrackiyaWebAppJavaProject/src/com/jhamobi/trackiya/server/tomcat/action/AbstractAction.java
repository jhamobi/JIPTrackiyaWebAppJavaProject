package com.jhamobi.trackiya.server.tomcat.action;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;


/**
 * 
 * @author majha
 *
 */
public abstract class AbstractAction implements Action {

	protected String convertStreamToString(InputStream is) {
		try{
			/*
			 * To convert the InputStream to String we use the
			 * BufferedReader.readLine() method. We iterate until the BufferedReader
			 * return null which means there's no more data to read. Each line will
			 * appended to a StringBuilder and returned as String.
			 */
			BufferedReader reader = new BufferedReader(new InputStreamReader(is));
			StringBuilder sb = new StringBuilder();

			String line = null;
			try {
				while ((line = reader.readLine()) != null) {
					sb.append(line + "\n");
				}
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return sb.toString();
		}finally{
			try {
				is.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		
	}

	
	protected byte[] convertStreamToByte(InputStream is) throws IOException {
		try{
			byte[] inputBytes = new byte[is.available()];
			while (is.read(inputBytes) != -1) {  
				
			}
			
			return inputBytes;
		}finally{
			try {
				is.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		
	}
}
