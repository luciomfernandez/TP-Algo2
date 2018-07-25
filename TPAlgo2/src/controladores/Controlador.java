package controladores;

import java.util.ArrayList;

import fabrica.UnidadMedida;
import vistas.NombreCant;

public interface Controlador {
	public void peticionAltaMP(String nombre ,UnidadMedida unidadMedida);
	public void peticionAltaP(String nombre,UnidadMedida unidadMedida);
	public void peticionAltaRegla(String nombreProducto,String nombreRegla, ArrayList<NombreCant> nc);
	public void peticionAltaMaquina(String nombreMaquina,String nombreProducto,String nombreRegla,Integer tipoPerdida);
	public void peticionInitFabricacion(String nombreMaquina);
	public void peticionEndFabricacion(String nombreMaquina);
	public void peticionComprarMateriPrima(String materiaPrima,Integer cantidad);
	public void peticionVentaProducto(String nombreProducto, Integer cantidad);
}
