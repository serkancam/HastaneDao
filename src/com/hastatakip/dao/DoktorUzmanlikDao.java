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
public class DoktorUzmanlikDao extends DAO
{
   private final String sil = "DELETE FROM doktorUzmanlik WHERE doktorUzmanlikId=?";
   private final String tumListeyiGetir= "SELECT * FROM doktorUzmanlik ORDER BY doktorUzmanlikId";
   private final String IdyeGore = "SELECT * FROM doktorUzmanlik WHERE doktorUzmanlikId=?";
   private final String ismeGore = "SELECT * FROM doktorUzmanlik WHERE doktorUzmanlikAdi=?";
   private final String ekle = "INSERT INTO doktorUzmanlik(doktorUzmanlikAdi) VALUES(?)";
   private final String guncelle = "UPDATE doktorUzmanlik SET doktorUzmanlikAdi=? WHERE doktorUzmanlikId=?";
        
        public int Sil(byte doktorUzmanlikId) 
        {
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try 
                {
			conn = getConnection();                    
			stmt = conn.prepareStatement(sil);
			stmt.setByte(1, doktorUzmanlikId);			
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
        
        public List<DoktorUzmanlik> TumListeyiGetir() 
        {
		Connection conn = null;
		PreparedStatement stmt = null;
		List<DoktorUzmanlik> list = new ArrayList<DoktorUzmanlik>();
		
		try 
                {
			conn = getConnection();
			stmt = conn.prepareStatement(tumListeyiGetir);
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) 
                        {
				DoktorUzmanlik doktorUzmanlik = new DoktorUzmanlik();
				doktorUzmanlik.setDoktorUzmanlik(rs.getByte("doktorUzmanlikId"));
				doktorUzmanlik.setDoktorUzmanlikAdi(rs.getString("doktorUzmanlikAdi"));
				
                                
				list.add(doktorUzmanlik);
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
        
        public DoktorUzmanlik IdyeGoreGetir(byte Id) 
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
				DoktorUzmanlik doktorUzmanlik = new DoktorUzmanlik();
				doktorUzmanlik.setDoktorUzmanlik(rs.getByte("doktorUzmanlikId"));
				doktorUzmanlik.setDoktorUzmanlikAdi(rs.getString("doktorUzmanlikAdi"));
								
				return doktorUzmanlik;
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
        
        public int Ekle(DoktorUzmanlik doktorUzmanlik)
        {
            Connection conn = null;
            PreparedStatement stmt = null;
		
		try 
                {
                    conn = getConnection();
                    stmt = conn.prepareStatement(ekle, Statement.RETURN_GENERATED_KEYS);
                    stmt.setString(1, doktorUzmanlik.getDoktorUzmanlikAdi());
                                           
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
        
         public int Guncelle(DoktorUzmanlik doktorUzmanlik)
        {
            Connection conn = null;
            PreparedStatement stmt = null;
		
		try 
                {
                    conn = getConnection();
                    stmt = conn.prepareStatement(guncelle);
                    stmt.setByte(1, doktorUzmanlik.getDoktorUzmanlik());
                    stmt.setString(2, doktorUzmanlik.getDoktorUzmanlikAdi());
                                          
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
         
         public DoktorUzmanlik IsmeGoreGetir(DoktorUzmanlik aranan) 
        {
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try 
                {
			conn = getConnection();
			stmt = conn.prepareStatement(ismeGore);
			stmt.setString(1, aranan.getDoktorUzmanlikAdi());
			
			ResultSet rs = stmt.executeQuery();
			
			if (rs.next()) 
                        {
				DoktorUzmanlik doktorUzmanlik = new DoktorUzmanlik();
				doktorUzmanlik.setDoktorUzmanlik(rs.getByte("doktorUzmanlikId"));
				doktorUzmanlik.setDoktorUzmanlikAdi(rs.getString("doktorUzmanlikAdi"));
							
				return doktorUzmanlik;
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
