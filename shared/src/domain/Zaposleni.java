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
public class Zaposleni extends OpstiDomenskiObjekat {

    private long idZaposleni;
    private String ime;
    private String prezime;
    private String korisnickoIme;
    private String sifra;

    public Zaposleni(long idZaposleni, String ime, String prezime, String korisnickoIme, String sifra) {
        this.idZaposleni = idZaposleni;
        this.ime = ime;
        this.prezime = prezime;
        this.korisnickoIme = korisnickoIme;
        this.sifra = sifra;
    }

    public long getIdZaposleni() {
        return idZaposleni;
    }

    public void setIdZaposleni(long idZaposleni) {
        this.idZaposleni = idZaposleni;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getKorisnickoIme() {
        return korisnickoIme;
    }

    public void setKorisnickoIme(String korisnickoIme) {
        this.korisnickoIme = korisnickoIme;
    }

    public String getSifra() {
        return sifra;
    }

    public void setSifra(String sifra) {
        this.sifra = sifra;
    }

    @Override
    public String getTableName() {
        return "Zaposleni";
    }

    @Override
    public ArrayList<OpstiDomenskiObjekat> vratiListu(ResultSet rs) throws SQLException {
        ArrayList<OpstiDomenskiObjekat> list = new ArrayList();
        while (rs.next()) {
            Zaposleni zaposleni = new Zaposleni(rs.getLong("idZaposlenog"), rs.getString("ime"), rs.getString("prezime"), rs.getString("korisnickoIme"), rs.getString("sifra"));
            list.add(zaposleni);
        }
        rs.close();
        return list;
    }

}

//ArrayList<OpstiDomenskiObjekat> lista = new ArrayList<>();
//
//        while (rs.next()) {
//            Predavac p = new Predavac(rs.getLong("predavacID"),
//                    rs.getString("Ime"), rs.getString("Prezime"),
//                    rs.getString("korisnickoIme"), rs.getString("lozinka"));
//
//            lista.add(p);
//        }
//
//        rs.close();
//        return lista;

