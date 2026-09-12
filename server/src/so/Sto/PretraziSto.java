/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.Sto;

import dbb.DBB;
import domain.OpstiDomenskiObjekat;
import domain.Sto;
import so.ApstraktneSistemskeOperacije;

/**
 *
 * @author jevrozim
 */
public class PretraziSto extends ApstraktneSistemskeOperacije<Sto>{

    @Override
    protected Sto execute(OpstiDomenskiObjekat odo) throws Exception {
        Sto sto=(Sto)DBB.getInstance().select(odo).get(0);
        return sto;
    }

    @Override
    protected void validate(OpstiDomenskiObjekat odo) throws Exception {
        if(!(odo instanceof Sto)){
            throw new Exception("Nije prosledjen Sto");
        }
    }
    
}
