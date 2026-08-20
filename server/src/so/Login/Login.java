/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.Login;

import controler.ServerControler;
import domain.OpstiDomenskiObjekat;
import domain.Zaposleni;
import java.util.ArrayList;
import so.ApstraktneSistemskeOperacije;
import dbb.DBB;
import java.sql.SQLException;

/**
 *
 * @author jevrozim
 */
public class Login extends ApstraktneSistemskeOperacije {

    private Zaposleni ulogovan;

    public Login() {
    }

    public Zaposleni getUlogovan() {
        return ulogovan;
    }

    //NISAM SIGURAN DA LI JE TO TO ZA OVE DVE METODE ALI SE CINI DA JESTE ZA SADA
    //NISAM ZADOVOLJAN EXCEPTION HANDELINGOM 
    //MISLIM RADI ALI MI SE NE SVIDJA STO SE SALJE EXCEPTION SAM PO SEBI I STO NIJE SPECIFICAN
    //DODJE MI DA NAPRAVIM SVOJ TIP IZUZETKA SAMO ZA OVAJ PROJEKAT SAMO DA BI IZGLEDALO UREDNO I LEPO
    @Override
    protected void execute(OpstiDomenskiObjekat odo) throws Exception {
        try {
            ArrayList<OpstiDomenskiObjekat> problem = DBB.getInstance().select(odo);

            ArrayList<Zaposleni> sviZaposleni = new ArrayList();
            for (OpstiDomenskiObjekat o : problem) {
                sviZaposleni.add((Zaposleni) o);
            }
            
            for (Zaposleni z : sviZaposleni) {
                if (z.getKorisnickoIme().equals(ulogovan.getKorisnickoIme())&&z.getSifra().equals(ulogovan.getSifra())) {
                    Zaposleni zaposleni=new Zaposleni(z.getIdZaposleni(), z.getIme(), z.getPrezime(), z.getKorisnickoIme(), z.getSifra());
                    ServerControler.getInstance().getUlogovani().add(zaposleni);
                    ulogovan=zaposleni;
                    return;
                }
            }
        } catch (SQLException e) {
            throw new SQLException("greska pri selektovanju u dbb select");
        }
        throw new Exception("Ne postoji zaposleni s tim kredencijalima");
    }

    @Override
    protected void validate(OpstiDomenskiObjekat odo) throws Exception {
        if (!(odo instanceof Zaposleni)) {
            throw new Exception("Nije poslat Zaposleni nego neki drugi objekat za login");
        }
        //da li je vec ulogovan
        Zaposleni zaposleni = (Zaposleni) odo;
        ArrayList<Zaposleni> ulogovaniZaposleni = ServerControler.getInstance().getUlogovani();
        for (Zaposleni z : ulogovaniZaposleni) {
            if (z.equals(zaposleni)) {
                throw new Exception("Zaposleni je vec ulogovan");
            }
        }
        ulogovan=zaposleni;

    }

}
