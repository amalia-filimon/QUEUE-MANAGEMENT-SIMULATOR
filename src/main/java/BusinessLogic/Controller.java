package BusinessLogic;

import GUI.SimulationFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Controller {
    SimulationFrame frame;


    public Controller(SimulationFrame frame){
        this.frame = frame;
        this.frame.addStartBtnActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                Simulation s = null;
                try {
                    s = new Simulation(frame);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                Thread t = new Thread(s);
                t.start();
            }
        });
    }
}
