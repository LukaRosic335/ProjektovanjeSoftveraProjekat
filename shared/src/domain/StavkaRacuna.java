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
public class StavkaRacuna extends OpstiDomenskiObjekat{
    private Racun racun;
    private int rb;
    private int cena;
    private int kolicina;
    private Roba roba;

    public StavkaRacuna() {
    }

    public StavkaRacuna(Racun racun, int rb, int cena, int kolicina, Roba roba) {
        this.racun = racun;
        this.rb = rb;
        this.cena = cena;
        this.kolicina = kolicina;
        this.roba = roba;
    }
    
    public StavkaRacuna(Racun racun){
        this.racun=racun;
    }
    

    public Racun getRacun() {
        return racun;
    }

    public void setRacun(Racun racun) {
        this.racun = racun;
    }

    public int getRb() {
        return rb;
    }

    public void setRb(int rb) {
        this.rb = rb;
    }

    public int getCena() {
        return cena;
    }

    public void setCena(int cena) {
        this.cena = cena;
    }

    public int getKolicina() {
        return kolicina;
    }

    public void setKolicina(int kolicina) {
        this.kolicina = kolicina;
    }

    public Roba getRoba() {
        return roba;
    }

    public void setRoba(Roba roba) {
        this.roba = roba;
    }

    @Override
    public String getTableName() {
        return "StavkaRacuna";
    }

    @Override
    public ArrayList<OpstiDomenskiObjekat> vratiListu(ResultSet rs) throws SQLException {
        ArrayList<OpstiDomenskiObjekat> list=new ArrayList<>();
        while(rs.next()){
            //kreiram robu
            Roba r=new Roba(rs.getLong("Roba.idRoba"), rs.getInt("Roba.cena"), rs.getString("Roba.naziv"), rs.getInt("Roba.stanjeUMagacinu"));
            //kreiram racun SAMO SA ID
            Racun idRacun=new Racun(rs.getLong("Racun.idRacun"));
            //kreiram stavkuRacuna
            StavkaRacuna stavka=new StavkaRacuna(idRacun, rs.getInt("StavkaRacuna.rb"), rs.getInt("StavkaRacuna.cena"), rs.getInt("StavkaRacuna.kolicina"), r);
            list.add(stavka);
        }
        rs.close();
        return list;
    }

    @Override
    public String getInsertValues() {
        return "("+rb+", "+cena+", "+kolicina+", "+racun.getIdRacun()+", "+roba.getIdRoba()+")";
    }

    @Override
    public String getColumnNames() {
        return "rb, cena, kolicina, idRacun, idRoba";
    }

    @Override
    public String getUpdateValues() {
        return "rb="+rb+", cena="+cena+", kolicina="+kolicina+", idRacun="+racun.getIdRacun()+", idRoba="+roba.getIdRoba();
    }

    @Override
    public String getWhere() {
        return "StavkaRacuna.idRacun="+racun.getIdRacun()+" AND rb="+rb;
    }

    @Override
    public String getSelectCondition() {
        String query="";
        if(rb!=0){
            query+=" AND rb="+rb;
        }
        if(cena!=0){
            query+=" AND cena="+cena;
        }
        if(kolicina!=0){
            query+=" AND kolicina="+kolicina;
        }
        if(racun!=null){
            query+=" AND StavkaRacuna.idRacun="+racun.getIdRacun();
        }
        if(roba!=null){
            query+=" AND StavkaRacuna.idRoba="+roba.getIdRoba();
        }
        return query;
    }

    @Override
    public String getJoinCondition() {
        return " JOIN Racun ON StavkaRacuna.idRacun=Racun.idRacun JOIN Roba ON StavkaRacuna.idRoba=Roba.idRoba ";
    }

    @Override
    public String toString() {
        return "Racun: "+racun.getIdRacun()+" redni broj stavke:"+rb;
    }
        public boolean equals(Object obj) {
        if(!(obj instanceof StavkaRacuna)){
            return false;
        }
        StavkaRacuna x=(StavkaRacuna)obj;
        if(rb==x.getRb()&&racun.getIdRacun()==x.getRacun().getIdRacun()){
            return true;
        }
        return false;
    }
    
 
}
