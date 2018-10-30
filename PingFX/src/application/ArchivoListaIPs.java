package application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ArchivoListaIPs {
	
	
	
	public ArchivoListaIPs() {		
	}
	
	public ObservableList CargarLista() {
		
		ObservableList<String> archivoListaIPs = FXCollections.observableArrayList();
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(new File("C:/Users/Toni/ListaIPs.txt")));
			String line;
			
			while ((line = br.readLine()) != null) {
				archivoListaIPs.add(line);
			}			
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return archivoListaIPs;
		
	}

}
