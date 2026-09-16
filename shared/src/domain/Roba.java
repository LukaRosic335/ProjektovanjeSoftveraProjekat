/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author jevrozim
 */
public class Roba extends OpstiDomenskiObjekat{
    private long idRoba;
    private int cena;
    private String naziv;
    private int stanjeUMagacinu;

    public Roba(long idRoba, int cena, String naziv, int stanjeUMagacinu) {
        this.idRoba = idRoba;
        this.cena = cena;
        this.naziv = naziv;
        this.stanjeUMagacinu = stanjeUMagacinu;
    }

    public Roba() {
    }

    
    
    public long getIdRoba() {
        return idRoba;
    }

    public void setIdRoba(long idRoba) {
        this.idRoba = idRoba;
    }

    public int getCena() {
        return cena;
    }

    public void setCena(int cena) {
        this.cena = cena;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public int getStanjeUMagacinu() {
        return stanjeUMagacinu;
    }

    public void setStanjeUMagacinu(int stanjeUMagacinu) {
        this.stanjeUMagacinu = stanjeUMagacinu;
    }

    @Override
    public String getTableName() {
        return "Roba";
    }

    @Override
    public ArrayList<OpstiDomenskiObjekat> vratiListu(ResultSet rs) throws SQLException {
        ArrayList<OpstiDomenskiObjekat> lista=new ArrayList();
        while(rs.next()){
            Roba roba=new Roba(rs.getLong("idRoba"), rs.getInt("cena"), rs.getString("naziv"), rs.getInt("stanjeUMagacinu"));
            lista.add(roba);
        }
        rs.close();
        return lista;
    }

    @Override
    public String getInsertValues() {
        return "(" + cena + ", '" + naziv + "', " + stanjeUMagacinu +")";
    }

    @Override
    public String getColumnNames() {
        return "cena, naziv, stanjeUMagacinu";
    }

    @Override
    public String getUpdateValues() {
        return "cena = "+cena+", naziv = '"+naziv+"', stanjeUMagacinu = "+stanjeUMagacinu; 
    }

    @Override
    public String getWhere() {
        return "idRoba = "+idRoba;
    }

    @Override
    public String getSelectCondition() {
        String query="";
        if(idRoba!=0){
            query+=" AND idRoba="+idRoba;
        }
        if(cena!=0){
            query+=" AND cena="+cena;
        }
        if(naziv!=null){
            query+=" AND naziv='"+naziv+"'";
        }
        if(stanjeUMagacinu!=0){
            query+=" AND stanjeUMagacinu="+stanjeUMagacinu;
        }
        return query;
    }

    @Override
    public String getJoinCondition() {
        return "";
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Roba)){
            return false;
        }
        Roba r=(Roba)obj;
        if(r.getIdRoba()==idRoba){
            return true;
        }
        return false;
    }
    
    
}
