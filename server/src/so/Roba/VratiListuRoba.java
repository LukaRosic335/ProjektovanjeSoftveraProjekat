/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.Roba;

import dbb.DBB;
import domain.OpstiDomenskiObjekat;
import domain.Roba;
import java.util.ArrayList;
import so.ApstraktneSistemskeOperacije;

/**
 *
 * @author jevrozim
 */
public class VratiListuRoba extends ApstraktneSistemskeOperacije<ArrayList<Roba>>{

    @Override
    protected ArrayList<Roba> execute(OpstiDomenskiObjekat odo) throws Exception {
        ArrayList<OpstiDomenskiObjekat>opste=DBB.getInstance().select(odo);
        ArrayList<Roba>robe=new ArrayList<>();
        for(OpstiDomenskiObjekat o:opste){
            robe.add((Roba)o);
        }
        return robe;
    }

    @Override
    protected void validate(OpstiDomenskiObjekat odo) throws Exception {
        if(!(odo instanceof Roba)){
            throw new Exception("Nije prosledjena roba");
        }
    }
    
}
