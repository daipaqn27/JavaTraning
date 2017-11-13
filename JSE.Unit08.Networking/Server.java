/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package techmatter.lab8;

import java.rmi.AlreadyBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PA
 */
class Server implements Hello{

    @Override
    public String say(String name) throws RemoteException {
        return "Hello: " + name;
    }
    
    public static void main(String[] args) throws AlreadyBoundException {
        System.setProperty("java.rmi.server.hostname", "127.0.0.1");
        Server obj = new Server();
        try {
            Hello stub = (Hello) UnicastRemoteObject.exportObject(obj, 0);
            
            LocateRegistry.getRegistry("127.0.0.1", 8000).bind("hello", stub);
            
            System.out.println("Server ready");
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }
    }
}
