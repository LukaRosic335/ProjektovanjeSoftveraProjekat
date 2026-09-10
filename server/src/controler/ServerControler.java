/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controler;

import domain.Zaposleni;
import java.util.ArrayList;
import so.Login.Login;
import so.Zaposleni.DeleteZaposleni;
import so.Zaposleni.GetAllZaposleni;
import so.Zaposleni.NewZaposleni;
import so.Zaposleni.UpdateZaposleni;

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
        NewZaposleni so = new NewZaposleni();
        Zaposleni novi=so.executeTamplate(zaposleni);
        return novi;
    }

    public ArrayList<Zaposleni> getAllZaposleni() throws Exception {//razmatranje ovog kao opcije
        GetAllZaposleni so = new GetAllZaposleni();
        return so.executeTamplate(new Zaposleni());
    }

    public Zaposleni deleteZaposleni(Zaposleni zaposleni) throws Exception {//takodje eksperiment sa throws
        DeleteZaposleni so = new DeleteZaposleni();
        return so.executeTamplate(zaposleni);
    }
    
    public Zaposleni updateZaposleni(Zaposleni zaposleni) throws Exception{//mozda treba da vrati zaposlenog kojeg je promenio???
        UpdateZaposleni so=new UpdateZaposleni();
        return so.executeTamplate(zaposleni);
    }
}
