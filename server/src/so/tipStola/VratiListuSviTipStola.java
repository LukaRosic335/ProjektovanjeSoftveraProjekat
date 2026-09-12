/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.tipStola;

import dbb.DBB;
import domain.OpstiDomenskiObjekat;
import domain.TipStola;
import java.util.ArrayList;
import so.ApstraktneSistemskeOperacije;

/**
 *
 * @author jevrozim
 */
public class VratiListuSviTipStola extends ApstraktneSistemskeOperacije<ArrayList<TipStola>>{

    @Override
    protected ArrayList<TipStola> execute(OpstiDomenskiObjekat odo) throws Exception {
        ArrayList<OpstiDomenskiObjekat> opsti=DBB.getInstance().select(odo);
        ArrayList<TipStola> tipovi=new ArrayList<>();
        for(OpstiDomenskiObjekat o:opsti){
            tipovi.add((TipStola)o);
        }
        return tipovi;
    }

    @Override
    protected void validate(OpstiDomenskiObjekat odo) throws Exception {
        if(!(odo instanceof TipStola)){
            throw new Exception("Nije prosledjen Tip Stola");
        }
    }
    
}
