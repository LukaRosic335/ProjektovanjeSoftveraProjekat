/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.tipStola;

import dbb.DBB;
import domain.OpstiDomenskiObjekat;
import domain.TipStola;
import so.ApstraktneSistemskeOperacije;

/**
 *
 * @author jevrozim
 */
public class KreirajTipStola extends ApstraktneSistemskeOperacije<TipStola>{

    @Override
    protected TipStola execute(OpstiDomenskiObjekat odo) throws Exception {
        long id=DBB.getInstance().insert(odo);
        TipStola ts=(TipStola)odo;
        ts.setIdTipStola(id);
        return ts;
    }

    @Override
    protected void validate(OpstiDomenskiObjekat odo) throws Exception {
        if(!(odo instanceof TipStola)){
            throw new Exception("Nije prosledjen TipStola");
        }
    }
    
}
