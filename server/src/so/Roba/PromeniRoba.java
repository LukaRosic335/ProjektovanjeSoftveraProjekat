/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.Roba;

import dbb.DBB;
import domain.OpstiDomenskiObjekat;
import domain.Roba;
import so.ApstraktneSistemskeOperacije;

/**
 *
 * @author jevrozim
 */
public class PromeniRoba extends ApstraktneSistemskeOperacije<Roba> {

    @Override
    protected Roba execute(OpstiDomenskiObjekat odo) throws Exception {
        DBB.getInstance().update(odo);
        return (Roba)odo;
    }

    @Override
    protected void validate(OpstiDomenskiObjekat odo) throws Exception {
        if(!(odo instanceof Roba)){
            throw new Exception("Nije prosledjena Roba");
        }
    }
    
}
