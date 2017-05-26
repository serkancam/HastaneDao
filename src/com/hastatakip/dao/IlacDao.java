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
public class IlacDao extends DAO
{
   private final String sil = "DELETE FROM ilac WHERE ilacId=?";
   private final String tumListeyiGetir= "SELECT * FROM ilac ORDER BY ilacId";
   private final String IdyeGore = "SELECT * FROM ilac WHERE ilacId=?";
   private final String ismeGore = "SELECT * FROM ilac WHERE ilacAdi=?";
   private final String ekle = "INSERT INTO ilac(ilacAdi) VALUES(?)";
   private final String guncelle = "UPDATE ilac SET ilacAdi=? WHERE ilacId=?";
   private final String muayeneIdyeGore="select i.ilacId,i.ilacAdi from verilenIlac as vi inner join ilac as i on vi.ilacId=i.ilacId where vi.muayeneId=? ";
        
        public int Sil(int ilacId) 
        {
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try 
                {
			conn = getConnection();                    
			stmt = conn.prepareStatement(sil);
			stmt.setInt(1, ilacId);			
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
        
        public List<Ilac> TumListeyiGetir() 
        {
		Connection conn = null;
		PreparedStatement stmt = null;
		List<Ilac> list = new ArrayList<Ilac>();
		
		try 
                {
			conn = getConnection();
			stmt = conn.prepareStatement(tumListeyiGetir);
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) 
                        {
				Ilac ilac = new Ilac();
				ilac.setIlacId(rs.getInt("ilacId"));
				ilac.setIlacAdi(rs.getString("ilacAdi"));
				
                                
				list.add(ilac);
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
        
        public Ilac IdyeGoreGetir(byte Id) 
        {
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try 
                {
			conn = getConnection();
			stmt = conn.prepareStatement(IdyeGore);
			stmt.setByte(1, Id);
			
			ResultSet rs = stmt.executeQuery();
			
			if (rs.next()) 
                        {
				Ilac ilac = new Ilac();
				ilac.setIlacId(rs.getByte("ilacId"));
				ilac.setIlacAdi(rs.getString("ilacAdi"));
								
				return ilac;
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
        
        public int Ekle(Ilac ilac)
        {
            Connection conn = null;
            PreparedStatement stmt = null;
		
		try 
                {
                    conn = getConnection();
                    stmt = conn.prepareStatement(ekle, Statement.RETURN_GENERATED_KEYS);
                    stmt.setString(1, ilac.getIlacAdi());
                                           
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
        
         public int Guncelle(Ilac ilac)
        {
            Connection conn = null;
            PreparedStatement stmt = null;
		
		try 
                {
                    conn = getConnection();
                    stmt = conn.prepareStatement(guncelle);
                    stmt.setInt(2, ilac.getIlacId());
                    stmt.setString(1, ilac.getIlacAdi());
                                          
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
         
         public Ilac IsmeGoreGetir(Ilac aranan) 
        {
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try 
                {
			conn = getConnection();
			stmt = conn.prepareStatement(ismeGore);
			stmt.setString(1, aranan.getIlacAdi());
			
			ResultSet rs = stmt.executeQuery();
			
			if (rs.next()) 
                        {
				Ilac ilac = new Ilac();
				ilac.setIlacId(rs.getByte("ilacId"));
				ilac.setIlacAdi(rs.getString("ilacAdi"));
							
				return ilac;
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
         
         public List<Ilac> MuayeneIdyeGoreGetir(int muayeneId) 
        {
		Connection conn = null;
		PreparedStatement stmt = null;
		List<Ilac> list = new ArrayList<Ilac>();
		
		try 
                {
			conn = getConnection();
			stmt = conn.prepareStatement(muayeneIdyeGore);
                        stmt.setInt(1,muayeneId);
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) 
                        {
				Ilac ilac = new Ilac();
				ilac.setIlacId(rs.getInt("ilacId"));
				ilac.setIlacAdi(rs.getString("ilacAdi"));
				
                                
				list.add(ilac);
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
