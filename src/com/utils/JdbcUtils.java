/*package util;*/
package com.utils;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;

import com.utils.Dbobj;

import java.io.*;

/**
 * @author Leammin
 * @description
 * @date 2017-05-26
 */
public class JdbcUtils {
	
	
	 private static String username=null;            //鐢ㄦ埛鍚�
     private static String password=null;            //瀵嗙爜
private static String dbName=null;                //鏁版嵁搴撳悕绉�
   private static String ip=null;                        //鏁版嵁搴撴湇鍔″櫒IP鍦板潃
   private static String port=null;                 //鏁版嵁搴撴湇鍔″櫒绔彛
	
   //private  Connection conn = null;
   //private  Statement stmt=null;
  // private  PreparedStatement pstmt = null;
   //private ResultSet rs = null;
   /*
   private static void initParams(){
       username=DbConfig.getInstance().getDb_username();            
       password=DbConfig.getInstance().getDb_password();            
        dbName=DbConfig.getInstance().getDb_name();                
       ip=DbConfig.getInstance().getIp();    
       port=DbConfig.getInstance().getPort();   
    }
	
*/
    //鑾峰彇杩炴帴
    public static Connection getConnection() throws SQLException {
    	
    	//***********************************原来的代码一直出错，找不到路径*********************************************
    	/*String path =/*JdbcUtils_jdbc*//*JdbcUtils.class.getClassLoader().getResource("config.properties").getPath();  //杩欑鍐欐硶蹇呴』灏唒roperties鏂囦欢鏀惧湪war鍖呯殑classes鐩綍
    	
    	Properties prop=new Properties();
    	
    
    	  try{   	    	
    	    	try {
    	    		 FileInputStream in=new FileInputStream(path);
					prop.load(in);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}*/
    	//*****************************************************更改后代码***************************************************************
    	Properties prop = new Properties();//属性集合对象

        InputStream path =Thread.currentThread().getContextClassLoader().getResourceAsStream("config.properties");//获取路径并转换成流
    	    	
        try {
			prop.load(path);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 	
   	
    	  username= prop.getProperty("db_username");
    	  password= prop.getProperty("db_password");
    	  dbName= prop.getProperty("db_name");
    	  ip= prop.getProperty("ip");
    	  port=prop.getProperty("port");
    	  
    	 /*username="root";
    	  password= "peng";
    	  dbName= "webdb";
    	  ip= "localhost";
    	  port="3306";*/
    	
    	/*try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException();
        }*/
    	  try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	  
     //   return DriverManager.getConnection("jdbc:mysql://localhost:3306/fx?useUnicode=true&characterEncoding=UTF-8", "root", "root");
    
        return DriverManager.getConnection("jdbc:mysql://"+ip+":"+port+"/"+dbName+"?useUnicode=true&characterEncoding=UTF-8", username, password);
	
    	
    }

    //閲婃斁
    public static void release(Connection conn, Statement st, ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();   //throw new
                rs=null;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (st != null) {
            try {
                st.close();
                st=null;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (conn != null) {
            try {
                conn.close();
                conn=null;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

   

  

 // public ResultSet executeQuery(String sql) {
    public Dbobj executeQuery(String sql) {	
	  Dbobj dj=new Dbobj();
	  
       Connection conn = null;
       Statement stmt=null;
       PreparedStatement pstmt = null;
        ResultSet rs = null;
      
      try{
				//connect=DriverManager.getConnection(sConnStr,"sa","123456$$");
                               conn = /*JdbcUtils_jdbc*/JdbcUtils.getConnection();
			       stmt=conn.createStatement();
				rs=stmt.executeQuery(sql);
				
		dj.setConn(conn);
		dj.setPstmt(pstmt);
		dj.setRs(rs);
		dj.setStmt(stmt);
				
			}catch(SQLException ex){
				System.err.println(ex.getMessage());
			}
			
               
    //      return rs;
      
           return dj;
		}



  
  
    public void executeUpdate(String sql)
	    {
	    	
    	
    	
	    	 Connection conn = null;
       Statement stmt=null;
      
      //  ResultSet rs = null;
	    	try
	    	{  
                     conn = /*JdbcUtils_jdbc*/JdbcUtils.getConnection();
			       stmt=conn.createStatement();
	    		
	    		stmt.executeUpdate(sql);
	    		stmt.close();
	    		conn.close();
	    		
	    		conn=null;
	    		stmt=null;
	    		
	    		
	    	
	    	}
	    	catch(SQLException ex)
	    	{
	    		System.err.println(ex.getMessage());
	    		
	    		
	    	}
	    
	    	
	    }
  
  
    
    
    
    
       
    
    
    
    
    
    
    
    
    


}
