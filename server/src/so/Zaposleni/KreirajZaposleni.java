/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.Zaposleni;

import dbb.DBB;
import domain.OpstiDomenskiObjekat;
import domain.Zaposleni;
import java.util.ArrayList;
import so.ApstraktneSistemskeOperacije;

/**
 *
 * @author jevrozim
 */
public class KreirajZaposleni extends ApstraktneSistemskeOperacije<Zaposleni> {

    @Override
    protected Zaposleni execute(OpstiDomenskiObjekat odo) throws Exception {
        long id = DBB.getInstance().insert(odo);
        Zaposleni zaposleni=(Zaposleni)odo;
        zaposleni.setIdZaposleni(id);
        return zaposleni;
    }

    @Override
    protected void validate(OpstiDomenskiObjekat odo) throws Exception {
        if (!(odo instanceof Zaposleni)) {
            throw new Exception("Nije poslat zaposleni");
        }
        Zaposleni zaposleni = (Zaposleni) odo;
        if (zaposleni.getIme().equals("") || zaposleni.getPrezime().equals("") || zaposleni.getKorisnickoIme().equals("") || zaposleni.getSifra().equals("")) {
            throw new Exception("Nisu poslati validni argumetni");
        }
        ArrayList<OpstiDomenskiObjekat> svi = DBB.getInstance().select(new Zaposleni(zaposleni.getKorisnickoIme()));
        if (svi.size() != 0) {
            throw new Exception("Zaposleni s tim korisnickim imenom vec postoji");
        }
    }
}
