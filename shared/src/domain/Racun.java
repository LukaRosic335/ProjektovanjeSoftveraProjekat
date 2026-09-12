/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalTime;
import java.util.ArrayList;

/**
 *
 * @author jevrozim
 */
public class Racun extends OpstiDomenskiObjekat{
    private long idRacun;
    private double pocetniIznos;
    private LocalTime sat;
    private double popust;
    private double krajnjiIznos;
    private Zaposleni zaposleni;
    private Sto sto;
    private ArrayList<StavkaRacuna> stavkeRacuna;

    public Racun() {
    }

    public Racun(long idRacun, double pocetniIznos, LocalTime sat, double popust, double krajnjiIznos, Zaposleni zaposleni, Sto sto, ArrayList<StavkaRacuna> stavkeRacuna) {
        this.idRacun = idRacun;
        this.pocetniIznos = pocetniIznos;
        this.sat = sat;
        this.popust = popust;
        this.krajnjiIznos = krajnjiIznos;
        this.zaposleni = zaposleni;
        this.sto = sto;
        this.stavkeRacuna = stavkeRacuna;
    }
    public Racun(long idRacun){
        this.idRacun=idRacun;
    }

    public long getIdRacun() {
        return idRacun;
    }

    public void setIdRacun(long idRacun) {
        this.idRacun = idRacun;
    }

    public double getPocetniIznos() {
        return pocetniIznos;
    }

    public void setPocetniIznos(double pocetniIznos) {
        this.pocetniIznos = pocetniIznos;
    }

    public LocalTime getSat() {
        return sat;
    }

    public void setSat(LocalTime sat) {
        this.sat = sat;
    }

    public double getPopust() {
        return popust;
    }

    public void setPopust(double popust) {
        this.popust = popust;
    }

    public double getKrajnjiIznos() {
        return krajnjiIznos;
    }

    public void setKrajnjiIznos(double krajnjiIznos) {
        this.krajnjiIznos = krajnjiIznos;
    }

    public Zaposleni getZaposleni() {
        return zaposleni;
    }

    public void setZaposleni(Zaposleni zaposleni) {
        this.zaposleni = zaposleni;
    }

    public Sto getSto() {
        return sto;
    }

    public void setSto(Sto sto) {
        this.sto = sto;
    }

    public ArrayList<StavkaRacuna> getStavkeRacuna() {
        return stavkeRacuna;
    }

    public void setStavkeRacuna(ArrayList<StavkaRacuna> stavkeRacuna) {
        this.stavkeRacuna = stavkeRacuna;
    }
    

    @Override
    public String getTableName() {
        return "Racun";
    }

    @Override
    public ArrayList<OpstiDomenskiObjekat> vratiListu(ResultSet rs) throws SQLException {
        ArrayList<OpstiDomenskiObjekat> list=new ArrayList<>();
        while(rs.next()){
            //kreiraj zaposlenog
            Zaposleni z=new Zaposleni(rs.getLong("Zaposleni.idZaposlenog"), rs.getString("Zaposleni.ime"), rs.getString("Zaposleni.prezime"), rs.getString("Zaposleni.korisnickoIme"), rs.getString("Zaposleni.sifra"));
            //evidentno kreiram i tip stola jeeej
            TipStola ts=new TipStola(rs.getLong("TipStola.idTipStola"), rs.getInt("TipStola.brMesta"));
            //kreiraj sto
            Sto s=new Sto(rs.getLong("Sto.idSto"), rs.getInt("Sto.brMusterija"), ts);
            //kreiraj racun
            Racun racun=new Racun(rs.getLong("Racun.idRacun"), rs.getDouble("Racun.pocetniIznos"), rs.getTime("Racun.sat").toLocalTime(), rs.getDouble("Racun.popust"), rs.getDouble("Racun.krajnjiIznos"), z, s, new ArrayList<>());
            //privremeno resenje za kreiranje stavki racuna je new ArrayList()
            list.add(racun);
        }
        rs.close();
        return list;
    }

    @Override
    public String getInsertValues() {
        return "("+pocetniIznos+", "+sat+", "+popust+", "+krajnjiIznos+", "+zaposleni.getIdZaposleni()+", "+sto.getIdSto()+")";
    }

    @Override
    public String getColumnNames() {
        return " pocetniIznos, sat, popust, krajnjiIznos, idZaposleni, idSto";
    }

    @Override
    public String getUpdateValues() {
        return" pocetniIznos="+pocetniIznos+", sat="+sat+", popust="+popust+", krajnjiIznos="+krajnjiIznos+", idZaposleni="+zaposleni.getIdZaposleni()+", idSto="+sto.getIdSto();
    }

    @Override
    public String getWhere() {
        return " idRacun="+idRacun;
    }

    @Override
    public String getSelectCondition() {
        String query="";
        if(idRacun!=0){
            query+=" AND idRacun="+idRacun;
        }
        if(pocetniIznos!=0){
            query+=" AND pocetniIznos="+pocetniIznos;
        }
        if(sat!=null){
            query+=" AND sat="+sat;
        }
        if(popust!=0){
            query+=" AND popust="+popust;
        }
        if(krajnjiIznos!=0){
            query+=" AND krajnjiIznos="+krajnjiIznos;
        }
        if(zaposleni!=null){
            query+=" AND idZaposleni="+zaposleni.getIdZaposleni();
        }
        if(sto!=null){
            query+=" AND idSto="+sto.getIdSto();
        }
        return query;
    }

    @Override
    public String getJoinCondition() {
        return " JOIN Zaposleni ON Racun.idZaposleni=Zaposleni.idZaposlenog JOIN Sto ON Sto.idSto=Racun.idSto JOIN TipStola ON Sto.idTipStola=TipStola.idTipStola ";
    }
    
}
