package maquina;
import java.util.ArrayList;
import java.util.Iterator;

import CriterioPerdida.CriterioPerdida;
import CriterioPerdida.Perdida50PorCiento;
import CriterioPerdida.PerdidaDeLiquidos;
import CriterioPerdida.PerdidaPorGramos;
import CriterioPerdida.PerdidaTotal;
import CriterioPerdida.PerdidaUnaUnidad;
import CriterioPerdida.SinPerdida;
import excepciones.MiException;
import fabrica.ConceptoProducto;
import fabrica.Producto;
import fabrica.ReglaConstruccion;

public class Maquina {
	private CriterioPerdida criterio;
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
	
	
	public void setPerdida(Integer tipoCriterio) {
		switch(tipoCriterio) {
			case 1:
				this.criterio=new SinPerdida();
				break;
			case 2:
				this.criterio=new PerdidaTotal();
				break;
			case 3:
				this.criterio=new PerdidaUnaUnidad();
				break;
			case 4:
				this.criterio=new PerdidaDeLiquidos();
				break;
			case 5:
				this.criterio=new PerdidaPorGramos();
				break;
			case 6:
				this.criterio=new Perdida50PorCiento();
				break;
			default:
				break;
		}
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
	
	public CriterioPerdida getCriterioPerdida() {
		return this.criterio;
	}
	
}
