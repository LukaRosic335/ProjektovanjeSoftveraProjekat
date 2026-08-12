/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.time.LocalTime;

/**
 *
 * @author jevrozim
 */
public class Racun {
    private long idRacun;
    private double pocetniIznos;
    private LocalTime sat;
    private double popust;
    private double krajnjiIznos;
    private Zaposleni zaposleni;
    private Sto sto;

    //getteri i steri
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
    
}
