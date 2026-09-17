/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author jevrozim
 */
public class Sto extends OpstiDomenskiObjekat {

    private long idSto;
    private int brMusterija;
    private TipStola tipStola;

    public Sto() {
    }

    public Sto(long idSto, int brMusterija, TipStola tipStola) {
        this.idSto = idSto;
        this.brMusterija = brMusterija;
        this.tipStola = tipStola;
    }

    public long getIdSto() {
        return idSto;
    }

    public void setIdSto(long idSto) {
        this.idSto = idSto;
    }

    public int getBrMusterija() {
        return brMusterija;
    }

    public void setBrMusterija(int brMusterija) {
        this.brMusterija = brMusterija;
    }

    public TipStola getTipStola() {
        return tipStola;
    }

    public void setTipStola(TipStola tipStola) {
        this.tipStola = tipStola;
    }

    @Override
    public String getTableName() {
        return "Sto";
    }

    @Override
    public ArrayList<OpstiDomenskiObjekat> vratiListu(ResultSet rs) throws SQLException {
        ArrayList<OpstiDomenskiObjekat> list = new ArrayList<>();
        while (rs.next()) {
            //napravim tipstola
            TipStola tip = new TipStola(rs.getLong("TipStola.idTipStola"), rs.getInt("TipStola.brMesta"));
            //napravim astal
            Sto sto = new Sto(rs.getLong("Sto.idSto"), rs.getInt("Sto.brMusterija"), tip);
            list.add(sto);
        }
        rs.close();
        return list;
    }

    @Override
    public String getInsertValues() {
        return "(" + brMusterija + ", " + tipStola.getIdTipStola() + ")";
    }

    @Override
    public String getColumnNames() {
        return "brMusterija, idTipStola";
    }

    @Override
    public String getUpdateValues() {
        return " brMusterija=" + brMusterija + ", idTipStola=" + tipStola.getIdTipStola();
    }

    @Override
    public String getWhere() {
        return " idSto=" + idSto;
    }

    @Override
    public String getSelectCondition() { //MOZDA KONKRETNO KOJI TIP STOLA ???
        String query = "";
        if (idSto != 0) {
            query += " AND Sto.idSto=" + idSto;
        }
        if (brMusterija > 0) {
            query += " AND Sto.brMusterija=" + brMusterija;
        }
        if (tipStola != null) {
            if (tipStola.getIdTipStola() != 0) {
                query += " AND Sto.idTipStola=" + tipStola.getIdTipStola();
            }
        }
        return query;
    }

    @Override
    public String getJoinCondition() {
        return "JOIN TipStola ON Sto.idTipStola=TipStola.idTipStola ";
    }

    @Override
    public String toString() {
        return String.valueOf(idSto);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Sto)) {
            return false;
        }
        Sto x = (Sto) obj;
        if (idSto == x.getIdSto()) {
            return true;
        }
        return false;
    }
}
