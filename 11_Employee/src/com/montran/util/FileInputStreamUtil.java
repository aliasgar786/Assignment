package com.montran.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class FileInputStreamUtil {
	private byte[] data;
	private InputStream inputStream;
	public byte[] getFileData(File file) {
		
		try {
			data=new byte[(int)file.length()];		
			inputStream=new FileInputStream(file);
			inputStream.read(data);
			return data;
		}catch (FileNotFoundException e) {
			System.out.println("FileNotFoundException::");
			System.out.println(e.getMessage());
		}catch (IOException e) {
			System.out.println("IOException::");
			System.out.println(e.getMessage());
		}finally {
			try {
				inputStream.close();
			} catch (IOException e) {
				System.out.println("IOException::");
				System.out.println(e.getMessage());
			}
		}
		
		return null;
	}
}
