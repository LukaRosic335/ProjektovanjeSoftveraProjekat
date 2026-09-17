/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controler;

import domain.*;
import java.util.ArrayList;
import so.Login.Login;
import so.Racun.KreirajRacun;
import so.Racun.ObrisiRacun;
import so.Racun.PromeniRacun;
import so.Racun.VratiListuRacun;
import so.Racun.VratiListuSviRacun;
import so.Roba.KreirajRoba;
import so.Roba.ObrisiRoba;
import so.Roba.PromeniRoba;
import so.Roba.VratiListuRoba;
import so.Roba.VratiListuSviRoba;
import so.Smena.KreirajSmena;
import so.Smena.ObrisiSmena;
import so.Smena.PromeniSmena;
import so.Smena.VratiListuSmena;
import so.Smena.VratiListuSviSmena;
import so.Sto.KreirajSto;
import so.Sto.ObrisiSto;
import so.Sto.PromeniSto;
import so.Sto.VratiListuSviSto;
import so.Sto.vratiListuSto;
import so.Zaposleni.ObrisiZaposleni;
import so.Zaposleni.VratiListuSviZaposleni;
import so.Zaposleni.KreirajZaposleni;
import so.Zaposleni.PromeniZaposleni;
import so.tipStola.KreirajTipStola;
import so.tipStola.ObrisiTipStola;
import so.tipStola.PromeniTIpStola;
import so.tipStola.VratiListuSviTipStola;

/**
 *
 * @author jevrozim
 */
public class ServerControler {

    private static ServerControler instance;
    private ArrayList<Zaposleni> ulogovani;

    public ArrayList<Zaposleni> getUlogovani() {
        return ulogovani;
    }

    private ServerControler() {
        ulogovani = new ArrayList();
    }

    public static ServerControler getInstance() {
        if (instance == null) {
            instance = new ServerControler();
        }
        return instance;
    }

    public Zaposleni login(Zaposleni zaposleni) throws Exception {//OGROMAN CHECK ZA BUDUCNOST STO SE TICEC LISTE ULOGOVANIH U SERVERCONTROLER
        Login login = new Login();
        Zaposleni z = login.executeTamplate(zaposleni);
        ulogovani.add(zaposleni);
        return z;
    }

    public void logout(Zaposleni zaposleni) {
        ulogovani.remove(zaposleni);
        if (ulogovani.isEmpty()) {        //OGROMAN CHECK ZA OVO NEGDE U BUDUCNOSTI
            System.out.println("Nema vise nikog od klijenata");
        }
    }

    public Zaposleni newZaposleni(Zaposleni zaposleni) throws Exception {
        KreirajZaposleni so = new KreirajZaposleni();
        Zaposleni novi = so.executeTamplate(zaposleni);
        return novi;
    }

    public ArrayList<Zaposleni> getAllZaposleni() throws Exception {//razmatranje ovog kao opcije
        VratiListuSviZaposleni so = new VratiListuSviZaposleni();
        return so.executeTamplate(new Zaposleni());
    }

    public Zaposleni deleteZaposleni(Zaposleni zaposleni) throws Exception {//takodje eksperiment sa throws
        ObrisiZaposleni so = new ObrisiZaposleni();
        return so.executeTamplate(zaposleni);
    }

    public Zaposleni updateZaposleni(Zaposleni zaposleni) throws Exception {//mozda treba da vrati zaposlenog kojeg je promenio???
        PromeniZaposleni so = new PromeniZaposleni();
        return so.executeTamplate(zaposleni);
    }

    public TipStola newTipStola(TipStola tipStola) throws Exception {
        KreirajTipStola so = new KreirajTipStola();
        return so.executeTamplate(tipStola);
    }

    public TipStola deleteTipStola(TipStola tipStola) throws Exception {
        ObrisiTipStola so = new ObrisiTipStola();
        return so.executeTamplate(tipStola);
    }

    public TipStola updateTipStola(TipStola tipStola) throws Exception {
        PromeniTIpStola so = new PromeniTIpStola();
        return so.executeTamplate(tipStola);
    }

    public ArrayList<TipStola> getAllTipStola() throws Exception {
        VratiListuSviTipStola so = new VratiListuSviTipStola();
        return so.executeTamplate(new TipStola());
    }

    //LEPO NAPRAVI OVO
    public ArrayList<Racun> vratiListaRacun(Racun racun) throws Exception {
        VratiListuRacun so = new VratiListuRacun();
        return so.executeTamplate(racun);
    }

    public ArrayList<Racun> getAllRacun() throws Exception {
        VratiListuSviRacun so = new VratiListuSviRacun();
        ArrayList<Racun> svi = so.executeTamplate(new Racun());
        return svi;
    }

    public Racun updateRacun(Racun r) throws Exception {
        PromeniRacun so = new PromeniRacun();
        return so.executeTamplate(r);
    }

    public Racun newRacun(Racun r) throws Exception {
        KreirajRacun so = new KreirajRacun();
        return so.executeTamplate(r);
    }

    public ArrayList<Roba> getAllRoba() throws Exception {
        VratiListuSviRoba so = new VratiListuSviRoba();
        return so.executeTamplate(new Roba());
    }

    public Roba updateRoba(Roba r) throws Exception {
        PromeniRoba spo = new PromeniRoba();
        return spo.executeTamplate(r);
    }

    public Roba deleteRoba(Roba r) throws Exception {
        ObrisiRoba so = new ObrisiRoba();
        return so.executeTamplate(r);
    }

    public Roba newRoba(Roba r) throws Exception {
        KreirajRoba s = new KreirajRoba();
        return s.executeTamplate(r);
    }

    public ArrayList<Smena> getAllSmena() throws Exception {
        VratiListuSviSmena so = new VratiListuSviSmena();
        return so.executeTamplate(new Smena());
    }

    public Smena updateSmena(Smena s) throws Exception {
        PromeniSmena so = new PromeniSmena();
        return so.executeTamplate(s);
    }

    public Smena deleteSmena(Smena s) throws Exception {
        ObrisiSmena so = new ObrisiSmena();
        return so.executeTamplate(s);
    }

    public Smena newSmena(Smena s) throws Exception {
        KreirajSmena so = new KreirajSmena();
        return so.executeTamplate(s);
    }

    public ArrayList<Sto> getAllSto() throws Exception {
        VratiListuSviSto so = new VratiListuSviSto();
        return so.executeTamplate(new Sto());
    }

    public Sto updateSto(Sto s) throws Exception {
        PromeniSto so = new PromeniSto();
        return so.executeTamplate(s);
    }

    public Sto deleteSto(Sto s) throws Exception {
        ObrisiSto so = new ObrisiSto();
        return so.executeTamplate(s);
    }

    public Sto newSto(Sto s) throws Exception {
        KreirajSto so = new KreirajSto();
        return so.executeTamplate(s);
    }

    public ArrayList<Racun> getRacun(Racun r) throws Exception {
        VratiListuRacun so = new VratiListuRacun();
        return so.executeTamplate(r);
    }

    public Racun deleteRacun(Racun racun) throws Exception {
        ObrisiRacun l = new ObrisiRacun();
        return l.executeTamplate(racun);
    }

    public ArrayList<Roba> getRobaList(Roba roba) throws Exception {
        VratiListuRoba so = new VratiListuRoba();
        return so.executeTamplate(roba);
    }

    public ArrayList<Racun> getRacunList(Racun racun) throws Exception {
        VratiListuRacun so = new VratiListuRacun();
        return so.executeTamplate(racun);
    }

    public ArrayList<Sto> getStoList(Sto sto) throws Exception {
        vratiListuSto so = new vratiListuSto();
        return so.executeTamplate(sto);
    }

    public ArrayList<Smena> getSmenaList(Smena smena) throws Exception {
        VratiListuSmena so = new VratiListuSmena();
        return so.executeTamplate(smena);
    }

}
