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
public class ObrisiRacun extends ApstraktneSistemskeOperacije<Racun>{

    @Override
    protected Racun execute(OpstiDomenskiObjekat odo) throws Exception {
        System.out.println("1");
        Racun racun=(Racun)odo;
        for(StavkaRacuna stavka:racun.getStavkeRacuna()){
            System.out.println("2");
            DBB.getInstance().delete(stavka);
            System.out.println("3");
        }
        System.out.println("4");
        DBB.getInstance().delete(odo);
        System.out.println("5");
        return racun;
    }
    @Override
    protected void validate(OpstiDomenskiObjekat odo) throws Exception {
        if(!(odo instanceof Racun)){
            throw new Exception("Nije prosledjen racun");
        }

    }
    
}
