/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.Racun;

import dbb.DBB;
import domain.OpstiDomenskiObjekat;
import domain.Racun;
import java.util.ArrayList;
import so.ApstraktneSistemskeOperacije;

/**
 *
 * @author jevrozim
 */
public class PretraziRacun extends ApstraktneSistemskeOperacije<Racun>{

    @Override
    protected Racun execute(OpstiDomenskiObjekat odo) throws Exception {
        System.out.println("1");
        ArrayList<OpstiDomenskiObjekat>asd=DBB.getInstance().select(odo);
        System.out.println("2");
        if(asd.size()==0){
            System.out.println("2.5");

            return null;
        }
        System.out.println("3");
        Racun racun=(Racun)DBB.getInstance().select(odo).get(0);
        System.out.println("4");
        return racun;
    }

    @Override
    protected void validate(OpstiDomenskiObjekat odo) throws Exception {
        if(!(odo instanceof Racun)){
            throw new Exception("Nije prosledjen Racun");
        }
    }
    
}
