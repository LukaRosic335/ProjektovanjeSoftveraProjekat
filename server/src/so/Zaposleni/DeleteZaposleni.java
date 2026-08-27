/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.Zaposleni;

import dbb.DBB;
import domain.OpstiDomenskiObjekat;
import so.ApstraktneSistemskeOperacije;

/**
 *
 * @author jevrozim
 */
public class DeleteZaposleni extends ApstraktneSistemskeOperacije{

    @Override
    protected void execute(OpstiDomenskiObjekat odo) throws Exception {
        DBB.getInstance().delete(odo);
    }

    @Override
    protected void validate(OpstiDomenskiObjekat odo) throws Exception {
        //nisam siguran da li treba ovde validacija
    }
    
}
