/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.Smena;

import dbb.DBB;
import domain.OpstiDomenskiObjekat;
import domain.Smena;
import so.ApstraktneSistemskeOperacije;

/**
 *
 * @author jevrozim
 */
public class PretraziSmena extends ApstraktneSistemskeOperacije<Smena>{

    @Override
    protected Smena execute(OpstiDomenskiObjekat odo) throws Exception {
        Smena smena=(Smena)DBB.getInstance().select(odo).get(0);
        return smena;
    }

    @Override
    protected void validate(OpstiDomenskiObjekat odo) throws Exception {
        if(!(odo instanceof Smena)){
            throw new Exception("Nije prosledjen Sto");
        }
    }
    
}
