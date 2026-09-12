/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.Sto;

import domain.OpstiDomenskiObjekat;
import domain.Sto;
import java.util.ArrayList;
import so.ApstraktneSistemskeOperacije;
import dbb.DBB;

/**
 *
 * @author jevrozim
 */
public class VratiListuSviSto extends ApstraktneSistemskeOperacije<ArrayList<Sto>>{

    @Override
    protected ArrayList<Sto> execute(OpstiDomenskiObjekat odo) throws Exception {
        ArrayList<OpstiDomenskiObjekat> opste=DBB.getInstance().select(odo);
        ArrayList<Sto> stolovi=new ArrayList<>();
        for(OpstiDomenskiObjekat o: opste){
            stolovi.add((Sto)o);
        }
        return stolovi;
    }

    @Override
    protected void validate(OpstiDomenskiObjekat odo) throws Exception {
        if(!(odo instanceof Sto)){
            throw new Exception("Nije prosledjen Sto");
        }
    }
    
}
