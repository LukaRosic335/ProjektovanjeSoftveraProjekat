/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.Roba;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import dbb.DBB;
import domain.OpstiDomenskiObjekat;
import domain.Roba;
import so.ApstraktneSistemskeOperacije;

/**
 *
 * @author jevrozim
 */
public class KreirajRoba extends ApstraktneSistemskeOperacije<Roba> {

    @Override
    protected Roba execute(OpstiDomenskiObjekat odo) throws Exception {
        PreparedStatement ps = DBB.getInstance().insert(odo);
        ResultSet rs = ps.getGeneratedKeys();
        rs.next();
        long ret = rs.getLong(1);
        rs.close();
        Roba roba = (Roba) odo;
        roba.setIdRoba(ret);
        return roba;
    }

    @Override
    protected void validate(OpstiDomenskiObjekat odo) throws Exception {
        if (!(odo instanceof Roba)) {
            throw new Exception("Nije prosledjena Roba");
        }
    }

}
