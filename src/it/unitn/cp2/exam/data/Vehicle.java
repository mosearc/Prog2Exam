package it.unitn.cp2.exam.data;

public class Vehicle extends Pede{
    public int getAxeCost() {
        return axeCost;
    }

    public void setAxeCost(int axeCost) {
        this.axeCost = axeCost;
    }

    public Vehicle(){
        super();
        this.axeCost=0;
    }

    public Vehicle(int axeCost) {
        this.axeCost = axeCost;
    }

    public Vehicle(int ID, String journey, double cost, int vat, int axeCost) {
        super(ID, journey, cost, vat);
        this.axeCost = axeCost;
    }

    protected int axeCost;

    public String toString(){
        return String.format("vehicle id: %5d, Journey: %5s, baseprice: %5f, VAT: %5d, CostoAxe: %5d ", this.getID(), this.getJourney(), this.getCost(), this.getVat(), this.getAxeCost());
    }
}
