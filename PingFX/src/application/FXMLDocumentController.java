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
		colActivo.setCellValueFactory(new PropertyValueFactory<>("btnActivo"));
		colSonido.setCellValueFactory(new PropertyValueFactory<>("btnSonido"));

		tablaIPs.setItems(archivo.getInitialTableData());
		/*
		tablaIPs.setEditable(true);
		//Hacemos editable las lineas de la columna Nombre
		colNombre.setCellFactory(TextFieldTableCell.forTableColumn());
		colNombre.setOnEditCommit(new EventHandler<CellEditEvent>() {
			
			@Override
			public void handle(CellEditEvent t){
				((Direcciones) t.getTableView().getItems().get(t.getTablePosition().getRow())).setNombre((String) t.getNewValue());
				saveTableData();
			}
		});
		
		//Hacemos editable las líneas de la columna Direccion
		colDireccion.setCellFactory(TextFieldTableCell.forTableColumn());
		colDireccion.setOnEditCommit(new EventHandler<CellEditEvent>() {
			
			@Override
			public void handle(CellEditEvent t){
				((Direcciones) t.getTableView().getItems().get(t.getTablePosition().getRow())).setDireccion((String) t.getNewValue());
			}
		});*/
		
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
