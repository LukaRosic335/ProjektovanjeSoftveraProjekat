/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.SmenaZaposlenog;

import domain.OpstiDomenskiObjekat;
import domain.SmenaZaposlenog;
import java.util.ArrayList;
import so.ApstraktneSistemskeOperacije;
import dbb.DBB;

/**
 *
 * @author jevrozim
 */
public class VratiListuSviSmenaZaposleni extends ApstraktneSistemskeOperacije<ArrayList<SmenaZaposlenog>>{

    @Override
    protected ArrayList<SmenaZaposlenog> execute(OpstiDomenskiObjekat odo) throws Exception {
        ArrayList<OpstiDomenskiObjekat> opste=DBB.getInstance().select(odo);
        ArrayList<SmenaZaposlenog> sz=new ArrayList<>();
        for(OpstiDomenskiObjekat o: opste){
            sz.add((SmenaZaposlenog)o);
        }
        return sz;
    }

    @Override
    protected void validate(OpstiDomenskiObjekat odo) throws Exception {
        if(!(odo instanceof SmenaZaposlenog)){
            throw new Exception("Nije prosledjena Smena Zaposlenog");
        }
    }
    
}
