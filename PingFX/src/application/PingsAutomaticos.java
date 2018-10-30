package application;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javafx.collections.ObservableList;

public class PingsAutomaticos {
	
	public PingsAutomaticos(){
		
		ArchivoListaIPs archivoListaIPs = new ArchivoListaIPs();
		ObservableList<String> listaIPs = archivoListaIPs.CargarLista();
			
		listaIPs.forEach((a) -> Pings(a));						
	}
	
	public void Pings(String a) {		
		InetAddress ping;
		Date date = new Date();
		DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");
		String result="";

		//Hacemos ping 
		try {
			ping = InetAddress.getByName(a);
			if (ping.isReachable(1000)) {
				result = ping.toString() + " funciona " + dateFormat.format(date);				
			} else {
				result = "NO VA " + dateFormat.format(date);
			}				
		} catch (IOException e) {
			System.out.println(e);
		}
		
		//Guardamos el resultado
		FileWriter fichero = null;
		try {
			fichero = new FileWriter("/home/toni/prueba.txt", true);
			PrintWriter pw = new PrintWriter(fichero);
			pw.println(result);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (null != fichero)
					fichero.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}
	
	

}
