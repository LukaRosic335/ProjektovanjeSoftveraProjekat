/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package threads;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author jevrozim
 */
public class MainThread extends Thread{
    private ServerSocket serverSocket;

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
                clientHandler.start();
            } catch (IOException ex) {
                System.out.println("server soket nije povezan "+ex.getMessage());
            }
        }
    }
    
}
