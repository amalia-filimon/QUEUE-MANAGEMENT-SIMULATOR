package Model;

public class Client implements Comparable<Client>{
    private int ID;
    private int arrivalTime;
    private int serviceTime;

    public Client(int ID, int arrivalT, int serviceT){
        this.ID = ID;
        this.arrivalTime = arrivalT;
        this.serviceTime = serviceT;
    }

    public int getID() {
        return ID;
    }

    public int getArrivalTime() {
        return arrivalTime;
    }

    public int getServiceTime() {
        return serviceTime;
    }

    public void setServiceTime(int serviceTime) {
        this.serviceTime = serviceTime;
    }

    @Override
    public int compareTo(Client o) {
        return this.arrivalTime - o.arrivalTime;
    }

    public String toString(){
        return "(" + this.getID() + ", " + this.getArrivalTime() + ", " + this.getServiceTime() + ")";
    }
}