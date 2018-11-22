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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableRow;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.ImageView;

public class FXMLDocumentController implements Initializable{
	
	PingsAutomaticos pingsAutomaticos = new PingsAutomaticos(10000);
	Archivo archivo = new Archivo();
	
	@FXML
	private Button boton2;
		
	@FXML
	TableColumn<Direcciones, String> colNombre;
	
	@FXML
	TableColumn<Direcciones, String> colDireccion;
	
	@FXML
	TableColumn<Direcciones, ImageView> colActivo;
	
	@FXML
	TableColumn<Direcciones, ImageView> colSonido;
	
	@FXML
	TableView<Direcciones> tablaIPs;
	
	@FXML
	private void onClickBoton (ActionEvent event) { 
		pingsAutomaticos.Start();
	} 
	
	@FXML
	private void onClickParar (ActionEvent event) {
		pingsAutomaticos.Stop();
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {  //METODO INITIALIZE
				
		colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
		colDireccion.setCellValueFactory(new PropertyValueFactory<>("direccion"));
		colActivo.setCellValueFactory(new PropertyValueFactory<>("cbActivo"));
		colSonido.setCellValueFactory(new PropertyValueFactory<>("cbSonido"));

		tablaIPs.setItems(archivo.getInitialTableData());
		
		colActivo.setStyle("-fx-alignment: CENTER");
		colSonido.setStyle("-fx-alignment: CENTER");
		
		tablaIPs.setEditable(true);
		//Hacemos que las celdas de cada una de las columnas sean editables
		colNombre.setCellFactory(TextFieldTableCell.forTableColumn());
		colDireccion.setCellFactory(TextFieldTableCell.forTableColumn());
		
		//Y el listener cuando editamos una celda de la columna colNombre.
		colNombre.setOnEditCommit(data -> {
			System.out.println("Nuevo nombre: " + data.getNewValue());
			System.out.println("Antiguo nombre: " + data.getOldValue());
		});
		
		//Y el listener cuando editamos una celda de la columna colDireccion.
		colDireccion.setOnEditCommit(data -> {
			System.out.println("Nuevo nombre: " + data.getNewValue());
			System.out.println("Antiguo nombre: " + data.getOldValue());
		});
		
		} // FIN METODO INITIALIZE
	

	
	private void saveTableData(){
		
		TablePosition pos = (TablePosition) tablaIPs.getSelectionModel().getSelectedCells().get(0);
		int row = pos.getRow();
		
		Object item = tablaIPs.getItems().get(row);
		TableColumn col = pos.getTableColumn();
		
		String data = (String) col.getCellObservableValue(item).getValue();
		
		System.out.println(data);
	}

}
