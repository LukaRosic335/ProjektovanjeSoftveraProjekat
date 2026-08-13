/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controler;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import transfer.Request;
import transfer.Response;
import clientsession.Session;
import domain.Zaposleni;
import java.io.ObjectInputStream;
import transfer.util.Operation;
import transfer.util.ResponseStatus;



/**
 *
 * @author jevrozim
 */
public class KlijentKontroler {
    private static KlijentKontroler instance;

    private KlijentKontroler() {
    }
    
    public static KlijentKontroler getInstance(){
        if(instance==null){
            instance=new KlijentKontroler();
        }
        return instance;
    }
    
    public Zaposleni login(Zaposleni z){
        //ovo pozivam iz forme za login
        Zaposleni za=(Zaposleni) sendRequest(Operation.LOGIN,z);
        return za;
    }
    
    
    private synchronized Object sendRequest(Operation operation,Object data){
    //ukoliko nesto nije kako treba trenutno vraca null
        Request request=new Request(data, operation);
        try {
            ObjectOutputStream out=new ObjectOutputStream(Session.getInstace().getSocket().getOutputStream());
            out.writeObject(request);
            
            ObjectInputStream in=new ObjectInputStream(Session.getInstace().getSocket().getInputStream());
            Response response= (Response) in.readObject();
            
            if(response.getStatus().equals(ResponseStatus.Fail)){
                System.out.println("NEUSPESNO IZVRSENA STVAR JOS MISLIM KAKO CU DA NAPRAVIM OVO");
                return null;
            }else{
                return response.getData();
            }
        } catch (IOException ex) {
            System.out.println("Nesto se desilo pri stvaranju kanala kod klijenta "+ex.getMessage());
            return null;
        } catch (ClassNotFoundException ex) {
            System.getLogger(KlijentKontroler.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
            return null;
        }
        
    }
}


//Request request = new Request(operation, data);
//
//        ObjectOutputStream out = new ObjectOutputStream(Session.getInstance().getSocket().getOutputStream());
//        out.writeObject(request);
//
//        ObjectInputStream in = new ObjectInputStream(Session.getInstance().getSocket().getInputStream());
//        Response response = (Response) in.readObject();
//
//        if (response.getResponseStatus().equals(ResponseStatus.Error)) {
//            throw response.getException();
//        } else {
//            return response.getData();
//        }
