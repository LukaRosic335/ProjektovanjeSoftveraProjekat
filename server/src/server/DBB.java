/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package server;

import java.sql.*;

/**
 *
 * @author jevrozim
 */
public class DBB {
    
    private static Connection connection;
    
    public static void connect(String adresa,String port,String imeBaze,String ussername,String password){
        connection=null;
        String url="jdbc:mysql://"+adresa+":"+port+"/"+imeBaze;
        try{
            connection=DriverManager.getConnection(url, ussername, password);
            System.out.println("Uspesno uspostavljena konekcija");
        }catch(SQLException ex){
            System.out.println("Neuspesno uspostavljanje konekcije "+ex);
        }
    }
    public static void disconnect(){
        try{
            if(connection!=null&&!connection.isClosed()){
                System.out.println("Konekcija uspesno zatvorena");
                connection.close();
            }else{
                System.out.println("konekcija nikad nije bila uspostavljena");
            }
        }catch(SQLException ex){
            System.out.println("Konekcija neuspesno zatvorena "+ex);
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
