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
public class ClientControler {
    private static ClientControler instance;

    private ClientControler() {
    }
    
    public static ClientControler getInstance(){
        if(instance==null){
            instance=new ClientControler();
        }
        return instance;
    }
    
    public Zaposleni login(Zaposleni z){
        //ovo pozivam iz forme za login
        Zaposleni za=(Zaposleni) sendRequest(Operation.LOGIN,z);
        return za;
    }
    //trenutno vraca null nisam siguran kako cu implementirati metodu
    public void logout(Zaposleni z){
        Object o=sendRequest(Operation.LOGOUT, z);
        System.out.println(o);
    }
    
    
    private synchronized Object sendRequest(Operation operation,Object data){
    //ukoliko nesto nije kako treba trenutno vraca null
        Request request=new Request(data, operation);
        try {
//            ObjectOutputStream out=new ObjectOutputStream(Session.getInstace().getSocket().getOutputStream());
//            ObjectOutputStream out=Session.getInstace().getOut();
//            out.writeObject(request);
//            out.flush();

            Session.getInstace().getOut().writeObject(request);
            Session.getInstace().getOut().flush();
            
//            ObjectInputStream in=new ObjectInputStream(Session.getInstace().getSocket().getInputStream());
//            ObjectInputStream in=Session.getInstace().getIn();
//            Response response= (Response) in.readObject();
            Response response =(Response)Session.getInstace().getIn().readObject();
            
            
            //posalji zahtev
            //primi odgovor
            if(response.getStatus().equals(ResponseStatus.Fail)){
                System.out.println("Status je fail, vraca se null");
                return null;
            }else{
                return response.getData();
            }
        } catch (IOException ex) {
            System.out.println("Nesto se desilo pri stvaranju kanala kod klijenta "+ex.getMessage());
            return null;
        } catch (ClassNotFoundException ex) {
            System.getLogger(ClientControler.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
            return null;
        }
        
    }
}


