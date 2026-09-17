/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package threads;

import controler.ServerControler;
import domain.Racun;
import domain.Roba;
import domain.Smena;
import domain.Sto;
import domain.TipStola;
import domain.Zaposleni;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import transfer.Request;
import transfer.Response;
import transfer.util.ResponseStatus;

/**
 *
 * @author jevrozim
 */
public class ClientHandler extends Thread {

    private Socket socket;
    private ObjectOutputStream out;
    private ObjectInputStream in;

    public ClientHandler(Socket socket) {
        this.socket = socket;
        try {
            out = new ObjectOutputStream(socket.getOutputStream());
            in = new ObjectInputStream(socket.getInputStream());
        } catch (IOException ex) {
            System.getLogger(ClientHandler.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
    }

    @Override
    public void run() {
        try {

            while (!socket.isClosed()) {

                Request req = (Request) in.readObject();
                System.out.println("Primio " + req.getOperation());

                Response res = handleRequest(req);
                System.out.println("Saljem " + res.getStatus() + " " + res.getData());

                out.writeObject(res);
                out.flush();

            }

        } catch (IOException ex) {
            System.out.println("IO izuzetak klijent handler " + ex.getMessage());
            ex.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("Klasa nije nadjena klijent handler readObject " + e.getMessage());
        }

    }

    //lako moguce da cu staviti ovde kompletan exception handeling 
    //Trenutno ovako ne ide excetpion handeling mora nesto da se menja
    private Response handleRequest(Request req) {
        Response res = new Response(ResponseStatus.Success, null);
        try {               //OVAJ TRY TRENUTNO HVATA SAMO GET ALL ZAPOSLENI
            switch (req.getOperation()) {
                case LOGIN:
                    //PRIVREMENO RESENJE ZA ONO STO BI TREBALO DA IZGLEDA OVAJ HANDLE REQUEST
                    //trenutno login iz servcontrolera vraca null ukoliko nesto nije kako treba
                    Zaposleni z = ServerControler.getInstance().login((Zaposleni) req.getData());

                    if (z == null) {
                        System.out.println("Zaposleni koji je poslat je null");
                        res.setStatus(ResponseStatus.Fail);
                        res.setData(z);
                        return res;
                    }
                    res.setData(z);
                    return res;

                case LOGOUT:
                    ServerControler.getInstance().logout((Zaposleni) req.getData());
                    res.setData(req.getData());
                    return res;

                //nisam siguran da je to to
                case NEW_ZAPOSLENI:
                    System.out.println("Novi zaposleni metoda");
                    Zaposleni za = ServerControler.getInstance().newZaposleni((Zaposleni) req.getData());
                    if (za == null) {
                        res.setStatus(ResponseStatus.Fail);
                        return res;
                    }
                    res.setData(za);
                    return res;
                case GET_ALL_ZAPOSLENI:
                    System.out.println("Svi zaposleni metoda");
                    ArrayList<Zaposleni> sviZaposleni = ServerControler.getInstance().getAllZaposleni();
                    res.setData(sviZaposleni);
                    return res;
                case DELETE_ZAPOSLENI:
                    System.out.println("Delete zaposleni metoda");
                    ServerControler.getInstance().deleteZaposleni((Zaposleni) req.getData());
                    return res;

                case UPDATE_ZAPOSLENI:
                    System.out.println("Update zaposleni metoda");
                    ServerControler.getInstance().updateZaposleni((Zaposleni) req.getData());
                    return res;
                case NEW_TIPSTOLA:
                    System.out.println("New TipStola metoda");
                    res.setData(ServerControler.getInstance().newTipStola((TipStola) req.getData()));
                    return res;
                case UPDATE_TIPSTOLA:
                    res.setData(ServerControler.getInstance().updateTipStola((TipStola) req.getData()));
                    return res;
                case DELETE_TIPSTOLA:
                    res.setData(ServerControler.getInstance().deleteTipStola((TipStola) req.getData()));
                    return res;
                case GET_ALL_TIPSTOLA:
                    res.setData(ServerControler.getInstance().getAllTipStola());
                    return res;
                case GET_ALL_RACUN:
                    res.setData(ServerControler.getInstance().getAllRacun());
                    return res;
                case UPDATE_RACUN:
                    Racun r=(Racun)req.getData();
                    System.out.println(r.getStavkeRacuna().size());
                    res.setData(ServerControler.getInstance().updateRacun((Racun)req.getData()));
                    return res;
                case NEW_RACUN:
                    res.setData(ServerControler.getInstance().newRacun((Racun)req.getData()));
                    return res;
                case DELETE_RACUN:
                    res.setData(ServerControler.getInstance().deleteRacun((Racun)req.getData()));
                    return res;
                case GET_RACUN:
                    res.setData(ServerControler.getInstance().getRacun((Racun)req.getData()));
                    return res;
                case GET_ALL_ROBA:
                    res.setData(ServerControler.getInstance().getAllRoba());
                    return res;
                case UPDATE_ROBA:
                    res.setData(ServerControler.getInstance().updateRoba((Roba)req.getData()));
                    return res;
                case DELETE_ROBA:
                    res.setData(ServerControler.getInstance().deleteRoba((Roba)req.getData()));
                    return res;
                case NEW_ROBA:
                    res.setData(ServerControler.getInstance().newRoba((Roba)req.getData()));
                    return res;
                case GET_ALL_SMENA:
                    res.setData(ServerControler.getInstance().getAllSmena());
                    return res;
                case UPDATE_SMENA:
                    res.setData(ServerControler.getInstance().updateSmena((Smena)req.getData()));
                    return res;
                case DELETE_SMENA:
                    res.setData(ServerControler.getInstance().deleteSmena((Smena)req.getData()));
                    return res;
                case NEW_SMENA:
                    res.setData(ServerControler.getInstance().newSmena((Smena)req.getData()));
                    return res;
                case GET_ALL_STO:
                    res.setData(ServerControler.getInstance().getAllSto());
                    return res;
                case UPDATE_STO:
                    res.setData(ServerControler.getInstance().updateSto((Sto)req.getData()));
                    return res;
                case DELETE_STO:
                    res.setData(ServerControler.getInstance().deleteSto((Sto)req.getData()));
                    return res;
                case NEW_STO:
                    res.setData(ServerControler.getInstance().newSto((Sto)req.getData()));
                    return res;
                default:
                    System.out.println("handleRequest u client handler zakinuo");
                    res.setStatus(ResponseStatus.Fail);
                    res.setData(null);
                    return res;
            }
        } catch (Exception e) {
            System.out.println("Izasao je izuzetak u Clienthadnler " + e.getMessage());
            res.setStatus(ResponseStatus.Exception);
            res.setData(e);
            return res;
        }
    }

    public void kill() throws IOException {//obavesti klijenta da je veza umrla i onda se ubije
        Response kill = new Response(ResponseStatus.ConnectionClose, null);
        out.writeObject(kill);
        socket.close();
    }

}
