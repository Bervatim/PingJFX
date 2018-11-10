package application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Archivo {
	
	private ObservableList<Direcciones> datos;
	
	public Archivo() {

		ObservableList<Direcciones> archivoListaIPs = FXCollections.observableArrayList();

		try {  //Accedemos al archivo con los datos de las direcciones
			BufferedReader br = new BufferedReader(new FileReader(new File("C:/Users/Toni/ListaIPs.txt")));
			String line;
			
			while ((line = br.readLine()) != null) {
				
				String[] parts = line.split(" ");
				int part0 = Integer.parseInt(parts[0]);
				String part1 = parts[1];
				String part2 = parts[2];
				int part3 = Integer.parseInt(parts[3]);
				archivoListaIPs.add(new Direcciones(part0,part1, part2, part3));
			}			
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}		
		datos =  archivoListaIPs;
	}

	public ObservableList<Direcciones> getInitialTableData(){
		return datos;
	}
	
	
}
