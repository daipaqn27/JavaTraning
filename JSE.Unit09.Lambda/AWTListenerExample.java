/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package techmatter.lab9;

import java.awt.Button;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JOptionPane;

/**
 *
 * @author PA
 */
public class AWTListenerExample {
    public static void main(String[] args) {
        Frame frame = new Frame();
        
        frame.addWindowListener(new WindowClosing(){
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(1);
            }
            
        });
        
        Button button = new Button("Press me");
        frame.add(button);
        
        button.addActionListener(e -> {
                JOptionPane.showMessageDialog(null, "WellCome example",
                        "Java Sample", JOptionPane.INFORMATION_MESSAGE);
//            }
        });
        frame.setSize(250, 400);
        frame.setVisible(true);
    }
}
