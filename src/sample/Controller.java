package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    public void handleClose(MouseEvent mouseEvent) {
        System.exit(0);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
    public void GoToType(javafx.event.ActionEvent actionEvent) throws IOException {
        Parent typeriz = FXMLLoader.load(getClass().getResource("/ui/Typederiz.fxml"));
        Scene scene2 = new Scene(typeriz);
        Stage window = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        window.setScene(scene2);
        window.setX(300);
        window.setY(100);
        window.show();
    }

}