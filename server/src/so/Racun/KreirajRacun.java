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
public class KreirajRacun extends ApstraktneSistemskeOperacije<Racun>{

    @Override
    protected Racun execute(OpstiDomenskiObjekat odo) throws Exception {
        long idRacun=DBB.getInstance().insert(odo);
        Racun racun=(Racun)odo;
        racun.setIdRacun(idRacun);
        for(StavkaRacuna stavka:racun.getStavkeRacuna()){
            DBB.getInstance().insert(stavka);
        }
        return racun;
    }

    @Override
    protected void validate(OpstiDomenskiObjekat odo) throws Exception {
        if(!(odo instanceof Racun)){
            throw new Exception("Nije prosledjen racun");
        }
        
    }
    
}



//
//Racun racun=(Racun)odo;
//        ArrayList<StavkaRacuna>stavke=racun.getStavkeRacuna();
//        for(StavkaRacuna stavka:stavke){
//            DBB.getInstance().insert(stavka);
//        }
//        DBB.getInstance().insert(odo);
//        return (Racun)odo;