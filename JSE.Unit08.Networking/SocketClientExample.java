/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package techmatter.lab8;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 *
 * @author PA
 */
public class SocketClientExample {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 9245);
        System.out.println("Client start sending...");
        try{
            DataInputStream input = new DataInputStream(socket.getInputStream());
            DataOutputStream os = new DataOutputStream(socket.getOutputStream());
            
            os.writeUTF("Hello Server");
            System.out.println("Server Say: " + input.readUTF());
        }finally{
            socket.close();
        }
    }
}
