/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controler;

import domain.Zaposleni;
import java.util.ArrayList;

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
}
