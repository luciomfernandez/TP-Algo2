package modelo;

import java.util.ArrayList;

import excepciones.MiException;
import vistas.NombreCant;

public class Validador {
	Modelo modelo;
	
	public Validador(Modelo modelo) {
		this.modelo=modelo;
	}
	
	
	//VALIDA ALTA MAQUINA
	public void validarAltaMaquina() throws MiException{
		
	}
	
	//VALIDA VENTA
	public void validarVenta(String nombreProducto,Integer cantidad) throws MiException{
		if(modelo.obtenerProductoPorNombre(nombreProducto).getStock()<cantidad) {
			throw new MiException("Error: no se puede vender esta cantidad de producto por falta de stock");
		}
	}
	
	//VALIDA COMPRA MATERIA PRIMA
	public void validarCompra() throws MiException {
		
	}
	
	
	//Valida que la receta de un producto no se contenga a si misma
	public void validarAltaRegla(String nombreProducto, ArrayList<NombreCant> nc) throws MiException {
		for(int i=0;i<nc.size();i++) {
			if(nc.get(i).getNombre().equals(nombreProducto)) {
				throw new MiException("Error: un producto no puede fabricarse a partir de si mismo");
			}
		}
	}
	
	
	//VALIDA ALTA PRODUCTO
	public void validarAltaProducto(String nombre) throws MiException{
		if(this.modelo.getProductosManufacturados()!=null) {
			for(int i=0;i<this.modelo.getProductosManufacturados().size();i++) {
				if(this.modelo.getProductosManufacturados().get(i).getNombre().equals(nombre)) {
					throw new MiException("Ya existe producto con este nombre");
				}	
			}
		}
	}

	
	//VALIDA ALTA MATERIA PRIMA
	public void validarAltaMateriaPrima(String nombre) throws MiException{
		if(this.modelo.getMateriaPrima()!=null) {
			for(int i=0;i<this.modelo.getMateriaPrima().size();i++) {
				if(this.modelo.getMateriaPrima().get(i).getNombre().equals(nombre)) {
					throw new MiException("Ya existe materia prima con este nombre");
				}	
			}
		}
	}


}
