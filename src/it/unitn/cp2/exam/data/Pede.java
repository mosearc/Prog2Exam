package it.unitn.cp2.exam.data;

public class Pede {
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getJourney() {
        return journey;
    }

    public void setJourney(String journey) {
        this.journey = journey;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public int getVat() {
        return vat;
    }

    public void setVat(int vat) {
        this.vat = vat;
    }

    public Pede() {
        this.ID=0;
        this.journey="N/A";
        this.cost=0.0;
        this.vat=0;
    }

    protected int ID;
    protected String journey;
    protected double cost;
    protected int vat;

    public Pede(int ID, String journey, double cost, int vat) {
        this.ID = ID;
        this.journey = journey;
        this.cost = cost;
        this.vat = vat;
    }

    public String toString(){
        return String.format("id: %5d, Journey: %5s, baseprice: %5f, VAT: %5d ", this.getID(), this.getJourney(), this.getCost(), this.getVat());
    }

    public int compareTo(Pede o){
        return (this.getJourney().compareToIgnoreCase(o.journey));
    }

    public static int compare(int x, int y) {
        return x < y ? -1 : (x == y ? 0 : 1);
    }
    public static int compare(double x, double y) {
        return x < y ? -1 : (x == y ? 0 : 1);
    }

    public static void main(String[] args) {

    }


}
