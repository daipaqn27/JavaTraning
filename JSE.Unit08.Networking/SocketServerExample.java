/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package techmatter.lab8;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author PA
 */
public class SocketServerExample {

    public SocketServerExample(int serverPort) throws IOException {
        ServerSocket serverSocket = new ServerSocket(serverPort);
        System.out.println("SERVER Listening...");
        while (true) {
            Socket s = serverSocket.accept();
            new Thread(() -> {
                try {
                    DataInputStream input = new DataInputStream(s.getInputStream());
                    DataOutputStream output = new DataOutputStream(s.getOutputStream());

                    System.out.println("Client Say: " + input.readUTF());
                    output.writeUTF("I'm a socket server!");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }

    public static void main(String[] args) throws IOException {
        new SocketServerExample(9245);
    }
}
