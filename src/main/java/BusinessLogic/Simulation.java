package BusinessLogic;

import GUI.SimulationFrame;
import Model.Client;
import Model.Coada;

import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Simulation implements Runnable{

    private List<Client> clienti;
    private List<Coada> colectieCozi;
    private SimulationFrame frame;
    private FileWriter fw;
    private int nrClienti;
    private int nrCozi;
    private int minArrivalT;
    private int maxArrivalT;
    private int minServiceT;
    private int maxServiceT;
    private int simulationT;

    public Simulation(SimulationFrame frame) throws IOException {
        this.frame = frame;
        this.fw = new FileWriter("logOfEvents.txt");
        this.nrClienti = frame.convertNrClients();
        this.nrCozi = frame.convertNrQueues();
        this.minArrivalT = frame.convertMinArrivalTime();
        this.maxArrivalT = frame.convertMaxArrivalTime();
        this.minServiceT = frame.convertMinServiceTime();
        this.maxServiceT = frame.convertMaxServiceTime();
        this.simulationT = frame.convertSimulationTime();
        this.colectieCozi = new ArrayList<>();
        this.clienti = new ArrayList<>();
        this.clienti = this.generateRandomClients(nrClienti, minArrivalT, maxArrivalT, minServiceT, maxServiceT);
    }

    public List<Client> generateRandomClients(int nrClienti, int minArrivalT, int maxArrivalT, int minServiceT, int maxServiceT) {

        int idTask, arrivalT, serviceT;

        for(int i = 0; i < nrClienti; i++){
            idTask = i + 1;
            arrivalT = (int) (Math.random()*(maxArrivalT - minArrivalT + 1) + minArrivalT);
            serviceT = (int)(Math.random()*(maxServiceT - minServiceT + 1) + minServiceT);

            Client t = new Client(idTask, arrivalT, serviceT);

            this.clienti.add(t);
            Collections.sort(clienti);
        }

        return clienti;
    }

    public void printCoada(Coada c, FileWriter f) throws IOException {
        c.print(f);
    }

    public Coada timpCoadaMinim(List<Coada> cozi) {
        int minim = 1000;
        Coada coada = new Coada();
        for (Coada c : cozi) {
            if (c.timpCoada() <= minim) {
                minim = c.timpCoada();
                coada = c;
            }
        }
        return coada;
    }

    public void init(){
        for (int i = 0; i < this.nrCozi; i++) {
            Coada c = new Coada();
            colectieCozi.add(c);
            Thread t = new Thread(c);
            t.start();
        }
    }

    @Override
    public void run() {
        init();
        try {
            int currentTime = 0, clientiIntrodusi = 0, j = 1;
            while (currentTime < simulationT) {
                for (int i = clientiIntrodusi; i < this.nrClienti; i++) {
                    if (clienti.get(i).getArrivalTime() == currentTime) {
                        Coada c = this.timpCoadaMinim(colectieCozi);
                        c.addClient(clienti.get(i));
                        clientiIntrodusi++;
                    } else break;
                }
                fw.write("Time: " + currentTime + "\n" + "Waiting clients: " + "\n");
            for (int i = clientiIntrodusi; i < this.nrClienti; i++) {
                fw.write("(" + clienti.get(i).getID() + ", " + clienti.get(i).getArrivalTime() + ", " + clienti.get(i).getServiceTime() + ")" + "\n");
            }
            for (Coada c : colectieCozi) {
                if (c.isEmpty() == true)
                    fw.write("Queue " + j + ": closed" + "\n");
                else {
                    fw.write("Queue " + j + ": " + "\n");
                    printCoada(c, fw);
                }
                if(j < this.nrCozi) j++;
                else j = 1;
            }
            fw.write("\n");
            currentTime++;
        }
    }catch(Exception e){}
        try { this.fw.close(); } catch (IOException e) {}
    }

    public static void main(String[] args){
        SimulationFrame frame = new SimulationFrame();
        Controller c = new Controller(frame);
        frame.setVisible(true);

    }
}