package application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

import javafx.event.ActionEvent;

public class bienveRompeController {

	// Event Listener on Button.onAction
	@FXML
	public void btnStartGame(ActionEvent event) throws IOException {
		// TODO Autogenerated
		Stage secondStage = new Stage(); 
        Parent root = FXMLLoader.load(getClass().getResource("rompe.fxml"));
        secondStage.setTitle("Rompecabezas: Desbloqueo");
        secondStage.setScene(new Scene(root));
        secondStage.show();
	}
}