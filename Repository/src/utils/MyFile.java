package utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

public class MyFile {
	private InputStream stream;
	private boolean custom;
	private String path;
	private String name;
	
	private String separate(String path) {
		return '/' + path;
	}
	
	public MyFile(File file, String path) {
		this.path = file.getPath() + separate(path);
		this.name = new File(this.path).getName();
		this.custom = true;
	}
	
	public MyFile(String path) {
		this.path = separate(path);
		String[] dirs = path.split("/");
		this.name = dirs[dirs.length - 1];
	}
	
	public MyFile(String... paths) {
		String[] dirs = this.path.split("/");
		
		this.name = dirs[dirs.length - 1];
		this.path = "";
		
		for (String string : paths) this.path = String.valueOf(this.path) + separate(string);
	}
	
	public MyFile(MyFile file, String subFile) {
		this.path = String.valueOf(file.path) + separate(subFile);
		this.name = subFile;
	}
	
	public MyFile(MyFile file, String... subFiles) {
		String[] dirs = this.path.split("/");
		
		this.name = dirs[dirs.length - 1];
		this.path = file.path;
		
		for (String subFile : subFiles) this.path = String.valueOf(this.path) + separate(subFile);
	}
	
	public MyFile(InputStream stream, String name) {
		this.stream = stream;
		this.name = name;
	}

	public String getPath() {
		return this.path;
	}
	
	public String toString() {
		return getPath();
	}
	
	public InputStream getInputStream() {
		if (custom) { 
			try { 
				return new FileInputStream(path);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		} else if (stream != null) {
			return stream;
		}
		
		return getClass().getResourceAsStream(this.path);
	}
	
	public URL getUrl() {
		return getClass().getResource(this.path);
	}
	
	public CSVReader openCsvReader() throws Exception {
		return new CSVReader(this);
	}
  
	public BufferedReader getReader() throws Exception {
		try {
			return new BufferedReader(new InputStreamReader(getInputStream()));
		} catch (Exception e) {
			System.err.println("Couldn't get reader for " + this.path);
			throw e;
		} 
	}
	
	public String getName() {
		return this.name;
	}
}
