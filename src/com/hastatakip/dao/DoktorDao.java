/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hastatakip.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.hastatakip.entity.*;

/**
 *
 * @author serkancam
 */
public class DoktorDao extends DAO
{
      private final String sil = "DELETE FROM doktor WHERE doktorTC=?";
      private final String tumListeyiGetir= "SELECT * FROM doktor ORDER BY doktorTC";
      private final String TCyeGore = "SELECT * FROM doktor WHERE doktorTC=?";
      private final String ismeGore = "SELECT * FROM doktor WHERE doktorAdi=? or doktorSoyadi=?";
      private final String ekle = "INSERT INTO doktor(doktorTC, doktorAdi, doktorSoyadi,doktorDogumTarihi,doktorUzmanlik) VALUES(?,?,?,?,?)";
      private final String guncelle = "UPDATE doktor SET doktorAdi=?, doktorSoyadi=?, doktorDogumTarihi=?, doktorUzmanlik=? WHERE doktorTC=?";
        
        public int Sil(String doktorTC) 
        {
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try 
                {
			conn = getConnection();
			stmt = conn.prepareStatement(sil);
			stmt.setString(1, doktorTC);			
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
        
        public List<Doktor> TumListeyiGetir() 
        {
		Connection conn = null;
		PreparedStatement stmt = null;
		List<Doktor> list = new ArrayList<Doktor>();
		
		try 
                {
			conn = getConnection();
			stmt = conn.prepareStatement(tumListeyiGetir);
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) 
                        {
				Doktor doktor = new Doktor();
				doktor.setDoktorTC(rs.getString("doktorTC"));
				doktor.setDoktorAdi(rs.getString("doktorAdi"));
				doktor.setDoktorSoyadi(rs.getString("doktorSoyadi"));
				doktor.setDoktorDogumTarihi(rs.getDate("doktorDogumTarihi"));
                                doktor.setDoktorUzmanlik(rs.getByte("doktorUzmanlik"));
                                
				list.add(doktor);
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
        
        public Doktor TCyeGoreGetir(String tc) 
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
				Doktor doktor = new Doktor();
				doktor.setDoktorTC(rs.getString("doktorTC"));
				doktor.setDoktorAdi(rs.getString("doktorAdi"));
				doktor.setDoktorSoyadi(rs.getString("doktorSoyadi"));
				doktor.setDoktorDogumTarihi(rs.getDate("doktorDogumTarihi"));
                                doktor.setDoktorUzmanlik(rs.getByte("doktorUzmanlik"));
				
				return doktor;
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
        
        public int Ekle(Doktor doktor)
        {
            Connection conn = null;
            PreparedStatement stmt = null;
		
		try 
                {
                    conn = getConnection();
                    stmt = conn.prepareStatement(ekle);
                    stmt.setString(1, doktor.getDoktorTC());
                    stmt.setString(2, doktor.getDoktorAdi());
                    stmt.setString(3, doktor.getDoktorSoyadi());
                    stmt.setObject(4, doktor.getDoktorDogumTarihi());
                    stmt.setByte(5, doktor.getDoktorUzmanlik());
                        
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
        
         public int Guncelle(Doktor doktor)
        {
            Connection conn = null;
            PreparedStatement stmt = null;
		
		try 
                {
                    conn = getConnection();
                    stmt = conn.prepareStatement(guncelle);
                    stmt.setString(5, doktor.getDoktorTC());
                    stmt.setString(1, doktor.getDoktorAdi());
                    stmt.setString(2, doktor.getDoktorSoyadi());
                    stmt.setObject(3, doktor.getDoktorDogumTarihi());
                    stmt.setByte(4, doktor.getDoktorUzmanlik());
                    
                        
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
         
         public Doktor IsmeGoreGetir(Doktor aranan) 
        {
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try 
                {
			conn = getConnection();
			stmt = conn.prepareStatement(ismeGore);
			stmt.setString(1, aranan.getDoktorAdi());
                        stmt.setString(2, aranan.getDoktorSoyadi());
			
			ResultSet rs = stmt.executeQuery();
			
			if (rs.next()) 
                        {
				Doktor doktor = new Doktor();
				doktor.setDoktorTC(rs.getString("doktorTC"));
				doktor.setDoktorAdi(rs.getString("doktorAdi"));
				doktor.setDoktorSoyadi(rs.getString("doktorSoyadi"));
				doktor.setDoktorDogumTarihi(rs.getDate("doktorDogumTarihi"));
                                doktor.setDoktorUzmanlik(rs.getByte("doktorUzmanlik"));
				
				return doktor;
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
