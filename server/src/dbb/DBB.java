/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dbb;

import java.sql.*;
import java.util.ArrayList;
import domain.OpstiDomenskiObjekat;

/**
 *
 * @author jevrozim
 */
public class DBB {

    private static Connection connection;
    private static DBB instance;

    private DBB() {
        try {
            //NIJE GOTOVO NISAM SIGURAN DA TREBA OVAKO
            //autocommit resavanje problema
            if (connection != null) {
                connection.setAutoCommit(false);
            }
        } catch (SQLException ex) {
            System.out.println("Iz nekog razloga ne radi iskljucivanje autocommita");
        }
    }

    //PROVERICU DA LI TREBA 
    public static Connection getConnection() {
        return connection;
    }

    public static void setConnection(Connection connection) {
        DBB.connection = connection;
    }

    public static DBB getInstance() {
        if (instance == null) {
            instance = new DBB();
        }
        return instance;
    }

    //TRENUTNO BACAJU SQL Izuzetke sve CRUD operacije
    public ArrayList<OpstiDomenskiObjekat> select(OpstiDomenskiObjekat odo) throws SQLException {
        String query = "SELECT * FROM " + odo.getTableName() + ";";
        System.out.println(query);
        Statement s = connection.createStatement();
        ResultSet rs = s.executeQuery(query);
        return odo.vratiListu(rs);
    }

    //Trenutno insert vraca PS kao tip podatka jos uvek nisam siguran da li mi se to svidja
    public PreparedStatement insert(OpstiDomenskiObjekat odo) throws SQLException {
        String query = "INSERT INTO " + odo.getTableName() + " (" + odo.getColumnNames() + ") VALUES " + odo.getInsertValues() + ";";
        System.out.println(query);
        PreparedStatement ps = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        ps.executeUpdate();
        return ps;
    }

    public void update(OpstiDomenskiObjekat odo) throws SQLException {
        String query = "UPDATE " + odo.getTableName() + " SET " + odo.getUpdateValues() + " WHERE " + odo.getWhere() + ";";
        System.out.println(query);
        Statement s = connection.createStatement();
        s.executeUpdate(query);
    }

    public void delete(OpstiDomenskiObjekat odo) throws SQLException {
        String query = "DELETE FROM " + odo.getTableName() + "WHERE " + odo.getWhere() + ";";
        System.out.println(query);
        Statement s = connection.createStatement();
        s.executeUpdate(query);
    }

    //OVO NE TREBA DA VRACCA boolean TREBA DA BUDU NE STATICKE METODE KOJIMA SE JEDNOM USPOSTAVLJA VEZA SA BAZOM I TJT
    public boolean connect(String adresa, String port, String imeBaze, String ussername, String password) {
        connection = null;
        String url = "jdbc:mysql://" + adresa + ":" + port + "/" + imeBaze;
        try {
            connection = DriverManager.getConnection(url, ussername, password);
            System.out.println("Uspesno uspostavljena konekcija");
            connection.setAutoCommit(false);
            return true;
        } catch (SQLException ex) {
            System.out.println("Neuspesno uspostavljanje konekcije " + ex.getMessage());
            return false;
        }
    }

    public boolean disconnect() {
        try {
            if (connection != null && !connection.isClosed()) {
                System.out.println("Konekcija uspesno zatvorena");
                connection.close();
                return true;
            } else {
                System.out.println("konekcija nikad nije bila uspostavljena");
                return true;
            }
        } catch (SQLException ex) {
            System.out.println("Konekcija neuspesno zatvorena " + ex.getMessage());
            return false;
        }
    }

}
