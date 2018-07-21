package com.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Dbobj {
	
	
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private  Statement stmt=null;
	private  ResultSet rs = null;

	   public Connection getConn(){
	      return conn;
	   }

	   public PreparedStatement getPstmt(){
	      return pstmt;
	   }

	   public  Statement getStmt(){
	      return stmt;
	   }

	   public  ResultSet getRs(){
	      return rs;
	   }

	  
	   public void setConn( Connection conn){
		      this.conn = conn;
		   }
	
	   
	   
	   public void setStmt( Statement stmt){
		      this.stmt = stmt;
		   }
	

	   
	   public void setPstmt( PreparedStatement pstmt){
		      this.pstmt = pstmt;
		   }
	   
	   public void setRs( ResultSet rs){
		      this.rs = rs;
		   }
	   
	   
	   
	   
}
