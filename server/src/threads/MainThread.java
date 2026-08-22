/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package threads;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

/**
 *
 * @author jevrozim
 */
public class MainThread extends Thread{
    private ServerSocket serverSocket;
    private ArrayList<ClientHandler> clientHandlers;

    public MainThread() {
        try {
            serverSocket=new ServerSocket(7259);
        } catch (IOException ex) {
//            System.getLogger(MainThread.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
            System.out.println("Problem pri kreiranju server soketa");
        }
    }
    
    public ServerSocket getServerSocket(){
        return serverSocket;
    }
    
    @Override
    public void run() {
        while(!serverSocket.isClosed()){
            try {
                System.out.println("Cekanje klijenta...");
                Socket socket= serverSocket.accept();
                ClientHandler clientHandler=new ClientHandler(socket);//onde moras da pravis konstruktor za klijent hendlera
                clientHandlers.add(clientHandler);//mora da ga sklonis po logoutu
                
                clientHandler.start();
            } catch (IOException ex) {
                System.out.println("server soket nije povezan "+ex.getMessage());
            }
            
        }
    }
    
    public void death(){
        //OBAVESTI SVE KLIJENT HENDLERE DA VEZA UMIRE
                for(ClientHandler c:clientHandlers){
                    try {
                        c.kill();
                    } catch (IOException ex) {//TRENUTNO RESENJE OVOG PROBLEMA
                        System.out.println("Neuspelo ubijanje nekog klijent hendlera "+ex.getMessage());
                    }
                }
        try {
            serverSocket.close();
        } catch (IOException ex) {//TRENURNO RESENJE
            System.out.println("Neuspelo zatvaranje server soketa "+ex.getMessage());
        }
    }
}
