package it.unitn.cp2.exam.data;

public class Bikem extends Pede {
    public int getMaxW() {
        return maxW;
    }

    public void setMaxW(int maxW) {
        this.maxW = maxW;
    }

    public Bikem(){
        super();
        this.maxW=0;
    }

    public Bikem(int maxW) {
        this.maxW = maxW;
    }

    public Bikem(int ID, String journey, double cost, int vat, int maxW) {
        super(ID, journey, cost, vat);
        this.maxW = maxW;
    }

    protected int maxW;

    public String toString(){
        return String.format("bikem id: %5d, Journey: %5s, baseprice: %5f, VAT: %5d, PesoMax: %5d ", this.getID(), this.getJourney(), this.getCost(), this.getVat(), this.getMaxW());
    }

    public static void main(String[] args) {

    }

}
