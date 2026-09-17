/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controler;

import java.io.IOException;
import transfer.Request;
import transfer.Response;
import clientsession.Session;
import domain.Racun;
import domain.Roba;
import domain.Smena;
import domain.Sto;
import domain.TipStola;
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

    public Zaposleni getUlogovani() {
        return Session.getInstace().getUlogovani();
    }

    public static void main(String[] args) {
        LoginForm login = new LoginForm();
        login.getMessageTxt().setText("Unesite korisnicko ime i lozinku");
    }

    public Zaposleni login(Zaposleni z) throws Exception {
        //ovo pozivam iz forme za login
        Zaposleni za = (Zaposleni) sendRequest(Operation.LOGIN, z);
        Session.getInstace().setUlogovani(za);
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
        sendRequest(Operation.DELETE_ZAPOSLENI, pokojni);
    }

    public Zaposleni updateZaposleni(Zaposleni zaposleni) throws Exception {
        System.out.println("updatezaposleni CC");
        return (Zaposleni) sendRequest(Operation.UPDATE_ZAPOSLENI, zaposleni);
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

    public ArrayList<TipStola> getAllTipStola() throws Exception {
        ArrayList<TipStola> z = (ArrayList<TipStola>) sendRequest(Operation.GET_ALL_TIPSTOLA, null);
        return z;
    }

    public TipStola noviTipStola(TipStola novi) throws Exception {
        return (TipStola) sendRequest(Operation.NEW_TIPSTOLA, novi);
    }

    public void updateTipStola(TipStola ts) throws Exception {
        sendRequest(Operation.UPDATE_TIPSTOLA, ts);
    }

    public TipStola deleteTipStola(TipStola pokojni) throws Exception {
        return (TipStola) sendRequest(Operation.DELETE_TIPSTOLA, pokojni);
    }

    public ArrayList<Smena> getAllSmena() throws Exception {
        ArrayList<Smena> z = (ArrayList<Smena>) sendRequest(Operation.GET_ALL_SMENA, null);
        return z;
    }

    public Smena deleteSmena(Smena pokojni) throws Exception {
        return (Smena) sendRequest(Operation.DELETE_SMENA, pokojni);
    }

    public Smena noviSmena(Smena novi) throws Exception {
        return (Smena) sendRequest(Operation.NEW_SMENA, novi);
    }

    public Smena updateSmena(Smena novi) throws Exception {
        return (Smena) sendRequest(Operation.UPDATE_SMENA, novi);
    }

    public ArrayList<Roba> getAllRoba() throws Exception {
        ArrayList<Roba> r = (ArrayList<Roba>) sendRequest(Operation.GET_ALL_ROBA, new Roba());
        return r;
    }

    public Roba noviRoba(Roba novi) throws Exception {
        return (Roba) sendRequest(Operation.NEW_ROBA, novi);
    }

    public Roba updateRoba(Roba novi) throws Exception {
        return (Roba) sendRequest(Operation.UPDATE_ROBA, novi);
    }

    public Roba deleteRoba(Roba pokojni) throws Exception {
        return (Roba) sendRequest(Operation.DELETE_ROBA, pokojni);
    }

    public ArrayList<Sto> getAllSto() throws Exception {
        ArrayList<Sto> stolovp = (ArrayList<Sto>) sendRequest(Operation.GET_ALL_STO, new Sto());
        return stolovp;
    }

    public Sto noviSto(Sto novi) throws Exception {
        return (Sto) sendRequest(Operation.NEW_STO, novi);
    }

    public Sto deleteSto(Sto pokojni) throws Exception {
        return (Sto) sendRequest(Operation.DELETE_STO, pokojni);

    }

    public ArrayList<Racun> getAllRacun() throws Exception {
        ArrayList<Racun> r = (ArrayList<Racun>) sendRequest(Operation.GET_ALL_RACUN, new Racun());
        return r;
    }

    public ArrayList<Racun> getRacun(Racun racun) throws Exception {
        return (ArrayList<Racun>) sendRequest(Operation.GET_RACUN, racun);
    }

    public Racun updateRacun(Racun racun) throws Exception {
        System.out.println(racun.getStavkeRacuna().size());
        return (Racun) sendRequest(Operation.UPDATE_RACUN, racun);
    }

    public Racun deleteRacun(Racun r) throws Exception {
        return (Racun) sendRequest(Operation.DELETE_RACUN, r);
    }

    public Racun noviRacun(Racun racun) throws Exception {
        return (Racun) sendRequest(Operation.NEW_RACUN, racun);
    }

}
