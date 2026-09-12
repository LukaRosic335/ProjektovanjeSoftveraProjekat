/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.SmenaZaposlenog;

import domain.OpstiDomenskiObjekat;
import domain.SmenaZaposlenog;
import so.ApstraktneSistemskeOperacije;
import dbb.DBB;

/**
 *
 * @author jevrozim
 */
public class PretraziSmenaZaposlenog extends ApstraktneSistemskeOperacije<SmenaZaposlenog>{

    @Override
    protected SmenaZaposlenog execute(OpstiDomenskiObjekat odo) throws Exception {
        SmenaZaposlenog sz=(SmenaZaposlenog)DBB.getInstance().select((SmenaZaposlenog)odo).get(0);
        return sz;
    }

    @Override
    protected void validate(OpstiDomenskiObjekat odo) throws Exception {
        if(!(odo instanceof SmenaZaposlenog)){
            throw new Exception("Nije prosledjena Smena Zaposlenog");
        }
    }
    
}
