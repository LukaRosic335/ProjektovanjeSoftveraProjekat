/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.Sto;

import dbb.DBB;
import domain.OpstiDomenskiObjekat;
import domain.Sto;
import so.ApstraktneSistemskeOperacije;

/**
 *
 * @author jevrozim
 */
public class PromeniSto extends ApstraktneSistemskeOperacije<Sto> {

    @Override
    protected Sto execute(OpstiDomenskiObjekat odo) throws Exception {
        DBB.getInstance().update(odo);
        return (Sto) odo;
    }

    @Override
    protected void validate(OpstiDomenskiObjekat odo) throws Exception {
        if (!(odo instanceof Sto)) {
            throw new Exception("Nije prosledjen Sto");
        }
        Sto sto = (Sto) odo;
        if (sto.getBrMusterija() > sto.getTipStola().getBrMesta()) {
            throw new Exception("Sto ne moze imati vise musterija nego sto ima mesta");
        }
    }

}
