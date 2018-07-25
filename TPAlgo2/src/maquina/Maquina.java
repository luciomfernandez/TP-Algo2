package maquina;
import java.util.ArrayList;
import java.util.Iterator;

import CriterioPerdida.CriterioPerdida;
import excepciones.MiException;
import fabrica.ConceptoProducto;
import fabrica.Producto;
import fabrica.ReglaConstruccion;

public class Maquina {
	private CriterioPerdida algoritmo;
	private ReglaConstruccion regla;
	private String nombre;
	private Producto productoAsociado;
	private EstadoMaquina estado;
	
	
	public Maquina(String nombreMaquina, Producto producto) {
		this.estado=new Inactiva(this);
		this.nombre=nombreMaquina;
		this.productoAsociado=producto;
	}
	
	
		
	public void fabricar() throws MiException {
		this.estado.fabricar();
	}		
	
	
	public void finalizarFabricacion() throws MiException {
		this.estado.finalizarFabricacion();
	}
	

	
	public void setRegla(ReglaConstruccion regla) {
		this.regla=regla;
	}
	
	
	public void setPerdida(Integer tipoAlg) {
		
	}
	
	public Boolean tienePerdida() {
		return this.algoritmo!=null;
	}
	
	public Boolean tieneReglaAsociada() {
		return this.regla!=null;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public ReglaConstruccion getRegla() {
		return this.regla;
	}
	
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	
	public void setEstado(EstadoMaquina estado) {
		this.estado=estado;
	}

	public Producto getProductoAsociado() {
		return this.productoAsociado;
	}
	
	
}
