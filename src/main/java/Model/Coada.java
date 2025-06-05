package Model;

import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Coada implements Runnable{
    private BlockingQueue<Client> clienti;

    public Coada(){
        this.clienti = new LinkedBlockingQueue<>();
    }

    public void addClient(Client newClient){
        this.clienti.add(newClient);
    }

    public boolean isEmpty(){
        if(this.clienti.isEmpty() == true)
            return true;
        return false;
    }

    public int timpCoada(){
        int timp = 0;
        for(Client c : clienti){
            timp += c.getServiceTime();
        }
        return timp;
    }

    public void print(FileWriter f) throws IOException {
        for(Client c : clienti){
            if(c.getServiceTime() > 0) {
                String s = "(" + c.getID() + ", " + c.getArrivalTime() + ", " + c.getServiceTime() + ")" + "\n";
                c.setServiceTime(c.getServiceTime() - 1);
                f.write(s);
            }
        }
    }

    @Override
    public void run() {

    }
}