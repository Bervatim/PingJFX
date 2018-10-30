package application;

import javafx.scene.control.Button;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javafx.fxml.*;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;

public class FXMLDocumentController implements Initializable{
		
	
	@FXML
	private Button boton2;
	
	@FXML
	private ListView<String> listaIPs;
	
	PingsAutomaticos pingsAutomaticos = new PingsAutomaticos();
	
	@FXML
	private void onClickBoton (ActionEvent event) { 
		System.out.println("has hecho click");
		pingsAutomaticos.Start();
	} 
	
	@FXML
	private void onClickParar (ActionEvent event) {
		pingsAutomaticos.Stop();
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {  //METODO INITIALIZE
		
		ArchivoListaIPs archivoListaIPs = new ArchivoListaIPs();
		listaIPs.setItems(archivoListaIPs.CargarLista());	
		} // FIN METODO INITIALIZE

}
