/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clientsession;

import domain.Zaposleni;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 *
 * @author jevrozim
 */
public class Session extends Thread{

    private Socket socket;
    private static Session instance;
    private Zaposleni ulogovani;
    private ObjectOutputStream out;
    private ObjectInputStream in;

    private Session() {
        try {
            socket = new Socket("localhost", 7259);
            System.out.println("pre out");
            out = new ObjectOutputStream(socket.getOutputStream());
            System.out.println("Posle out pre in,");
            in = new ObjectInputStream(socket.getInputStream());
            System.out.println("Posle in");

        } catch (IOException ex) {
            System.out.println("Problem pri stvaranju soketa " + ex.getMessage());
        } catch (Exception e) {
            System.out.println("Nesto se savade");
        }
    }

    public Socket getSocket() {
        return socket;
    }


    public ObjectOutputStream getOut() {
        return out;
    }

    public ObjectInputStream getIn() {
        return in;
    }

    public Zaposleni getUlogovani() {
        return ulogovani;
    }

    public void setUlogovani(Zaposleni ulogovani) {
        this.ulogovani = ulogovani;
    }

    public static Session getInstace() {
        if (instance == null) {
            instance = new Session();
        }
        return instance;
    }

    @Override
    public void run() {
        //salje zahtev serveru
        //
    }
    
}
