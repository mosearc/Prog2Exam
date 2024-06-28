package it.unitn.cp2.exam.view;

import it.unitn.cp2.exam.data.*;
import it.unitn.cp2.exam.model.*;
import it.unitn.cp2.exam.view.*;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

public class GUI extends Application {

    Button exit;
    Button getCatalog;
    TextArea taCatalog;
    ReadFile myStore = new ReadFile();
    Tab catalogTab;

    Button sell;
    TextField tfId;
    TextField tfNumber;
    TextField tfDate;
    TextArea taSell;
    Tab sellTab;
    Label IdLabel;
    Label NumberLabel;
    Label DateLabel;
    TextArea taRecipt;
    Label ReciptLabel;

    Sells allV = new Sells();
    Button getSells;
    Button sortDesc;
    Button sortCost;
    Button sortDate;
    Button sortDue;
    Tab Sells;


    @Override
    public void start(Stage stage) throws Exception {
        exit = new Button("Exit");
        exit.setOnAction(e->exitApp(stage));

        getCatalog = new Button("ReadCatalog");
        getCatalog.setOnAction(e->read());

        taCatalog = new TextArea();
        taCatalog.setEditable(false);

        catalogTab = new Tab("catalog");

        HBox hbCtalog = new HBox(10, getCatalog);
        VBox vbCatalog = new VBox(5, taCatalog, hbCtalog);

        HBox hbGeneral = new HBox(exit);

        catalogTab.setContent(vbCatalog);






        sell = new Button("sell");
        sell.setOnAction(e->sell());

        IdLabel = new Label("ID: ");
        NumberLabel = new Label("Axes: ");
        DateLabel = new Label("Date and Time (yyyy.MM.dd HH.mm): ");
        ReciptLabel = new Label("RECIPT: ");

        tfId = new TextField();
        tfNumber = new TextField();
        tfDate = new TextField();
        taRecipt = new TextArea();
        taRecipt.setEditable(false);

        sellTab = new Tab("recipt");

        HBox hbSells = new HBox(10, IdLabel, tfId, DateLabel, tfDate ,NumberLabel, tfNumber, sell);
        VBox vbSells = new VBox(5, taRecipt, hbSells);

        sellTab.setContent(vbSells);







        taSell = new TextArea();
        taSell.setEditable(false);

        getSells = new Button("getSells");
        getSells.setOnAction(e->getAllVendite());

        sortCost = new Button("sortByCost");
        sortCost.setOnAction(e->sortC());

        sortDesc = new Button("sortByDescript");
        sortDesc.setOnAction(e->sortD());

        sortDate = new Button("sortByDate");
        sortDate.setOnAction(e->sortDt());

        sortDue = new Button("sortByCost+Date");
        sortDue.setOnAction(e->sortDu());

        Sells = new Tab("sells");

        HBox hbSI = new HBox(10, getSells, sortDesc, sortDate, sortCost, sortDue);
        VBox vbSI = new VBox(10, taSell, hbSI);

        Sells.setContent(vbSI);





        BorderPane root = new BorderPane();

        TabPane tabPane = new TabPane(catalogTab, sellTab, Sells);

        root.setCenter(tabPane);
        root.setBottom(hbGeneral);

        Scene scene = new Scene(root, 640, 340);

        stage.setTitle("Shop");
        stage.setScene(scene);
        stage.show();


    }

    private void exitApp(Stage stg){
        boolean confirm = false;
        confirm = ExitConfirm.show("Are you sure you want to quit?", "Confirmation");
        if(confirm){
            stg.close();
        }
    }

    private void read(){
        taCatalog.clear();
        myStore = new ReadFile("src/it/unitn/cp2/exam/file/tickets.txt");
        taCatalog.appendText(myStore.toString());
    }

    private void sell(){
        String stId = tfId.getText();
        String stdN = tfNumber.getText();
        String stDat = tfDate.getText();

        int myId = Integer.parseInt(stId);
        int myN = Integer.parseInt(stdN);
        Sell v;

        if(myId>=100 && myId<200){
            Pede p = myStore.find(myId);
            v = new Sell(p, stDat);
            allV.add(v);
            taRecipt.clear();
            taRecipt.appendText("Comprato il: " + v.getDataVendita() + "\n Partenza il: " + v.getDataPartenza() + "\n Prezzo: " + v.calcPrice() + "\n Description: " + v.getDesc());

        }else if(myId>=200 && myId<300){
            Pede p = myStore.find(myId);
            v = new Sell(p, stDat);
            allV.add(v);
            taRecipt.clear();
            taRecipt.appendText("Comprato il: " + v.getDataVendita() + "\n Partenza il: " + v.getDataPartenza() + "\n Prezzo: " + v.calcPrice() + "\n Description: " + v.getDesc());

        }else if(myId>=300 && myId<400){
            Pede p = myStore.find(myId);
            v = new Sell(p, stDat, 50, myN);
            allV.add(v);
            taRecipt.clear();
            taRecipt.appendText("Comprato il: " + v.getDataVendita() + "\n Partenza il: " + v.getDataPartenza() + "\n Prezzo: " + v.calcPrice() +"\n Axes: "+ v.getAxes() +"\n Desription: " + v.getDesc());
        }
    }

    public void getAllVendite(){
        taSell.clear();
        taSell.appendText(allV.toString());
    }

    public void sortD(){
        allV.sortByDesc();
        taSell.clear();
        taSell.appendText(allV.toString());
    }

    public void sortC(){
        allV.sortByCost();
        taSell.clear();
        taSell.appendText(allV.toString());
    }

    public void sortDt(){
        allV.sortByPDate();
        taSell.clear();
        taSell.appendText(allV.toString());
    }

    public void sortDu(){
        allV.sortByCostDateP();
        taSell.clear();
        taSell.appendText(allV.toString());
    }

}
