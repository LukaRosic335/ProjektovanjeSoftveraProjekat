/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controler;

import java.io.IOException;
import transfer.Request;
import transfer.Response;
import clientsession.Session;
import domain.Zaposleni;
import front.LoginForm;
import java.util.ArrayList;
import javax.swing.JFrame;
import transfer.util.Operation;
import transfer.util.ResponseStatus;

/**
 *
 * @author jevrozim
 */
public class ClientControler {

    private static ClientControler instance;
    private ArrayList<JFrame> frames;    //Najverovatnije mi ne treba idk mozda i bude
    private static LoginForm loginForm;

    private ClientControler() {
        frames = new ArrayList();
    }

    public static ClientControler getInstance() {
        if (instance == null) {
            instance = new ClientControler();
        }
        return instance;
    }

    public ArrayList<JFrame> getFrames() {
        return frames;
    }

    public static void main(String[] args) {
        LoginForm login = new LoginForm();
        login.getMessageTxt().setText("Unesite korisnicko ime i lozinku");
    }

    public Zaposleni login(Zaposleni z) throws Exception {
        //ovo pozivam iz forme za login
        Zaposleni za = (Zaposleni) sendRequest(Operation.LOGIN, z);
        return za;
    }

    //trenutno vraca null nisam siguran kako cu implementirati metodu
    public void logout(Zaposleni z) throws Exception {
        Object o = sendRequest(Operation.LOGOUT, z);
        Session.getInstace().setUlogovani(null);//Ovo treba da radi klijent kontroler
        System.out.println("klijent kontroler logout " + o);
    }

    public Zaposleni newZaposleni(Zaposleni zaposleni) throws Exception {
        Zaposleni z = (Zaposleni) sendRequest(Operation.NEW_ZAPOSLENI, zaposleni);
        return z;
    }

    public ArrayList<Zaposleni> getAllZaposleni() throws Exception {
        ArrayList<Zaposleni> z = (ArrayList<Zaposleni>) sendRequest(Operation.GET_ALL_ZAPOSLENI, null);
        System.out.println("getAllZaposleni CC");
        return z;
    }

    public void deleteZaposleni(Zaposleni pokojni) throws Exception {
        System.out.println("deleteZaposleni CC");
        sendRequest(Operation.DELETE, pokojni);
    }

    private synchronized Object sendRequest(Operation operation, Object data) throws Exception {
        //ukoliko nesto nije kako treba trenutno vraca null
        Request request = new Request(data, operation);
        try {
            System.out.println("Poslato CC" + request.getOperation() + " " + request.getData());
            Session.getInstace().send(request);
            Response response = (Response) Session.getInstace().recieve();
            System.out.println("Primljeno CC" + response.getStatus() + " " + response.getData());

            if (response.getStatus() == ResponseStatus.ConnectionClose) {
                for (JFrame j : frames) {//zatvara sve prozore koji bi mogli biti otvoreni
                    j.dispose();
                }
                loginForm = new LoginForm();
                loginForm.getMessageTxt().setText("Server je prestao sa radom");
                Session.getInstace().setUlogovani(null);
                Session.getInstace().kill();
                return null;
                //vrati klijenta na login
            }
            if (response.getStatus().equals(ResponseStatus.Fail)) {
                System.out.println("Status je fail, vraca se null");
                return null;
            }
            if (response.getStatus().equals(ResponseStatus.Exception)) {
                System.out.println("Klijent je primio exc, vraca se exc");
                Exception e = (Exception) response.getData();
                throw e;
            }
            System.out.println("Primljeno " + response.getData());
            return response.getData();

        } catch (IOException ex) {
            System.out.println("Nesto se desilo pri stvaranju kanala kod klijenta lako moguce da je server zatvoren" + ex.getMessage());
            return null;
        } catch (ClassNotFoundException ex) {
            System.out.println("Klasa nije nadjena izuzetak CC " + ex.getMessage());
            return null;
        }

    }

    //NISAM SIGURAN KOLIKO MI OVO TREBA U BUDUCE, TJ DA LI CU GA UOPSTE KORISTITI ALI ZASAD NEKA GA
    public Object handleResponse(Response res) {
        if (res.getStatus() == ResponseStatus.ConnectionClose) {
            try {
                //umre soket i samim tim konekcija
                Session.getInstace().kill();
            } catch (IOException ex) {
                System.getLogger(ClientControler.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
            }
        }
        if (res.getStatus() == ResponseStatus.Fail) {
            //nesto nesto vratio se fail
        }
        if (res.getStatus() == ResponseStatus.Success) {
            return null;//vrati vrednost kojuu si dobio
        }
        return null;

    }

}
