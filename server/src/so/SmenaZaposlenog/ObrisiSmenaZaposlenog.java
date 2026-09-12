/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.SmenaZaposlenog;

import dbb.DBB;
import domain.OpstiDomenskiObjekat;
import domain.SmenaZaposlenog;
import so.ApstraktneSistemskeOperacije;

/**
 *
 * @author jevrozim
 */
public class ObrisiSmenaZaposlenog extends ApstraktneSistemskeOperacije<SmenaZaposlenog>{

    @Override
    protected SmenaZaposlenog execute(OpstiDomenskiObjekat odo) throws Exception {
        DBB.getInstance().delete(odo);
        return (SmenaZaposlenog)odo;
    }

    @Override
    protected void validate(OpstiDomenskiObjekat odo) throws Exception {
        if(!(odo instanceof SmenaZaposlenog)){
            throw new Exception("Nije prosledjena Smena Zaposlenog");
        }
    }
    
}
