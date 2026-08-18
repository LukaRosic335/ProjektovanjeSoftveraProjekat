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
    public static ServerControler instance;
    private ArrayList<Zaposleni> ulogovani;

    private ServerControler() {
    }
    
    public static ServerControler getInstance(){
        if(instance==null){
            instance=new ServerControler();
        }
        return instance;
    }
    
    public void login(Zaposleni zaposleni){
        Login login=new Login();
        try {//PRIVREMENO RESENJE ZA EXCEPTION HANDELING
            login.executeTamplate(zaposleni);
        } catch (Exception ex) {
            System.out.println("PRIVREMENO RESENJE ZA EXC HANDELING "+ex.getMessage());
        }
        
        
    }
}
