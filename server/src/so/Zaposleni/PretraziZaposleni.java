/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.Zaposleni;

import domain.OpstiDomenskiObjekat;
import domain.Zaposleni;
import so.ApstraktneSistemskeOperacije;
import dbb.DBB;

/**
 *
 * @author jevrozim
 */
public class PretraziZaposleni extends ApstraktneSistemskeOperacije<Zaposleni>{

    @Override
    protected Zaposleni execute(OpstiDomenskiObjekat odo) throws Exception {
        Zaposleni zaposleni=(Zaposleni)DBB.getInstance().select(odo).get(0);
        return zaposleni;
    }

    @Override
    protected void validate(OpstiDomenskiObjekat odo) throws Exception {
        if(!(odo instanceof Zaposleni)){
            throw new Exception("Nije prosledjen Zaposleni");
        }
    }
    
}
