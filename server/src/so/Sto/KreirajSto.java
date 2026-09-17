/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.Sto;

import domain.OpstiDomenskiObjekat;
import domain.Sto;
import so.ApstraktneSistemskeOperacije;
import dbb.DBB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author jevrozim
 */
public class KreirajSto extends ApstraktneSistemskeOperacije<Sto> {

    @Override
    protected Sto execute(OpstiDomenskiObjekat odo) throws Exception {
        PreparedStatement ps = DBB.getInstance().insert(odo);
        ResultSet rs = ps.getGeneratedKeys();
        rs.next();
        long ret = rs.getLong(1);
        rs.close();
        Sto sto = (Sto) odo;
        sto.setIdSto(ret);
        return sto;
    }

    @Override
    protected void validate(OpstiDomenskiObjekat odo) throws Exception {
        if (!(odo instanceof Sto)) {
            throw new Exception("Nije prosledjen Sto");
        }
        Sto sto=(Sto)odo;
        if(sto.getBrMusterija()>sto.getTipStola().getBrMesta()){
            throw new Exception("Sto ne moze imati vise musterija nego sto ima mesta");
        }
    }

}
