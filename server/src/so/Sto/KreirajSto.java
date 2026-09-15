/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.Sto;

import domain.OpstiDomenskiObjekat;
import domain.Sto;
import so.ApstraktneSistemskeOperacije;
import dbb.DBB;

/**
 *
 * @author jevrozim
 */
public class KreirajSto extends ApstraktneSistemskeOperacije<Sto> {

    @Override
    protected Sto execute(OpstiDomenskiObjekat odo) throws Exception {
        long id=DBB.getInstance().insert(odo);
        Sto sto=(Sto)odo;
        sto.setIdSto(id);
        return sto;
    }

    @Override
    protected void validate(OpstiDomenskiObjekat odo) throws Exception {
        if(!(odo instanceof Sto)){
            throw new Exception("Nije prosledjen Sto");
        }
    }
    
}
