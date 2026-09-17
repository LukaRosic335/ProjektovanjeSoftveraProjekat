/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.tipStola;

import dbb.DBB;
import domain.OpstiDomenskiObjekat;
import domain.TipStola;
import so.ApstraktneSistemskeOperacije;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author jevrozim
 */
public class KreirajTipStola extends ApstraktneSistemskeOperacije<TipStola> {

    @Override
    protected TipStola execute(OpstiDomenskiObjekat odo) throws Exception {
        PreparedStatement ps = DBB.getInstance().insert(odo);
        ResultSet rs = ps.getGeneratedKeys();
        rs.next();
        long ret = rs.getLong(1);
        rs.close();
        TipStola ts = (TipStola) odo;
        ts.setIdTipStola(ret);
        return ts;
    }

    @Override
    protected void validate(OpstiDomenskiObjekat odo) throws Exception {
        if (!(odo instanceof TipStola)) {
            throw new Exception("Nije prosledjen TipStola");
        }
    }

}
