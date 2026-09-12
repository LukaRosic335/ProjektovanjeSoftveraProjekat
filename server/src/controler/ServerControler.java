/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controler;

import domain.Zaposleni;
import java.util.ArrayList;
import so.Login.Login;
import so.Zaposleni.ObrisiZaposleni;
import so.Zaposleni.VratiListuSviZaposleni;
import so.Zaposleni.KreirajZaposleni;
import so.Zaposleni.PromeniZaposleni;

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
        Zaposleni z=login.executeTamplate(zaposleni);
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
        Zaposleni novi=so.executeTamplate(zaposleni);
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
    
    public Zaposleni updateZaposleni(Zaposleni zaposleni) throws Exception{//mozda treba da vrati zaposlenog kojeg je promenio???
        PromeniZaposleni so=new PromeniZaposleni();
        return so.executeTamplate(zaposleni);
    }
}
