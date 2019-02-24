package com.betPawa.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ProjectConfig {
public static Properties prop = new Properties();
	
	static {		
		try {
			File file = new File("src\\main\\java\\org\\betPawa\\config\\ProjectConfig.properties");
			FileInputStream fis = new FileInputStream(file);
			prop.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
