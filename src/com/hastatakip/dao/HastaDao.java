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

/**
 *
 * @author serkancam
 */
public class HastaDao extends DAO
{
        private final String sil = "DELETE FROM hasta WHERE hastaTC=?";
	private final String tumListeyiGetir= "SELECT * FROM hasta ORDER BY hastaTC";
	private final String TCyeGore = "SELECT * FROM hasta WHERE hastaTC=?";
	private final String ismeGore = "SELECT * FROM hasta WHERE hastaAdi=? or hastaSoyadi=?";
	private final String ekle = "INSERT INTO hasta(hastaTC, hastaAdi, hastaSoyadi,hastaDogumTarihi) VALUES(?,?,?,?)";
	private final String guncelle = "UPDATE hasta SET hastaAdi=?, hastaSoyadi=?, hastaDogumTarihi=? WHERE hastaTC=?";
        
        public int Sil(String hastaTC) 
        {
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try 
                {
			conn = getConnection();
			stmt = conn.prepareStatement(sil);
			stmt.setString(1, hastaTC);			
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
        
        public List<Hasta> TumListeyiGetir() 
        {
		Connection conn = null;
		PreparedStatement stmt = null;
		List<Hasta> list = new ArrayList<Hasta>();
		
		try 
                {
			conn = getConnection();
			stmt = conn.prepareStatement(tumListeyiGetir);
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) 
                        {
				Hasta hasta = new Hasta();
				hasta.setHastaTC(rs.getString("hastaTC"));
				hasta.setHastaAdi(rs.getString("hastaAdi"));
				hasta.setHastaSoyadi(rs.getString("hastaSoyadi"));
				hasta.setHastaDogumTarihi(rs.getDate("hastaDogumTarihi"));
                                
				list.add(hasta);
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
        
        public Hasta TCyeGoreGetir(String tc) 
        {
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try 
                {
			conn = getConnection();
			stmt = conn.prepareStatement(TCyeGore);
			stmt.setString(1, tc);
			
			ResultSet rs = stmt.executeQuery();
			
			if (rs.next()) 
                        {
				Hasta hasta = new Hasta();
				hasta.setHastaTC(rs.getString("hastaTC"));
				hasta.setHastaAdi(rs.getString("hastaAdi"));
				hasta.setHastaSoyadi(rs.getString("hastaSoyadi"));
				hasta.setHastaDogumTarihi(rs.getDate("hastaDogumTarihi"));
				
				return hasta;
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
        
        public int Ekle(Hasta hasta)
        {
            Connection conn = null;
            PreparedStatement stmt = null;
		
		try 
                {
                    conn = getConnection();
                    stmt = conn.prepareStatement(ekle);
                    stmt.setString(1, hasta.getHastaTC());
                    stmt.setString(2, hasta.getHastaAdi());
                    stmt.setString(3, hasta.getHastaSoyadi());
                    stmt.setObject(4, hasta.getHastaDogumTarihi());	
                        
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
        
         public int Guncelle(Hasta hasta)
        {
            Connection conn = null;
            PreparedStatement stmt = null;
		
		try 
                {
                    conn = getConnection();
                    stmt = conn.prepareStatement(guncelle);
                    stmt.setString(4, hasta.getHastaTC());
                    stmt.setString(1, hasta.getHastaAdi());
                    stmt.setString(2, hasta.getHastaSoyadi());
                    stmt.setObject(3, hasta.getHastaDogumTarihi());	
                        
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
         
         public Hasta IsmeGoreGetir(Hasta aranan) 
        {
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try 
                {
			conn = getConnection();
			stmt = conn.prepareStatement(ismeGore);
			stmt.setString(1, aranan.getHastaAdi());
                        stmt.setString(2, aranan.getHastaSoyadi());
			
			ResultSet rs = stmt.executeQuery();
			
			if (rs.next()) 
                        {
				Hasta hasta = new Hasta();
				hasta.setHastaTC(rs.getString("hastaTC"));
				hasta.setHastaAdi(rs.getString("hastaAdi"));
				hasta.setHastaSoyadi(rs.getString("hastaSoyadi"));
				hasta.setHastaDogumTarihi(rs.getDate("hastaDogumTarihi"));
				
				return hasta;
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
