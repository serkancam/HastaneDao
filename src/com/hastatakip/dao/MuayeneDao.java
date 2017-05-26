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
public class MuayeneDao extends DAO
{
   private final String sil = "DELETE FROM muayene WHERE muayeneId=?";
   private final String tumListeyiGetir= "SELECT * FROM muayene ORDER BY muayeneId";
   private final String IdyeGore = "SELECT * FROM muayene WHERE muayeneId=?";
   private final String hastaAdinaGore = "SELECT * FROM muayene WHERE hastaTC=? and doktorTC=?";
   private final String ekle = "INSERT INTO muayene(muayeneTarihi,hastaTC,doktorTC) VALUES(?,?,?)";
   private final String guncelle = "UPDATE muayene SET muayeneTarihi=?, hastaTC=?, doktorTC=? WHERE muayeneId=?";
        
        public int Sil(int muayeneId) 
        {
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try 
                {
			conn = getConnection();                    
			stmt = conn.prepareStatement(sil);
			stmt.setInt(1, muayeneId);			
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
        
        public List<Muayene> TumListeyiGetir() 
        {
		Connection conn = null;
		PreparedStatement stmt = null;
		List<Muayene> list = new ArrayList<Muayene>();
		
		try 
                {
			conn = getConnection();
			stmt = conn.prepareStatement(tumListeyiGetir);
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) 
                        {
				Muayene muayene = new Muayene();
				muayene.setMuayeneId(rs.getInt("muayeneId"));
				muayene.setMuayeneTarihi(rs.getDate("muayeneTarihi"));
                                muayene.setHastaTC(rs.getString("hastaTC"));
				muayene.setDoktorTC(rs.getString("doktorTC"));				
                                
				list.add(muayene);
			}
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
		
		return list;
	}
        
        public Muayene IdyeGoreGetir(int Id) 
        {
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try 
                {
			conn = getConnection();
			stmt = conn.prepareStatement(IdyeGore);
			stmt.setInt(1, Id);
			
			ResultSet rs = stmt.executeQuery();
			
			if (rs.next()) 
                        {
				Muayene muayene = new Muayene();
				muayene.setMuayeneId(rs.getInt("muayeneId"));
				muayene.setMuayeneTarihi(rs.getDate("muayeneTarihi"));
                                muayene.setHastaTC(rs.getString("hastaTC"));
				muayene.setDoktorTC(rs.getString("doktorTC"));
								
				return muayene;
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
	}
        
        public int Ekle(Muayene muayene)
        {
            Connection conn = null;
            PreparedStatement stmt = null;
		
		try 
                {
                    conn = getConnection();
                    stmt = conn.prepareStatement(ekle, Statement.RETURN_GENERATED_KEYS);
                    stmt.setObject(1, muayene.getMuayeneTarihi());
                    stmt.setString(2, muayene.getHastaTC());
                    stmt.setString(3, muayene.getDoktorTC());
                    
                                           
                    stmt.executeUpdate();
                    ResultSet rs = stmt.getGeneratedKeys();
                    rs.next();
                    return rs.getInt(1);
                    
                    
                    
                    
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
        
         public int Guncelle(Muayene muayene)
        {
            Connection conn = null;
            PreparedStatement stmt = null;
		
		try 
                {
                    conn = getConnection();
                    stmt = conn.prepareStatement(guncelle);
                    stmt.setInt(1, muayene.getMuayeneId());
                    stmt.setObject(2, muayene.getMuayeneTarihi());
                    stmt.setString(3, muayene.getHastaTC());
                    stmt.setString(4, muayene.getDoktorTC());
                                          
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
         
         public  List<Muayene> HastaAdinaGoreGetir(Muayene aranan) 
         {
             Connection conn = null;
		PreparedStatement stmt = null;
		List<Muayene> list = new ArrayList<Muayene>();
		
		try 
                {
			conn = getConnection();
			stmt = conn.prepareStatement(hastaAdinaGore);
			stmt.setString(1, aranan.getHastaTC());
                        stmt.setString(2, aranan.getDoktorTC());
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) 
                        {
				Muayene muayene = new Muayene();
				muayene.setMuayeneId(rs.getInt("muayeneId"));
				muayene.setMuayeneTarihi(rs.getDate("muayeneTarihi"));
                                muayene.setHastaTC(rs.getString("hastaTC"));
				muayene.setDoktorTC(rs.getString("doktorTC"));				
                                
				list.add(muayene);
			}
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
		
		return list;
		
	} 
         
            
}
