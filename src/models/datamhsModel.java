/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import db.dbConnect;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
/**
 *
 * @author Hilmi
 */
public class datamhsModel {
    private String namaModel, npmModel, kelasModel;
    private double nAbsenModel, nTugasModel, nUtsModel, nUasModel, nAkhirModel;
        
    dbConnect koneksi = new dbConnect();
    
    public datamhsModel() {
        
    }

    public String getNamaModel() {
        return namaModel;
    }

    public void setNamaModel(String namaModel) {
        this.namaModel = namaModel;
    }

    public String getNpmModel() {
        return npmModel;
    }

    public void setNpmModel(String npmModel) {
        this.npmModel = npmModel;
    }

    public String getKelasModel() {
        return kelasModel;
    }

    public void setKelasModel(String kelasModel) {
        this.kelasModel = kelasModel;
    }

    public double getnAbsenModel() {
        return nAbsenModel;
    }

    public void setnAbsenModel(double nAbsenModel) {
        this.nAbsenModel = nAbsenModel;
    }

    public double getnTugasModel() {
        return nTugasModel;
    }

    public void setnTugasModel(double nTugasModel) {
        this.nTugasModel = nTugasModel;
    }

    public double getnUtsModel() {
        return nUtsModel;
    }

    public void setnUtsModel(double nUtsModel) {
        this.nUtsModel = nUtsModel;
    }

    public double getnUasModel() {
        return nUasModel;
    }

    public void setnUasModel(double nUasModel) {
        this.nUasModel = nUasModel;
    }

    public double getnAkhirModel() {
        return nAkhirModel;
    }

    public void setnAkhirModel(double nAkhirModel) {
        this.nAkhirModel = nAkhirModel;
    }
    
    

    public dbConnect getKoneksi() {
        return koneksi;
    }

    public void setKoneksi(dbConnect koneksi) {
        this.koneksi = koneksi;
    }
        
    public void simpanData(){
        String sql = ("INSERT INTO mahasiswa (nama, npm, kelas, nilai_absen,"
                + "nilai_tugas, nilai_uts, nilai_uas, nilai_akhir)"
                + "VALUES ('"+getNamaModel()+"','"+getNpmModel()+"','"+getKelasModel()+"','"
                + getnAbsenModel()+"','" + getnTugasModel()+"','"+getnUtsModel()+"','"+getnUasModel()+
                "','"+getnAkhirModel()+"')");
    
        try {
            PreparedStatement eksekusi = koneksi.getKoneksi().prepareStatement(sql);
            eksekusi.execute();
            
            JOptionPane.showMessageDialog(null, "Data berhasil disimpan");
        } catch (SQLException ex) {
            Logger.getLogger(datamhsModel.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Data gagal tersimpan \n"+ex);
        }
    }
    
    public void updateData(){
        String sql = ("UPDATE mahasiswa SET nama = '"+getNamaModel()+"'"
                +", nilai_absen = '"+getnAbsenModel()+"'"
                +", nilai_tugas = '"+getnTugasModel()+"'" 
                +", nilai_uts = '"+getnUtsModel()+"'"
                +", nilai_uas = '"+getnUasModel()+"'"
                +", nilai_akhir = '"+getnAkhirModel()+"'WHERE npm = '"+getNpmModel()+"'");
        
        try {
            PreparedStatement eksekusi = koneksi.getKoneksi().prepareStatement(sql);
            eksekusi.execute();
            
            JOptionPane.showMessageDialog(null, "Data berhasil diubah");
        } catch (SQLException ex) {
            Logger.getLogger(datamhsModel.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Data gagal diubah \n"+ex);
        }
    }
    
    public void hapusData(){
        String sql = ("DELETE FROM mahasiswa WHERE npm = "
                + "'"+getNpmModel()+"'");
         try {
            PreparedStatement eksekusi = koneksi.getKoneksi().prepareStatement(sql);
            eksekusi.execute();
            
            JOptionPane.showMessageDialog(null, "Data berhasil dihapus");
        } catch (SQLException ex) {
            Logger.getLogger(datamhsModel.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Data gagal dihapus \n"+ex);
        }
    }
}
