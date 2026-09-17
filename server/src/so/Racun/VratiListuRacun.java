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
public class VratiListuRacun extends ApstraktneSistemskeOperacije<ArrayList<Racun>> {

    @Override
    protected ArrayList<Racun> execute(OpstiDomenskiObjekat odo) throws Exception {
//        nesto nesto uzmi racun i baci jedan select i samo vrati tu listu
        ArrayList<OpstiDomenskiObjekat> list = DBB.getInstance().select(odo);
        ArrayList<Racun> lista = new ArrayList<>();
        for (OpstiDomenskiObjekat o : list) {
            lista.add((Racun) o);
        }
        for (Racun r : lista) {
            ArrayList<OpstiDomenskiObjekat> mrk = DBB.getInstance().select(new StavkaRacuna(r));
            ArrayList<StavkaRacuna> stavke = new ArrayList<>();
            for (OpstiDomenskiObjekat o:mrk ){
                stavke.add((StavkaRacuna)o);
            }
            r.setStavkeRacuna(stavke);
        }
        return lista;
    }

    @Override
    protected void validate(OpstiDomenskiObjekat odo) throws Exception {
        if (!(odo instanceof Racun)) {
            throw new Exception("Nije prosledjen racun");
        }
    }

}
