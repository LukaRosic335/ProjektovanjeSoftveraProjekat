/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.Racun;

import dbb.DBB;
import domain.OpstiDomenskiObjekat;
import domain.Racun;
import domain.StavkaRacuna;
import java.util.ArrayList;
import so.ApstraktneSistemskeOperacije;

/**
 *
 * @author jevrozim
 */
public class VratiListuSviRacun extends ApstraktneSistemskeOperacije<ArrayList<Racun>> {

    @Override
    protected ArrayList<Racun> execute(OpstiDomenskiObjekat odo) throws Exception {
        ArrayList<OpstiDomenskiObjekat> problem = DBB.getInstance().select(odo);
        ArrayList<Racun> listaRacuna = new ArrayList<>();
        for (OpstiDomenskiObjekat o : problem) {
            listaRacuna.add((Racun) o);
        }
        //zabodi stavke racuna
        for (Racun r : listaRacuna) {
            ArrayList<OpstiDomenskiObjekat> problem2 = DBB.getInstance().select(r);
            ArrayList<StavkaRacuna> stavke=new ArrayList<>();
            for(OpstiDomenskiObjekat o : problem2){
                stavke.add((StavkaRacuna)o);
            }
            r.setStavkeRacuna(stavke);
        }

        return listaRacuna;
    }

    @Override
    protected void validate(OpstiDomenskiObjekat odo) throws Exception {
        if(!(odo instanceof Racun)){
            throw new Exception("Nije prosledjen racun");
        }
    }

}
