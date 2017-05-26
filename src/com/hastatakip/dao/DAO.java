/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hastatakip.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;





/**
 *
 * @author serkancam
 */
public class DAO 
{
    private static final String DRIVER_NAME = "com.mysql.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/hastatakip?useSSL=false";
    private static final String ID = "root";
    private static final String PASS = "neşem";
    public Connection getConnection()
    {      
        try 
        {
           Class.forName(DRIVER_NAME);
           return DriverManager.getConnection(DB_URL, ID, PASS);            
	}
        catch (ClassNotFoundException | SQLException e) 
        {                        
            throw new RuntimeException(e);            
	}
        
    }
    public void close(Connection con)
    {
        if (con != null) 
        {
            try 
            {
                  con.close();
            } 
            catch (SQLException e) 
            {
            // e.printStackTrace();
             throw new RuntimeException(e);
            }
	}
    }
    public void close(Statement stmt)
    {
		if (stmt != null) 
                {
			try 
                        {
				stmt.close();
			} 
                        catch (SQLException e) 
                        {
				// e.printStackTrace();
				throw new RuntimeException(e);
			}
		}
    }
  
    
    
}
