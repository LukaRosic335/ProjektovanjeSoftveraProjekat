/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 *
 * @author jevrozim
 */
public class Smena extends OpstiDomenskiObjekat {

    private long idSmena;
    private LocalDateTime pocetak;
    private LocalDateTime kraj;

    public Smena(long idSmena, LocalDateTime pocetak, LocalDateTime kraj) {
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

    public LocalDateTime getPocetak() {
        return pocetak;
    }

    public void setPocetak(LocalDateTime pocetak) {
        this.pocetak = pocetak;
    }

    public LocalDateTime getKraj() {
        return kraj;
    }

    public void setKraj(LocalDateTime kraj) {
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
            Smena smena = new Smena(rs.getLong("idSmena"), rs.getTimestamp("pocetak").toLocalDateTime(), rs.getTimestamp("kraj").toLocalDateTime());
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
            query+=idSmena;
        }
        if(pocetak!=null){
            query+=pocetak;
        }
        if(kraj!=null){
            query+=kraj;
        }
        return query;
    }

    @Override
    public String getJoinCondition() {
        return "";
    }
    

}
