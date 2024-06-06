package Utitlities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
   Properties pro;
	
   public ReadConfig() {
	   File src=new File("./Confiuration/Config.properties");
	   
	   try {
		   FileInputStream FIS=new FileInputStream(src);
		   pro= new Properties();
		   pro.load(FIS);
	   }
	   catch(Exception e){
		   System.out.println("Exception is " + e.getMessage());
	   }
	   
	   
   }
   public String getApplicationUrl() {
	  String baseurl= pro.getProperty("baseurl");
	  return baseurl;
	   
   }
   public String getPass() {
	   String password= pro.getProperty("password");
	   return password;
		   
	   }
   public String getUserName() {
		  String username= pro.getProperty("username");
		  return username;
		   
	   }
	
}
