package application;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javafx.collections.ObservableList;

public class PingsAutomaticos {
	
	ScheduledExecutorService exec = Executors.newSingleThreadScheduledExecutor();
	ArchivoListaIPs archivoListaIPs = new ArchivoListaIPs();
	ObservableList<String> listaIPs = archivoListaIPs.CargarLista();
	
	public PingsAutomaticos(){}
	
	public void Start(){
		exec.scheduleAtFixedRate(new Runnable() {			
			@Override
			public void run() {
				while (!Thread.interrupted()){
					listaIPs.forEach((a) -> Pings(a));					
				}
			}
		}, 1, 5, TimeUnit.SECONDS);
	}
	
	public void Stop() {
		exec.shutdownNow();
		
	}
	
	public void Pings(String a) {
		
		InetAddress ping;
		Date date = new Date();
		DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");
		String result="";
		String[] partes = a.split(" ");	

		//Hacemos ping 
		try {
			ping = InetAddress.getByName(partes[1]);
			if (ping.isReachable(1000)) {
				result = ping.toString() + " funciona " + dateFormat.format(date);				
			} else {
				result = ping.toString() + "NO VA " + dateFormat.format(date);
			}				
		} catch (IOException e) {
			System.out.println(e);
		}
		
		//Guardamos el resultado
		FileWriter fichero = null;
		try {
			fichero = new FileWriter("C:/Users/Toni/Resultado.txt", true);
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
