/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.Racun;

import dbb.DBB;
import domain.OpstiDomenskiObjekat;
import domain.Racun;
import java.util.ArrayList;
import so.ApstraktneSistemskeOperacije;

/**
 *
 * @author jevrozim
 */
public class ObrisiRacun extends ApstraktneSistemskeOperacije<Racun>{

    @Override
    protected Racun execute(OpstiDomenskiObjekat odo) throws Exception {
        DBB.getInstance().delete(odo);
        return (Racun)odo;
    }

    @Override
    protected void validate(OpstiDomenskiObjekat odo) throws Exception {
        if(!(odo instanceof Racun)){
            throw new Exception("Nije prosledjen racun");
        }
        ArrayList<OpstiDomenskiObjekat> ra= DBB.getInstance().select(odo);
        if(ra.size()==0){
            throw new Exception("Ne postoji takav racun");
        }
    }
    
}
