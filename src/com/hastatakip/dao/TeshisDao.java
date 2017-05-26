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
public class TeshisDao extends DAO
{
   private final String sil = "DELETE FROM teshis WHERE teshisId=?";
   private final String tumListeyiGetir= "SELECT * FROM teshis ORDER BY muayaneId";
   private final String muayeneIdyeGore = "SELECT * FROM teshis WHERE muayeneId=?";
   private final String ismeGore = "SELECT * FROM teshis WHERE teshisAciklama=?";
   private final String ekle = "INSERT INTO teshis(muayeneId, teshisAciklama) VALUES(?,?)";
   private final String guncelle = "UPDATE teshis SET muayeneId=?, teshisAciklama=? WHERE teshisId=?";
        
        public int Sil(int teshisId) 
        {
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try 
                {
			conn = getConnection();                    
			stmt = conn.prepareStatement(sil);
			stmt.setInt(1, teshisId);			
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
        
        public List<Teshis> TumListeyiGetir() 
        {
		Connection conn = null;
		PreparedStatement stmt = null;
		List<Teshis> list = new ArrayList<Teshis>();
		
		try 
                {
			conn = getConnection();
			stmt = conn.prepareStatement(tumListeyiGetir);
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) 
                        {
				Teshis teshis = new Teshis();
				teshis.setTeshisId(rs.getInt("teshisId"));
                                teshis.setMuayeneId(rs.getInt("muayeneId"));
				teshis.setTeshisAciklama(rs.getString("teshisAdi"));
				                                
				list.add(teshis);
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
        
        public List<Teshis> MuayeneIdyeGoreGetir(int muayeneId) 
        {
            Connection conn = null;
		PreparedStatement stmt = null;
		List<Teshis> list = new ArrayList<Teshis>();
		
		try 
                {
			conn = getConnection();
			stmt = conn.prepareStatement(muayeneIdyeGore);
                        stmt.setInt(1,muayeneId);
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) 
                        {
				Teshis teshis = new Teshis();
				teshis.setTeshisId(rs.getInt("teshisId"));
                                teshis.setMuayeneId(rs.getInt("muayeneId"));
				teshis.setTeshisAciklama(rs.getString("teshisAciklama"));
				                                
				list.add(teshis);
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
        
        public int Ekle(Teshis teshis)
        {
            Connection conn = null;
            PreparedStatement stmt = null;
		
		try 
                {
                    conn = getConnection();
                    stmt = conn.prepareStatement(ekle, Statement.RETURN_GENERATED_KEYS);
                    stmt.setInt(1, teshis.getMuayeneId());
                    stmt.setString(2, teshis.getTeshisAciklama());
                                                               
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
        
         public int Guncelle(Teshis teshis)
        {
            Connection conn = null;
            PreparedStatement stmt = null;
		
		try 
                {
                    conn = getConnection();
                    stmt = conn.prepareStatement(guncelle);
                    stmt.setInt(1, teshis.getMuayeneId());
                    stmt.setString(2, teshis.getTeshisAciklama());
                    stmt.setInt(3, teshis.getTeshisId());
                     
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
         
         public Teshis IsmeGoreGetir(Teshis aranan) 
        {
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try 
                {
			conn = getConnection();
			stmt = conn.prepareStatement(ismeGore);
			stmt.setString(1, aranan.getTeshisAciklama());
			
			ResultSet rs = stmt.executeQuery();
			
			if (rs.next()) 
                        {
				Teshis teshis = new Teshis();
				teshis.setTeshisId(rs.getInt("teshisId"));
                                teshis.setMuayeneId(rs.getInt("muayeneId"));
				teshis.setTeshisAciklama(rs.getString("teshisAciklama"));
							
				return teshis;
			} 
                        else 
                        {
				return null;
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
	}
        
}
