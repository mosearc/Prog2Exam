package it.unitn.cp2.exam.model;

import it.unitn.cp2.exam.data.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class ReadFile {
    List<Pede> catalog;

    public ReadFile(String s) {
        catalog = new ArrayList<Pede>();
        try {
            read(catalog, s);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ReadFile() {
        catalog = new ArrayList<Pede>();
    }

    public String toString() {
        String s = " ";
        for (Pede b :
                catalog) {
            s += b + "\n";
        }
        return s;
    }

    public Pede find(int id) {
        for (Pede b : catalog) {
            if (b.getID() == id) {
                return b;
            }
        }
        return null;
    }








    public void read(List<Pede> ctl, String csvFilePath) throws Exception {
        String line = null;
        BufferedReader bufferedReader = null;
        try {
            String path = new File(csvFilePath).getAbsolutePath();
            File csvFile = new File(path);
            FileReader fileReader = new FileReader(csvFile);
            bufferedReader = new BufferedReader(fileReader);

            while ((line = bufferedReader.readLine()) != null) {
                String[] csvLineElements = line.split(",");

                for (int i = 0; i < csvLineElements.length; i++) {
                    csvLineElements[i] = csvLineElements[i].trim();
                }

                System.out.println("");
                if(csvLineElements.length==4){
                    Pede nb;
                    int id = (int) Integer.parseInt(csvLineElements[0]);
                    double bp = (double) Double.parseDouble(csvLineElements[2]);
                    int v = (int) Integer.parseInt(csvLineElements[3]);
                    nb=new Pede(id, csvLineElements[1], bp, v);
                    ctl.add(nb);

                }else if(csvLineElements.length==5){
                    int id = (int) Integer.parseInt(csvLineElements[0]);
                    double bp = (double) Double.parseDouble(csvLineElements[2]);
                    int v = (int) Integer.parseInt(csvLineElements[3]);
                    int m = (int) Integer.parseInt(csvLineElements[4]);

                    if(id>=200 && id<300){
                        Bikem nb=new Bikem(id, csvLineElements[1], bp, v, m);
                        ctl.add(nb);
                    }else{
                        Vehicle nb = new Vehicle(id, csvLineElements[1], bp, v, m);
                        ctl.add(nb);
                    }

                }
            }
        }catch (IOException e){
            System.out.println("Error Occured while parsing csv file.");
            e.printStackTrace();
        }
        catch (NumberFormatException e){
            System.out.println("Error Occured while parsing csv file numberformat");
            e.printStackTrace();
        }
        finally {
            bufferedReader.close();
        }
    }

    public static void main(String[] args) {
        ReadFile r = new ReadFile("src/it/unitn/cp2/exam/file/tickets.txt");

        System.out.println("\nIteration through the list with Efor");
        System.out.println(r);

    }

}
