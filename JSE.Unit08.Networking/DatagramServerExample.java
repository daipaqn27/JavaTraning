/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package techmatter.lab8;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PA
 */
public class DatagramServerExample implements Runnable{
    DatagramSocket socket;
    public DatagramServerExample() throws SocketException{
        socket = new DatagramSocket(4455);
        System.out.println("Data server listening...");
    }

    @Override
    public void run() {
        try{
            byte bytes[] = new byte[1024];
            DatagramPacket packet = new DatagramPacket(bytes, bytes.length);
            socket.receive(packet);
            System.out.println("From Client: " 
                    + new String(packet.getData(), 0, packet.getLength()));
            
            bytes = "Server say hello".getBytes();
            socket.send(new DatagramPacket(bytes, bytes.length
                    , packet.getAddress(), packet.getPort()));
        } catch (IOException ex) {
            ex.printStackTrace();
        }finally{
            socket.close();
        }
    }
    
    public static void main(String[] args) throws SocketException {
        new Thread(new DatagramServerExample()).start();
    }
}
