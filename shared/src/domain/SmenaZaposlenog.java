/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.time.LocalDate;

/**
 *
 * @author jevrozim
 */
public class SmenaZaposlenog extends OpstiDomenskiObjekat {

    private Zaposleni zaposleni;
    private Smena smena;
    private LocalDate datum;

    public SmenaZaposlenog(Zaposleni zaposleni, Smena smena, LocalDate datum) {
        this.zaposleni = zaposleni;
        this.smena = smena;
        this.datum = datum;
    }

    public SmenaZaposlenog() {
    }

    public Zaposleni getZaposleni() {
        return zaposleni;
    }

    public void setZaposleni(Zaposleni zaposleni) {
        this.zaposleni = zaposleni;
    }

    public Smena getSmena() {
        return smena;
    }

    public void setSmena(Smena smena) {
        this.smena = smena;
    }

    public LocalDate getDatum() {
        return datum;
    }

    public void setDatum(LocalDate datum) {
        this.datum = datum;
    }

    @Override
    public String getTableName() {
        return "SmenaZaposlenog";
    }

    @Override
    public ArrayList<OpstiDomenskiObjekat> vratiListu(ResultSet rs) throws SQLException {
        ArrayList<OpstiDomenskiObjekat> list = new ArrayList<>();
        while (rs.next()) {
            //napravi zaposlenog
            Zaposleni zaposleni = new Zaposleni(rs.getLong("Zaposleni.idZaposlenog"), rs.getString("Zaposleni.ime"), rs.getString("Zaposleni.prezime"), rs.getString("Zaposleni.korisnickoIme"), rs.getString("Zaposleni.sifra"));
            //napravi smenu
            Smena smena = new Smena(rs.getLong("Smena.idSmena"), rs.getTime("Smena.pocetak").toLocalTime(), rs.getTime("Smena.kraj").toLocalTime());//id pocetak, kraj
            //napravi smenu zaposlenog
            SmenaZaposlenog sz = new SmenaZaposlenog(zaposleni, smena, rs.getDate("SmenaZaposlenog.datum").toLocalDate());
            list.add(sz);
        }
        rs.close();
        return list;
    }

    @Override
    public String getInsertValues() {
        return "( "+zaposleni.getIdZaposleni()+", "+smena.getIdSmena()+", "+datum+")";
    }

    @Override
    public String getColumnNames() {
        return "idZaposleni, idSmena, datum";
    }

    @Override
    public String getUpdateValues() {
        return "idZaposleni= "+zaposleni.getIdZaposleni()+" idSmena= "+smena.getIdSmena()+" datum= "+datum;
    }

    @Override
    public String getWhere() {
        return "idZaposleni="+zaposleni.getIdZaposleni()+" AND idSmena="+smena.getIdSmena()+" AND datum="+datum.toString().replace("T", " ")+" ";
    }

    @Override
    public String getSelectCondition() {
        String querey="";
        if(zaposleni!=null){
            querey+=" AND idZaposleni="+zaposleni.getIdZaposleni();
        }
        if(smena!=null){
            querey+=" AND idSmena="+smena.getIdSmena();
        }
        if(datum!=null){
            querey+=" AND datum="+datum+" ";//to string navodno daje dobrestvari
        }
        return querey;
    }

    @Override
    public String getJoinCondition() {
        return "JOIN Zaposleni ON (SmenaZaposlenog.idZaposleni=Zaposleni.idZaposlenog) JOIN Smena ON (SmenaZaposlenog.idSmena=Smena.idSmena) ";//HEEE???
    }
}
