package sample;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Typederiz implements Initializable {
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
    public void GoToMode(javafx.event.ActionEvent actionEvent) throws IOException {
        Parent modecuiss = FXMLLoader.load(getClass().getResource("/ui/Modecuisson.fxml"));
        Scene scene2 = new Scene(modecuiss);
        Stage window = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        window.setScene(scene2);
        window.setX(300);
        window.setY(100);
        window.show();
    }
}
