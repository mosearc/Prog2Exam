package it.unitn.cp2.exam.data;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Sell {



    public Pede getP() {
        return p;
    }

    public void setP(Pede p) {
        this.p = p;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public LocalDateTime getDataVendita() {
        return dataVendita;
    }

    public void setDataVendita(LocalDateTime dataVendita) {
        this.dataVendita = dataVendita;
    }



    public int getAxsCost() {
        return axsCost;
    }

    public void setAxsCost(int axsCost) {
        this.axsCost = axsCost;
    }

    public int getAxes() {
        return axes;
    }

    public void setAxes(int axes) {
        this.axes = axes;
    }

    public LocalDateTime getDataPartenza() {
        return dataPartenza;
    }

    public void setDataPartenza(LocalDateTime dataPartenza) {
        this.dataPartenza = dataPartenza;
    }

    public int getVAT() {
        return VAT;
    }

    public void setVAT(int VAT) {
        this.VAT = VAT;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getDesc() {
        return Desc;
    }

    public void setDesc(String desc) {
        Desc = desc;
    }

    protected int ID;
    protected String Desc;
    protected int VAT;
    protected LocalDateTime dataPartenza;
    protected int axes;
    protected int axsCost;
    protected double price;
    protected LocalDateTime dataVendita;
    protected Pede p;

    public Sell() {
        this.dataVendita=LocalDateTime.now();
        this.p=new Pede();
    }


    public Sell(Pede p, LocalDateTime ldt){
        this.p=p;
        this.dataVendita=LocalDateTime.now();
        this.dataPartenza=ldt;
        this.VAT=p.vat;
        this.ID=p.ID;
        this.Desc=p.journey;
    }

    public Sell(Pede p, String ldt){
        this.p=p;
        this.dataVendita=LocalDateTime.now();
        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("yyyy.MM.dd HH.mm"); //string to date ("yyyy.MM.dd HH.mm" è com'è composta la stringa)
        LocalDateTime dateTime = LocalDateTime.parse(ldt, inputFormatter);
        this.dataPartenza=dateTime;
        this.VAT=p.vat;
        this.ID=p.ID;
        this.Desc=p.journey;
    }


    public Sell(Pede p, LocalDateTime ldt, int a, int ax){ //costruttore per veicoli
        this.axsCost=a;
        this.p=p;
        this.dataVendita=LocalDateTime.now();
        this.dataPartenza=ldt;
        this.axes=ax;
        this.VAT=p.vat;
        this.ID=p.ID;
        this.Desc=p.journey;
    }

    public Sell(Pede p, String ldt, int a, int ax){ //costruttore per veicoli
        this.axsCost=a;
        this.p=p;
        this.dataVendita=LocalDateTime.now();
        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("yyyy.MM.dd HH.mm"); //string to date ("yyyy.MM.dd HH.mm" è com'è composta la stringa)
        LocalDateTime dateTime = LocalDateTime.parse(ldt, inputFormatter);
        this.dataPartenza=dateTime;
        this.axes=ax;
        this.VAT=p.vat;
        this.ID=p.ID;
        this.Desc=p.journey;
    }

    public String toString(){
        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("yyyy.MM.dd HH.mm"); //date to string ("yyyy.MM.dd HH.mm" è com'è composta la stringa)
        String outputDateString = this.getDataPartenza().format(outputFormatter);
        String outputDateStringP = this.getDataPartenza().format(outputFormatter);
        return String.format("ID: %5d, Desc: %5s, Costot: %5f, Venduto il: %5s, Partenza: %5s", this.getID(), this.getDesc(), calcPrice(), outputDateString, outputDateStringP);
    }

    public double calcPrice(){
        double bp = p.getCost();

        float discount;

        long seconds = Duration.between(getDataVendita(), getDataPartenza()).toSeconds();
        long m = seconds/60;
        long h = m/60;
        long d = h/60;
        if(d<5){
            discount=0;
        }else if (d<30){
            d=d-5;
            discount= (float) d /100;
        }else {
            discount= (float) 31 /100;
        }

        if(p.ID>=100 && p.ID<200){ //pede
            bp=bp-bp*discount;
            bp=bp+bp*p.getVat()/100;
        }
        if(p.ID>=200 && p.ID <300){ //bike
            bp=bp-bp*discount;
            bp=bp+bp*p.getVat()/100;
        }
        if(p.ID>=300 && p.ID<400){ //vehicle
            if(axes==2){
                bp=bp-bp*discount;
                bp=bp+bp*p.getVat()/100;
            }else {
                bp=bp + getAxsCost()*getAxes();
                bp=bp-bp*discount;
                bp=bp+bp*p.getVat()/100;
            }
        }
        return bp;
    }

    public static void main(String[] args) {

    }


}
