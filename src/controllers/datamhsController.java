/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import javax.swing.JOptionPane;
import models.datamhsModel;
import views.dashboard;
import views.inputNilaiMhs;
import views.dataMhs;

/**
 *
 * @author Hilmi
 */
public class datamhsController {
    private datamhsModel dM;
    private dataMhs dMhs;
    private inputNilaiMhs iMhs;
    
    public datamhsController(dataMhs dMhs){
        this.dMhs = dMhs;
    }
    
    public datamhsController(inputNilaiMhs iMhs){
        this.iMhs = iMhs;
    }
    public void kontrolButton(){
        dMhs.getTombolUpdate().setEnabled(true);
        dMhs.getTombolHapus().setEnabled(false);
        dMhs.getTombolBatal().setEnabled(true);
    }
    
    public void kontrolButtonDua(){
        dMhs.getTombolUpdate().setEnabled(false);
        dMhs.getTombolHapus().setEnabled(true);
        dMhs.getTombolBatal().setEnabled(true);
    }
    
    public void bersihkan1(){
        dMhs.getNamaMhsView().setText("");
        dMhs.getNpmView().setText("");
        dMhs.getNabsenView().setText("");
        dMhs.getNtugasView().setText("");
        dMhs.getNutsView().setText("");
        dMhs.getNuasView().setText("");
        dMhs.getNakhirView().setText("");
    }
    
    public void bersihkan2(){
        iMhs.getNamaMhsView().setText("");
        iMhs.getNpmView().setText("");
        iMhs.getKelasView().setText("");
        iMhs.getNabsenView().setText("");
        iMhs.getNtugasView().setText("");
        iMhs.getNutsView().setText("");
        iMhs.getNuasView().setText("");
        iMhs.getNakhirView().setText("");
    }
    
    public void simpan(){        
        dM = new datamhsModel();
        dM.setNamaModel(iMhs.getNamaMhsView().getText());
        dM.setNpmModel(iMhs.getNpmView().getText());
        dM.setKelasModel(iMhs.getKelasView().getText());
        dM.setnAbsenModel(Double.parseDouble(iMhs.getNabsenView().getText()));
        dM.setnTugasModel(Double.parseDouble(iMhs.getNtugasView().getText()));
        dM.setnUtsModel(Double.parseDouble(iMhs.getNutsView().getText()));
        dM.setnUasModel(Double.parseDouble(iMhs.getNuasView().getText()));
        dM.setnAkhirModel(Double.parseDouble(iMhs.getNakhirView().getText()));
    
        dM.simpanData();
        bersihkan2();
    } 
    
    public void update(){
        dM  = new datamhsModel();
        dM.setNamaModel(dMhs.getNamaMhsView().getText());
        dM.setNpmModel(dMhs.getNpmView().getText());
        dM.setnAbsenModel(Double.parseDouble(dMhs.getNabsenView().getText()));
        dM.setnTugasModel(Double.parseDouble(dMhs.getNtugasView().getText()));
        dM.setnUtsModel(Double.parseDouble(dMhs.getNutsView().getText()));
        dM.setnUasModel(Double.parseDouble(dMhs.getNuasView().getText()));
        dM.setnAkhirModel(Double.parseDouble(dMhs.getNakhirView().getText()));
        
        dM.updateData();
        bersihkan1();
    }
    
    public void hapus(){
        dM = new datamhsModel();
        dM.setNpmModel(dMhs.getNpmView().getText());
        
        dM.hapusData();
        bersihkan1();
    }
}
