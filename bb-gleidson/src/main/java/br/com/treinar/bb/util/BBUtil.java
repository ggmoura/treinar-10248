package br.com.treinar.bb.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class BBUtil {

	private static BBUtil instance;
	private Properties prop;
	
	static {
		instance = new BBUtil();
	}
	
	private BBUtil() {
		super();
		loadProperties();
	}
	
	private void loadProperties() {
		try (InputStream in = new FileInputStream("config.properties")) {
			prop = new Properties();
			prop.load(in);
		} catch (IOException e) {
			System.out.println("Erro ao recuperar as propriedades");
			System.exit(0);
		}
	}

	public static BBUtil getInstance() {
		return instance;
	}
	
	public String getProperty(String key) {
		return prop.getProperty(key);
	}
	
	
}
