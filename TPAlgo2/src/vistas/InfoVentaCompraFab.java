package vistas;

import java.util.ArrayList;

public class InfoVentaCompraFab {
	private ArrayList<String> registro;

	public void actualizarRegistro(ArrayList<String> registro) {
		this.registro=registro;
	}

	public ArrayList<String> getRegistro(){
		return this.registro;
	}
	

}
