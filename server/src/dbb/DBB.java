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

    private DBB() {//NIJE GOTOVO NISAM SIGURAN DA TREBA OVAKO
    }
    //PROVERICU DA LI TREBA 
    public static Connection getConnection() {
        return connection;
    }

    public static void setConnection(Connection connection) {
        DBB.connection = connection;
    }

    public static DBB getInstance() {
        if(instance==null){
            instance=new DBB();
        }
        return instance;
    }

   
    public ArrayList<OpstiDomenskiObjekat> select(OpstiDomenskiObjekat odo){
        String upit="SELECT * FROM "+odo.getTableName();
        return null;
    }
    public void insert(){
        
    }
    public void update(){
        
    }
    public void delete(){
        
    }
    
    public static boolean connect(String adresa,String port,String imeBaze,String ussername,String password){
        connection=null;
        String url="jdbc:mysql://"+adresa+":"+port+"/"+imeBaze;
        try{
            connection=DriverManager.getConnection(url, ussername, password);
            System.out.println("Uspesno uspostavljena konekcija");
            return true;
        }catch(SQLException ex){
            System.out.println("Neuspesno uspostavljanje konekcije "+ex);
            return false;
        }
    }
    public static boolean disconnect(){
        try{
            if(connection!=null&&!connection.isClosed()){
                System.out.println("Konekcija uspesno zatvorena");
                connection.close();
                return true;
            }else{
                System.out.println("konekcija nikad nije bila uspostavljena");
                return true;
            }
        }catch(SQLException ex){
            System.out.println("Konekcija neuspesno zatvorena "+ex);
            return false;
        }
    }
    
    
//    private static void connect() {
//        connection = null;
//        String url = "jdbc:mysql://localhost:3306/klk1";
//        try {
//            connection = DriverManager.getConnection(url, "root", "");
//            System.out.println("imamo konekciju");
//        } catch (SQLException ex) {
//            System.out.println("NEMAMO KONEKCIJU " + ex);
//        }
//    }
//
//    private static void disconnect() {
//        try {
//            if (connection != null && !connection.isClosed()) {
//                System.out.println("zatvorena konekcija");
//                connection.close();
//            }
//        } catch (SQLException ex) {
//            System.out.println("NEUSPESNO ZATVORENA KONEKCIJA " + ex);
//        }
//    }
}
