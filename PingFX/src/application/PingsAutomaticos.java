package application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
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
import java.util.concurrent.atomic.AtomicBoolean;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class PingsAutomaticos implements Runnable{
	
	private Thread worker;
	private final AtomicBoolean running = new AtomicBoolean(false);
	private int intervalo;
	private Archivo archivo = new Archivo();
	
	private ObservableList<Direcciones> datos;
	
	public PingsAutomaticos(int intervalo){
		
		this.intervalo = intervalo;
		datos = archivo.getInitialTableData();
		
	}
	
	public void Start(){
		
		worker = new Thread(this);
		worker.start();

	}
	public void Stop() {
		running.set(false);
		
	}
	@Override
	public void run() {
			running.set(true);
			while (running.get()){
				
				try{
					Thread.sleep(intervalo);
				} catch (InterruptedException e){
					Thread.currentThread().interrupt();
					System.out.println("se paroooooo");
				}
				datos.forEach((a) -> Pings (a.getDireccion()));
			}
	}
		
	public void Pings(String a) {
		
		InetAddress ping;
		Date date = new Date();
		DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");
		String result="";

		//Hacemos ping 
		try {
			ping = InetAddress.getByName(a);
			if (ping.isReachable(100)) {
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
