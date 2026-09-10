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
public class TipStola extends OpstiDomenskiObjekat {

    private long idTipStola;
    private int brMesta;

    public TipStola() {
    }

    public TipStola(long idTipStola, int brMesta) {
        this.idTipStola = idTipStola;
        this.brMesta = brMesta;
    }

    public long getIdTipStola() {
        return idTipStola;
    }

    public void setIdTipStola(long idTipStola) {
        this.idTipStola = idTipStola;
    }

    public int getBrMesta() {
        return brMesta;
    }

    public void setBrMesta(int brMesta) {
        this.brMesta = brMesta;
    }

    @Override
    public String getTableName() {
        return "TipStola";
    }

    @Override
    public ArrayList<OpstiDomenskiObjekat> vratiListu(ResultSet rs) throws SQLException {
        ArrayList<OpstiDomenskiObjekat> lista = new ArrayList<>();
        while (rs.next()) {
            TipStola mrk = new TipStola(rs.getLong("idTipStola"), rs.getInt("brMesta"));
            lista.add(mrk);
        }
        rs.close();
        return lista;
    }

    @Override
    public String getInsertValues() {
        return "(" + brMesta + ")";

    }

    @Override
    public String getColumnNames() {
        return "brMesta";
    }

    @Override
    public String getUpdateValues() {
        return "brMesta="+brMesta;
    }

    @Override
    public String getWhere() {
        return "idTipStola="+idTipStola;
    }

    @Override
    public String getSelectCondition() {
        String query="";
        if(idTipStola!=0){
            query+=idTipStola;
        }
        if(brMesta!=0){
            query+=brMesta;
        }
        return query;
    }

    @Override
    public String getJoinCondition() {
        return "";
    }
    
    

}
