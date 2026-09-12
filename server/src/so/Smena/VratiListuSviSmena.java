/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.Smena;

import domain.OpstiDomenskiObjekat;
import domain.Smena;
import java.util.ArrayList;
import so.ApstraktneSistemskeOperacije;
import dbb.DBB;
        
/**
 *
 * @author jevrozim
 */
public class VratiListuSviSmena extends ApstraktneSistemskeOperacije<ArrayList<Smena>>{

    @Override
    protected ArrayList<Smena> execute(OpstiDomenskiObjekat odo) throws Exception {
        ArrayList<OpstiDomenskiObjekat> opsti=DBB.getInstance().select(odo);
        ArrayList<Smena>smene=new ArrayList<>();
        for(OpstiDomenskiObjekat o: opsti){
            smene.add((Smena)o);
        }
        return smene;
    }

    @Override
    protected void validate(OpstiDomenskiObjekat odo) throws Exception {
        if(!(odo instanceof Smena)){
            throw new Exception("Nije prosledjena Smena");
        }
    }
    
}
