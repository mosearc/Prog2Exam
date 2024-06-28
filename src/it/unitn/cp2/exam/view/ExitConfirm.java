package it.unitn.cp2.exam.view;

import javafx.application.Application;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

import java.util.Optional;

public class ExitConfirm extends Application {
    public static boolean show(String text, String titleTxt){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle(titleTxt);
        String s = text;
        alert.setContentText(s);
        Optional<ButtonType> result = alert.showAndWait();
        return result.isPresent() && result.get() == ButtonType.OK;
    }

    @Override
    public void start(Stage stage) throws Exception {
        ExitConfirm.show("vuoi quit?", "exit");
    }
}
