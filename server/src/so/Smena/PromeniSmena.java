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
public class PromeniSmena extends ApstraktneSistemskeOperacije<Smena>{

    @Override
    protected Smena execute(OpstiDomenskiObjekat odo) throws Exception {
        DBB.getInstance().update(odo);
        return (Smena)odo;
    }
    
    @Override
    protected void validate(OpstiDomenskiObjekat odo) throws Exception {
        if(!(odo instanceof Smena)){
            throw new Exception("Nije prosledjena Smena");
        }
    }
    
}
