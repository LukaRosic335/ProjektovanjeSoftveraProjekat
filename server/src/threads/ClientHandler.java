/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package threads;

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
//            System.getLogger(ClientHandler.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
            System.out.println("IO problem kod client handler "+ex.getMessage());
            //stvaranje input streama izuzetak
        } catch (ClassNotFoundException ex) {
            //readObject izuzetak
//            System.getLogger(ClientHandler.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
            System.out.println("Klasa nije nadjena? izuzetak "+ex.getMessage());
        }
    }
    private Response handleRequest(Request req){
        Response res=new Response(ResponseStatus.Success, null);
        switch (req.getOperation()) {
            case LOGIN:
                System.out.println("OVO ZA SADA RADI");
                Zaposleni zaposleni = (Zaposleni) req.getData();
                res.setData(zaposleni);
                return res;
            default:
//                throw new AssertionError();
                System.out.println("handleRequest zakinuo");
                res.setStatus(ResponseStatus.Fail);
                res.setData(null);
                return res ;
        }
    }
    
}
