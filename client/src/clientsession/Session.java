/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clientsession;

import domain.Zaposleni;
import java.io.IOException;
import java.net.Socket;


/**
 *
 * @author jevrozim
 */
public class Session {
    private Socket socket;
    private static Session instance;
    private Zaposleni ulogovani;

    private Session() {
        try {
            socket = new Socket("localhost", 7259);
        } catch (IOException ex) {
            System.out.println("Problem pri stvaranju soketa "+ex.getMessage());
        }
    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    public static Session getInstance() {
        return instance;
    }

    public static void setInstance(Session instance) {
        Session.instance = instance;
    }

    public Zaposleni getUlogovani() {
        return ulogovani;
    }

    public void setUlogovani(Zaposleni ulogovani) {
        this.ulogovani = ulogovani;
    }
    
    public static Session getInstace(){
        if(instance==null){
            instance=new Session();
        }
        return instance;
    }
    
}
