package it.unitn.cp2.exam.model;

import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import it.unitn.cp2.exam.data.Sell;

public class Sells {
    List<Sell> sells;
    public Sells(){
        sells = new ArrayList<Sell>();
    }

    public void add(Sell v){
        sells.add(v);
    }

    public void sortByDesc(){ //asc o1-o2
        Collections.sort(sells, new Comparator<Sell>() {
            @Override
            public int compare(Sell o1, Sell o2) {
                return (int) (o1.getDesc().compareToIgnoreCase(o2.getDesc()));
            }
        });

    }

    public void sortByCost(){ //descending o2-o1
        Collections.sort(sells, new Comparator<Sell>() {
            @Override
            public int compare(Sell o1, Sell o2) {
                return (int) (o2.calcPrice()-o1.calcPrice());
            }
        });


    }

    public void sortByPDate(){ //ascending


        Collections.sort(sells, new Comparator<Sell>() {
            @Override
            public int compare(Sell o1, Sell o2) {

                long seconds = ChronoUnit.SECONDS.between(o1.getDataPartenza(), o2.getDataPartenza());
                return (int) seconds;
                //return (int) (o1.getDataPartenza().getSecond()-o2.getDataPartenza().getSecond());
            }
        });

    }

    public void sortByCostDateP(){ //desc
        Collections.sort(sells, new Comparator<Sell>() {
            @Override
            public int compare(Sell o1, Sell o2) {
                int g = (int) (o1.calcPrice()-o2.calcPrice());
                if(g != 0){
                    return g;
                }
                return (int) (o1.getDataPartenza().getSecond()-o2.getDataPartenza().getSecond());
            }
        });
    }

    public String toString(){
        String s = "";
        for (Sell v:
                sells) {
            s += v +"\n";
        }
        return s;
    }



}
