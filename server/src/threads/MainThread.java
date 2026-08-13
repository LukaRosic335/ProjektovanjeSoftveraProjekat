/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package threads;

import java.io.IOException;
import java.net.ServerSocket;

/**
 *
 * @author jevrozim
 */
public class MainThread extends Thread{
    private ServerSocket socket;

    public MainThread() {
        try {
            socket=new ServerSocket(7259);
        } catch (IOException ex) {
            System.getLogger(MainThread.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
    }
    
    
    
    @Override
    public void run() {
        while(!socket.isClosed()){
            //nesto .accept()
        }
    }
    
}
