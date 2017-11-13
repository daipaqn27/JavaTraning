/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package techmatter.lab9;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

/**
 *
 * @author PA
 */
public interface WindowClosing extends WindowListener{

    @Override
    public default void windowOpened(WindowEvent e) {}

    @Override
    public default void windowClosing(WindowEvent e) {}

    @Override
    public default void windowClosed(WindowEvent e) {}

    @Override
    public default void windowIconified(WindowEvent e) {}

    @Override
    public default void windowDeiconified(WindowEvent e) {}

    @Override
    public default void windowActivated(WindowEvent e) {}

    @Override
    public default void windowDeactivated(WindowEvent e) {}
    
}
