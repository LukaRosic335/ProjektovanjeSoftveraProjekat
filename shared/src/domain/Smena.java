/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalTime;
import java.util.ArrayList;

/**
 *
 * @author jevrozim
 */
public class Smena extends OpstiDomenskiObjekat {

    private long idSmena;
    private LocalTime pocetak;
    private LocalTime kraj;

    public Smena(long idSmena, LocalTime pocetak, LocalTime kraj) {
        this.idSmena = idSmena;
        this.pocetak = pocetak;
        this.kraj = kraj;
    }

    public Smena() {
    }

    public long getIdSmena() {
        return idSmena;
    }

    public void setIdSmena(long idSmena) {
        this.idSmena = idSmena;
    }

    public LocalTime getPocetak() {
        return pocetak;
    }

    public void setPocetak(LocalTime pocetak) {
        this.pocetak = pocetak;
    }

    public LocalTime getKraj() {
        return kraj;
    }

    public void setKraj(LocalTime kraj) {
        this.kraj = kraj;
    }

    @Override
    public String getTableName() {
        return "Smena";
    }

    @Override
    public ArrayList<OpstiDomenskiObjekat> vratiListu(ResultSet rs) throws SQLException {
        ArrayList<OpstiDomenskiObjekat> lista = new ArrayList();
        while (rs.next()) {
            Smena smena = new Smena(rs.getLong("idSmena"), rs.getTime("pocetak").toLocalTime(), rs.getTime("kraj").toLocalTime());
            lista.add(smena);
        }
        rs.close();
        return lista;
    }

    @Override
    public String getInsertValues() {
        return "(" + pocetak + ", " + kraj + ")";
    }

    @Override
    public String getColumnNames() {
        return "pocetak, kraj";
    }

    @Override
    public String getUpdateValues() {
        return "pocetak = "+pocetak+" kraj = "+kraj;
    }

    @Override
    public String getWhere() {
        return "idSmena="+idSmena;
    }

    @Override
    public String getSelectCondition() {
        String query="";
        if(idSmena!=0){
            query+=" AND idSmena="+idSmena;
        }
        if(pocetak!=null){
            query+=" AND pocetak="+pocetak;
        }
        if(kraj!=null){
            query+=" And kraj="+kraj;
        }
        return query;
    }

    @Override
    public String getJoinCondition() {
        return "";
    }

    @Override
    public String toString() {
        return String.valueOf(idSmena);
    }
        public boolean equals(Object obj) {
        if(!(obj instanceof Smena)){
            return false;
        }
        Smena x=(Smena)obj;
        if(idSmena==x.getIdSmena()){
            return true;
        }
        return false;
    }

    
}
