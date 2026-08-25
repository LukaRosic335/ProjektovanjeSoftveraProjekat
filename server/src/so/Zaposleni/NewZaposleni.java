/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.Zaposleni;

import dbb.DBB;
import domain.OpstiDomenskiObjekat;
import domain.Zaposleni;
import so.ApstraktneSistemskeOperacije;

/**
 *
 * @author jevrozim
 */
public class NewZaposleni extends ApstraktneSistemskeOperacije {

    private Zaposleni z;

    @Override
    protected void execute(OpstiDomenskiObjekat odo) throws Exception {
        DBB.getInstance().insert(odo);
    }

    @Override
    protected void validate(OpstiDomenskiObjekat odo) throws Exception {
        //VALJDA JE TO TO STO SE TICE VALIDACIJE
        
        if (!(odo instanceof Zaposleni)) {
            throw new Exception("Nije poslat zaposleni");
        }
        Zaposleni zaposleni = (Zaposleni)odo;
        if(zaposleni.getIme().equals("")||zaposleni.getPrezime().equals("")||zaposleni.getKorisnickoIme().equals("")||zaposleni.getSifra().equals("")){
            throw new Exception("Nisu poslati validni argumetni");
        }
        z=zaposleni;
        
    }

    public Zaposleni getZaposleni() {
        return z;
    }

}
