package com.bby.JDBC;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class demo02 {
	public static void main(String[] args) {
		 // add();
		  //updateuser();
		  //count();
		  //find();
		  // dele();
		   deleuser();

		
		}
	 public static void deleuser(){
		   JdbcTemplate jt=new JdbcTemplate(JDBCUntils.getDataSource());
		   int update =jt.update("delete from person where name=?","青钢影");
		   System.out.println(update);
	   }
	   
		 public static void dele() {
			   JdbcTemplate jt=new JdbcTemplate(JDBCUntils.getDataSource());
			   int update =jt.update("delete from person where id=?",5);
			   System.out.println(update);
			   
		   }
		  
	 public static void find() {
		   JdbcTemplate jt=new JdbcTemplate(JDBCUntils.getDataSource());
	   List<User> list=jt.query("select * from person where id=?", new BeanPropertyRowMapper<User>(User.class),4);
	   User user2=list.get(0);
	   
	   System.out.println(user2);
	   }
	public static void count() {
		   JdbcTemplate jt=new JdbcTemplate(JDBCUntils.getDataSource());
		   String sql="select * from person";
		   List<User> list=jt.query(sql, new BeanPropertyRowMapper<User>(User.class));
		   for(User user : list) {
			   System.out.println(user);
		   }
	  }
	 
	   public static void updateuser() {
		   JdbcTemplate jt=new JdbcTemplate(JDBCUntils.getDataSource());
		   int update=jt.update("update person set name=?,username=?,password=?,descd=?,height=?,age=? where id=?","亚索","123",102,"剑豪","190",26,5);
		   System.out.println(update);
	   }
	  
	  
	 public static void add(){
		 JdbcTemplate jt=new JdbcTemplate(JDBCUntils.getDataSource());
		 String sql="insert into person(name,username,password,descd,height,age) values (?,?,?,?,?,?)";
		 int update=jt.update(sql,"奥恩","123",100,"非常肉",188,56);
		 int update1=jt.update(sql,"青钢影","124",101,"战士类",188,23);
		 System.out.println(update);
		 System.out.println(update);
	 }

	  
	  
	   
	
	  
	  
	 
     

	}

