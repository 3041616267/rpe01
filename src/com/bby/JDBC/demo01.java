package com.bby.JDBC;


	
	import java.io.InputStream;
	import java.sql.Connection;
	import java.sql.ResultSet;
	import java.util.Properties;

	import javax.sql.DataSource;

	import com.alibaba.druid.pool.DruidDataSourceFactory;
	public class demo01 {
		public static void main(String[] args) throws Exception {
			Properties pro=new Properties();
			InputStream resourceAsStream=demo01.class.getClassLoader().getResourceAsStream("jdbc.properties");
		    pro.load(resourceAsStream);
		    String property=pro.getProperty("name");
		    String password=pro.getProperty("password");
		    System.out.println(password);
		    System.out.println(property);
		    DataSource datasource=DruidDataSourceFactory.createDataSource(pro);
		    System.out.println(datasource.getConnection());  
		    Connection connection=datasource.getConnection();
		    System.out.println("获取的连接"+connection);    
		}

	}



