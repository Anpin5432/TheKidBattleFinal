package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class ahorcado3Controller {

	private static final String[] PALABRAS2 = {"¿Cuantos planetas tiene el sistema solar?", "¿Cuantos continentes tiene el planeta tierra?", "¿Cual es el animal mas inteligene del mundo?"};
    private static final String[] PALABRAS4 = {"NUEVE", "CINCO", "DELFIN"};
    private String preguntaSeleccionada3;
	private String palabraSeleccionada3;
    private int intentosRestantes3;
    private StringBuilder palabraActual3;
    private int indi3;
    private Image preguntaImagen3;

    @FXML
    private Label palabraLabel3;

    @FXML
    private Label intentosLabel3;

    @FXML
    private TextField letraTextField3;
    
    @FXML
    private Label pregunta3;
    
    @FXML
    private ImageView imagen3;

    public void initialize() {
    	preguntaSeleccionada3 = seleccionarPalabra3();
    	pregunta3.setText(preguntaSeleccionada3);
        palabraSeleccionada3 = seleccionaPregunta3();
        preguntaImagen3 = seleccionarImagen();
        imagen3.setImage(preguntaImagen3);
        intentosRestantes3 = 7;
        palabraActual3 = new StringBuilder();

        for (int i = 0; i < palabraSeleccionada3.length(); i++) {
            palabraActual3.append("_");
        }

        actualizarVista();
    }

    @FXML
    private void adivinarButtonAction(ActionEvent event) throws IOException {
        String letra3 = letraTextField3.getText().toUpperCase();
        letraTextField3.clear();
        if (letra3.length() == 1) {
            actualizarPalabra(letra3.charAt(0));
            actualizarVista();
            if (intentosRestantes3 == 0 || palabraActual3.indexOf("_") == -1) {
                mostrarResultado();
            }
        }
    }

   private String seleccionarPalabra3() {
        int indice3 = (int) (Math.random() * PALABRAS2.length);
        indi3 = indice3;
        return PALABRAS2[indi3];
    }
    
    private String seleccionaPregunta3() {
       	return PALABRAS4[indi3];
       }
    
    private Image seleccionarImagen() {
    	int i = indi3;
		Image image = new Image("file:///C:/Users/User/Desktop/Eclipse/The_Kids_Battle/src/application/ahorcado3" + i + ".jpg");
		return image;
    	
    }

    private void actualizarPalabra(char letra) {
        boolean letraAdivinada3 = false;
        for (int i = 0; i < palabraSeleccionada3.length(); i++) {
            if (palabraSeleccionada3.charAt(i) == letra) {
                palabraActual3.setCharAt(i, letra);
                letraAdivinada3 = true;
            }
        }
        if (!letraAdivinada3) {
            intentosRestantes3--;
        }
    }

    private void actualizarVista() {
        palabraLabel3.setText(palabraActual3.toString());
        intentosLabel3.setText("Intentos restantes: " + intentosRestantes3);
    }

    private void mostrarResultado() throws IOException {
    	
        if (intentosRestantes3 == 0) {
        	Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Resultado");
            alert.setHeaderText("Perdiste");
            alert.setContentText("La palabra era: " + palabraSeleccionada3);
            alert.showAndWait();
            
        } else {
            rompecabezas();
        }
        
        /*System.exit(0);*/
    }
    
    //Aqui se cargara el codigo del rompecabezas
      private void rompecabezas() throws IOException {
     
    	        Stage secondStage = new Stage(); 
    	        Parent root = FXMLLoader.load(getClass().getResource("bienveRompe.fxml"));
    	        secondStage.setTitle("Reto 2: Rompecabezas");
    	        secondStage.setScene(new Scene(root));
    	        secondStage.show();
    	    
    }
}
