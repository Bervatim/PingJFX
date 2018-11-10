package application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Direcciones {
	
	private int indice;
	private String nombre;
	private String direccion;
	private Button btnActivo;
	private Button btnSonido;
	private Archivo archivo;
	private int sonido;
	
	Image soundOn = new Image(getClass().getResourceAsStream("/soundOn.jpg"));
	Image soundOff = new Image(getClass().getResourceAsStream("/soundOff.jpg"));
	private AccionesBotones accionesBotones = new AccionesBotones();
	
	
	public Direcciones(int indice, String nombre, String direccion, int sonido){
		this.indice = indice;
		this.nombre = nombre;
		this.direccion = direccion;
		this.sonido = sonido;
		btnActivo = new Button("");
		btnSonido = new Button("", new ImageView(soundOn));
		btnSonido.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				accionesBotones.CambioImagen(indice);
				
			}
		});
		
	}
	public int getIndice() {
		return indice;
	}


	public void setIndice(int indice) {
		this.indice = indice;
	}


	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}


	public Button getBtnActivo() {
		return btnActivo;
	}


	public void setBtnActivo(Button btnActivo) {
		this.btnActivo = btnActivo;
	}


	public Button getBtnSonido() {
		return btnSonido;
	}


	public void setBtnSonido(Button btnSonido) {
		this.btnSonido = btnSonido;
	}


}


