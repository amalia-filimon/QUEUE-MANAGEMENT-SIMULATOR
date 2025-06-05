package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class SimulationFrame extends JFrame {

    private JPanel contentPane;
    private JLabel title;
    private JLabel nrClientsLbl;
    private JLabel nrQueuesLbl;
    private JLabel simIntervalLbl;
    private JLabel minArrivalTimeLbl;
    private JLabel maxArrivalTimeLbl;
    private JLabel minServiceTimeLbl;
    private JLabel maxServiceTimeLbl;
    private JTextField nrClientsTxtF;
    private JTextField nrQueuesTxtF;
    private JTextField simIntervalTxtF;
    private JTextField minArrivalTimeTxtF;
    private JTextField maxArrivalTimeTxtF;
    private JTextField minServiceTimeTxtF;
    private JTextField maxServiceTimeTxtF;
    private JButton startBtn;

    public SimulationFrame() {
        setTitle("Queues management application");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 700, 300);
        contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(null);
        contentPane.setBackground(Color.PINK);

        title = new JLabel("QUEUES MANAGEMENT APPLICATION");
        title.setFont(new Font("Tahoma", Font.BOLD, 20));
        title.setForeground(Color.RED);
        title.setBounds(170, 10, 400, 50);
        contentPane.add(title);

        nrClientsLbl = new JLabel("Number of clients: ");
        nrClientsLbl.setFont(new Font("Tahoma", Font.ITALIC, 15));
        nrClientsLbl.setForeground(Color.WHITE);
        nrClientsLbl.setBounds(150, 50, 150, 50);
        contentPane.add(nrClientsLbl);

        nrClientsTxtF = new JTextField();
        nrClientsTxtF.setBounds(300, 65, 200, 20);
        contentPane.add(nrClientsTxtF);

        nrQueuesLbl = new JLabel("Number of queues: ");
        nrQueuesLbl.setFont(new Font("Tahoma", Font.ITALIC, 15));
        nrQueuesLbl.setForeground(Color.WHITE);
        nrQueuesLbl.setBounds(150, 80, 150, 50);
        contentPane.add(nrQueuesLbl);

        nrQueuesTxtF = new JTextField();
        nrQueuesTxtF.setBounds(300, 95, 200, 20);
        contentPane.add(nrQueuesTxtF);

        simIntervalLbl = new JLabel("Simulation interval: ");
        simIntervalLbl.setFont(new Font("Tahoma", Font.ITALIC, 15));
        simIntervalLbl.setForeground(Color.WHITE);
        simIntervalLbl.setBounds(150, 110, 150, 50);
        contentPane.add(simIntervalLbl);

        simIntervalTxtF = new JTextField();
        simIntervalTxtF.setBounds(300, 125, 200, 20);
        contentPane.add(simIntervalTxtF);

        minArrivalTimeLbl = new JLabel("Minimum arrival time: ");
        minArrivalTimeLbl.setFont(new Font("Tahoma", Font.ITALIC, 15));
        minArrivalTimeLbl.setForeground(Color.WHITE);
        minArrivalTimeLbl.setBounds(30, 150, 180, 50);
        contentPane.add(minArrivalTimeLbl);

        minArrivalTimeTxtF = new JTextField();
        minArrivalTimeTxtF.setBounds(190, 165, 120, 20);
        contentPane.add(minArrivalTimeTxtF);

        maxArrivalTimeLbl = new JLabel("Maximum arrival time: ");
        maxArrivalTimeLbl.setFont(new Font("Tahoma", Font.ITALIC, 15));
        maxArrivalTimeLbl.setForeground(Color.WHITE);
        maxArrivalTimeLbl.setBounds(360, 150, 180, 50);
        contentPane.add(maxArrivalTimeLbl);

        maxArrivalTimeTxtF = new JTextField();
        maxArrivalTimeTxtF.setBounds(520, 165, 120, 20);
        contentPane.add(maxArrivalTimeTxtF);

        minServiceTimeLbl = new JLabel("Minimum service time: ");
        minServiceTimeLbl.setFont(new Font("Tahoma", Font.ITALIC, 15));
        minServiceTimeLbl.setForeground(Color.WHITE);
        minServiceTimeLbl.setBounds(30, 180, 180, 50);
        contentPane.add(minServiceTimeLbl);

        minServiceTimeTxtF = new JTextField();
        minServiceTimeTxtF.setBounds(190, 195, 120, 20);
        contentPane.add(minServiceTimeTxtF);

        maxServiceTimeLbl = new JLabel("Maximum service time: ");
        maxServiceTimeLbl.setFont(new Font("Tahoma", Font.ITALIC, 15));
        maxServiceTimeLbl.setForeground(Color.WHITE);
        maxServiceTimeLbl.setBounds(360, 180, 180, 50);
        contentPane.add(maxServiceTimeLbl);

        maxServiceTimeTxtF = new JTextField();
        maxServiceTimeTxtF.setBounds(520, 195, 120, 20);
        contentPane.add(maxServiceTimeTxtF);

        startBtn = new JButton("START");
        startBtn.setBounds(550, 80, 80, 20);
        contentPane.add(startBtn);
    }

    public int convertMinArrivalTime(){
        String minArrivalString = this.minArrivalTimeTxtF.getText();
        int minArrivalInt = Integer.parseInt(minArrivalString);
        return minArrivalInt;
    }

    public int convertMaxArrivalTime(){
        String maxArrivalString = this.maxArrivalTimeTxtF.getText();
        int maxArrivalInt = Integer.parseInt(maxArrivalString);
        return maxArrivalInt;
    }

    public int convertMinServiceTime(){
        String minServiceString = this.minServiceTimeTxtF.getText();
        int minServiceInt = Integer.parseInt(minServiceString);
        return minServiceInt;
    }

    public int convertMaxServiceTime(){
        String maxServiceString = this.maxServiceTimeTxtF.getText();
        int maxServiceInt = Integer.parseInt(maxServiceString);
        return maxServiceInt;
    }

    public int convertNrClients(){
        String nrClientsString = this.nrClientsTxtF.getText();
        int nrClientsInt = Integer.parseInt(nrClientsString);
        return nrClientsInt;
    }

    public int convertNrQueues(){
        String nrQueuesString = this.nrQueuesTxtF.getText();
        int nrQueuesInt = Integer.parseInt(nrQueuesString);
        return nrQueuesInt;
    }

    public int convertSimulationTime(){
        String simulationString = this.simIntervalTxtF.getText();
        int simulationInt = Integer.parseInt(simulationString);
        return simulationInt;
    }

    public void addStartBtnActionListener(ActionListener action){
        this.startBtn.addActionListener(action);
    }

}