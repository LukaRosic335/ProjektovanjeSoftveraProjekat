/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package threads;

import controler.ServerControler;
import domain.Zaposleni;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.net.Socket;
import transfer.Request;
import transfer.Response;
import transfer.util.ResponseStatus;
import transfer.util.Operation;

/**
 *
 * @author jevrozim
 */
public class ClientHandler extends Thread {

    private Socket socket;
    

    public ClientHandler(Socket socket) {
        this.socket = socket;
    }
    
    @Override
    public void run() { 
        try {
            ObjectInputStream in=new ObjectInputStream(socket.getInputStream());
            Request req =(Request) in.readObject();
            
            
            Response res = handleRequest(req);
            
            
            ObjectOutputStream out= new ObjectOutputStream(socket.getOutputStream());
            out.writeObject(res);
        } catch (IOException ex) {
            System.out.println("IO problem kod client handler "+ex.getMessage());
        } catch (ClassNotFoundException ex) {
            System.out.println("Klasa nije nadjena? izuzetak "+ex.getMessage());
        }
    }
    private Response handleRequest(Request req){
        Response res=new Response(ResponseStatus.Success, null);
        switch (req.getOperation()) {
            case LOGIN:
                //PRIVREMENO RESENJE ZA ONO STO BI TREBALO DA IZGLEDA OVAJ HANDLE REQUEST
                //trenutno login iz servcontrolera vraca null ukoliko nesto nije kako treba
                Zaposleni z=ServerControler.getInstance().login((Zaposleni)req.getData());
                
                if(z==null){
                    System.out.println("Zaposleni koji je poslat je null");
                    res.setStatus(ResponseStatus.Fail);
                    res.setData(z);
                    return res;
                }
                res.setData(z);
                return res;
                
                
            case LOGOUT:
                ServerControler.getInstance().logout((Zaposleni)req.getData());
                return res;
            
            default:
                System.out.println("handleRequest u client handler zakinuo");
                res.setStatus(ResponseStatus.Fail);
                res.setData(null);
                return res ;
        }
    }
    
}
