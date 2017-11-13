/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package techmatter.lab8;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author PA
 */
public interface Hello extends Remote{
    String say(String name) throws RemoteException;
}
