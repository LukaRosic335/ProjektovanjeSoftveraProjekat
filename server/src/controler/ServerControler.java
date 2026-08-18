/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controler;

import domain.OpstiDomenskiObjekat;
import domain.Zaposleni;
import java.util.ArrayList;
import so.Login.Login;

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
        ulogovani=new ArrayList();
    }
    
    public static ServerControler getInstance(){
        if(instance==null){
            instance=new ServerControler();
        }
        return instance;
    }
    
    public Zaposleni login(Zaposleni zaposleni){
        Login login=new Login();
        try {//PRIVREMENO RESENJE ZA EXCEPTION HANDELING
            login.executeTamplate(zaposleni);
            return login.getUlogovan();
        } catch (Exception ex) {
            System.out.println("Zaposleni koji je vracen je null, loginso vratio exc "+ex.getMessage());
            return null;
        }
        
        
    }
}
