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
        System.out.println("klijent kontroler logout "+o);
    }
    
    
    private synchronized Object sendRequest(Operation operation,Object data){
    //ukoliko nesto nije kako treba trenutno vraca null
        Request request=new Request(data, operation);
        try {
            Session.getInstace().send(request);
            Response response=(Response)Session.getInstace().recieve();
            
            
            if(response.getStatus()==ResponseStatus.ConnectionClose){
                Session.getInstace().kill();
                return null;
                //vrati klijenta na login
            }
            if(response.getStatus().equals(ResponseStatus.Fail)){
                System.out.println("Status je fail, vraca se null");
                return null;
            }
            return response.getData();
            
        } catch (IOException ex) {
            System.out.println("Nesto se desilo pri stvaranju kanala kod klijenta lako moguce da je server zatvoren"+ex.getMessage());
            return null;
        } catch (ClassNotFoundException ex) {
            System.getLogger(ClientControler.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
            return null;
        }
        
    }

    public Object handleResponse(Response res) {
        if(res.getStatus()==ResponseStatus.ConnectionClose){
            try {
                //umre soket i samim tim konekcija
                Session.getInstace().kill();
            } catch (IOException ex) {
                System.getLogger(ClientControler.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
            }
        }
        if(res.getStatus()==ResponseStatus.Fail){
            //nesto nesto vratio se fail
        }
        if(res.getStatus()==ResponseStatus.Success){
            return null;//vrati vrednost kojuu si dobio
        }
        return null;
        
    }
}


