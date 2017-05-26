/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hastatakip.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.hastatakip.entity.*;
import java.sql.Statement;

/**
 *
 * @author serkancam
 */
public class VerilenIlacDao extends DAO
{
   private final String sil = "DELETE FROM verilenIlac WHERE verilenIlacId=?";
   private final String muayeneIdyeGore = "SELECT * FROM verilenIlac WHERE muayeneId=?";
   private final String ekle = "INSERT INTO verilenIlac(ilacId,muayeneId) VALUES(?,?)";
   private final String guncelle = "UPDATE verilenIlac SET ilacId=?, muayeneId=? WHERE verilenIlacId=?";
        
        public int Sil(int verilenIlacId) 
        {
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try 
                {
			conn = getConnection();                    
			stmt = conn.prepareStatement(sil);
			stmt.setInt(1, verilenIlacId);		
                        	
			return stmt.executeUpdate();
                        
		} 
                catch (SQLException e) 
                {
			// e.printStackTrace();
			throw new RuntimeException(e);
		} 
                finally 
                {
			close(stmt);
			close(conn);
		}
	}        
            
        public List<VerilenIlac> MuayeneIdyeGoreGetir(int muayeneId) 
        {
		Connection conn = null;
		PreparedStatement stmt = null;
                List<VerilenIlac> list = new ArrayList<VerilenIlac>();
		
		try 
                {
			conn = getConnection();
			stmt = conn.prepareStatement(muayeneIdyeGore);
			stmt.setInt(1, muayeneId);
			
			ResultSet rs = stmt.executeQuery();
			
			if (rs.next()) 
                        {
				VerilenIlac verilenIlac = new VerilenIlac();
				verilenIlac.setVerilenIlacId(rs.getInt("verilenIlacId"));
                                verilenIlac.setMuayeneId(rs.getInt("muayeneId"));
				verilenIlac.setIlacId(rs.getInt("ilacId"));
                                
				list.add(verilenIlac);				
				
			} 
                        else 
                        {
				return null;
			}
		} catch (SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			close(stmt);
			close(conn);
		}
                return list;
	}
        
        public int Ekle(VerilenIlac verilenIlac)
        {
            Connection conn = null;
            PreparedStatement stmt = null;
		
		try 
                {
                    conn = getConnection();
                    stmt = conn.prepareStatement(ekle,Statement.RETURN_GENERATED_KEYS);
                    stmt.setInt(1, verilenIlac.getIlacId());
                    stmt.setInt(2, verilenIlac.getMuayeneId());
                                           
                    int result = stmt.executeUpdate();	
                    return result;
		}
                catch (SQLException e) 
                {
			// e.printStackTrace();
                    throw new RuntimeException(e);
		} 
                finally 
                {
                    close(stmt);
                    close(conn);
		}

            
        }
        
         public int Guncelle(VerilenIlac verilenIlac)
        {
            Connection conn = null;
            PreparedStatement stmt = null;
		
		try 
                {
                    conn = getConnection();
                    stmt = conn.prepareStatement(guncelle);
                    stmt.setInt(1, verilenIlac.getIlacId());
                    stmt.setInt(2, verilenIlac.getMuayeneId());
                    stmt.setInt(3, verilenIlac.getVerilenIlacId());
                                          
                    int result = stmt.executeUpdate();	
                    return result;
		}
                catch (SQLException e) 
                {
			// e.printStackTrace();
                    throw new RuntimeException(e);
		} 
                finally 
                {
                    close(stmt);
                    close(conn);
		}

            
        }
         
         
}
