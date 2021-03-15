/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import com.mysql.jdbc.Connection;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

/**
 *
 * @author Hilmi
 */

public class dbConnect {
    private static Connection conn;
    private static Properties propert = new Properties();
    
    public static Connection getKoneksi() throws SQLException{
        if(conn == null){
            try{
                propert.load(new FileInputStream("C:\\Users\\Agung\\Documents\\NetBeansProjects\\UAS\\src\\db\\dbConfig.properties"));
            } catch (IOException ex){
                System.err.println("error mengambil file"+ex);
            }
            conn = (Connection) DriverManager.getConnection(propert.getProperty("jdbc.url"),
                    propert.getProperty("jdbc.username"),propert.getProperty("jdbc.password"));
        }
        return conn;
    }
    public static void main(String[] args) throws SQLException {
        if(getKoneksi().equals(conn)){
            System.out.println("sukses");
        }
    }
}
