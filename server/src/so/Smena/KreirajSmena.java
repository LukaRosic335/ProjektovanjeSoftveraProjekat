/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.Smena;

import dbb.DBB;
import domain.OpstiDomenskiObjekat;
import domain.Smena;
import so.ApstraktneSistemskeOperacije;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author jevrozim
 */
public class KreirajSmena extends ApstraktneSistemskeOperacije<Smena> {

    @Override
    protected Smena execute(OpstiDomenskiObjekat odo) throws Exception {
        PreparedStatement ps = DBB.getInstance().insert(odo);
        ResultSet rs = ps.getGeneratedKeys();
        rs.next();
        long ret = rs.getLong(1);
        rs.close();
        Smena smena = (Smena) odo;
        smena.setIdSmena(ret);
        return smena;
    }

    @Override
    protected void validate(OpstiDomenskiObjekat odo) throws Exception {
        if (!(odo instanceof Smena)) {
            throw new Exception("Nije prosledjena Smena");
        }
    }

}
