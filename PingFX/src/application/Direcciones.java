package application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Direcciones {
	
	private int indice;
	private String nombre;
	private String direccion;
	private CheckBox cbActivo;
	private CheckBox cbSonido;
	private int activo; //si se quiere hacer ping a esa direccion
	private int sonido;   // si queremos que tenga sonido en caso de que no lleguemos a hacer ping
	
	public Direcciones(int indice, String nombre, String direccion, int activo, int sonido){
		this.indice = indice;
		this.nombre = nombre;
		this.direccion = direccion;
		this.activo = activo;
		this.sonido = sonido;
		cbActivo = new CheckBox();
		cbSonido = new CheckBox();
		
		if (activo == 1) {
				cbActivo.setSelected(true);
			} else {
				cbActivo.setSelected(false);
			}
			if (sonido == 1) {
				cbSonido.setSelected(true);
			} else {
				cbSonido.setSelected(false);
			}
	
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


	public  CheckBox getCbActivo() {
		return cbActivo;
	}


	public void setcbActivo(CheckBox cbActivo) {
		this.cbActivo = cbActivo;
	}

	
	public int getActivo(){
		return activo;
	}
	
	public int getSonido() {
		return sonido;
	}
	
	public CheckBox getCbSonido() {
		return cbSonido;
	}
	public void setCbSonido(CheckBox cbSonido) {
		this.cbSonido = cbSonido;
	}


}


