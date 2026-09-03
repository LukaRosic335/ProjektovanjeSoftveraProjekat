/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.Zaposleni;

import dbb.DBB;
import domain.OpstiDomenskiObjekat;
import domain.Zaposleni;
import java.util.ArrayList;
import so.ApstraktneSistemskeOperacije;

/**
 *
 * @author jevrozim
 */
public class GetAllZaposleni extends ApstraktneSistemskeOperacije {

    private ArrayList<Zaposleni> zaposleni;

    @Override
    protected void execute(OpstiDomenskiObjekat odo) throws Exception {
        Zaposleni za=new Zaposleni();
        ArrayList<OpstiDomenskiObjekat> z=DBB.getInstance().select(za);
        ArrayList<Zaposleni> zap=new ArrayList();
        for(OpstiDomenskiObjekat o:z){
            zap.add((Zaposleni)o);
        }
        zaposleni=zap;
        throw new Exception("Test uzmi sve zapslene");
    }

    @Override
    protected void validate(OpstiDomenskiObjekat odo) throws Exception {
        
    }

    public ArrayList<Zaposleni> getZaposleni() {
        return zaposleni;
    }

}
