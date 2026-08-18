/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author jevrozim
 */
public abstract class OpstiDomenskiObjekat implements Serializable{

    //ovde se svasta savade
    public abstract String getTableName();
    public abstract ArrayList<OpstiDomenskiObjekat> vratiListu(ResultSet rs) throws SQLException;
}
