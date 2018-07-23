package controladores;

import java.util.ArrayList;

import modelo.Modelo;
import vistas.NombreCant;

public class MiControlador implements Controlador {

	private Modelo modelo;
	
	public void setModelo(Modelo modelo) {
		this.modelo=modelo;
	}
	
	public void peticionAltaMP(String nombre ,String unidadMedida) {
		modelo.altaMateriaPrima(nombre,unidadMedida);
	
	}
	
	public void peticionAltaP(String nombre,String unidadMedida) {
		modelo.altaProducto(nombre,unidadMedida);
	}
	
	
	public void peticionAltaRegla(String nombreProducto,String nombreRegla, ArrayList<NombreCant> nc){
		modelo.altaRegla(nombreProducto,nombreRegla,nc);
	}
	
	public void peticionInitFabricacion(String nombreMaquina) {
		modelo.fabricar(nombreMaquina);
	}
	
	public void peticionEndFabricacion(String nombreMaquina) {
		modelo.endFabricar(nombreMaquina);
	}
	
	
	public void peticionAltaMaquina(String nombreMaquina,String nombreProducto,String nombreRegla,Integer tipoPerdida) {
		modelo.altaMaquina(nombreMaquina,nombreProducto,nombreRegla,tipoPerdida);
	}

	public void peticionComprarMateriPrima(String materiaPrima,Integer cantidad) {
		modelo.registrarCompra(materiaPrima, cantidad);
	}

}
