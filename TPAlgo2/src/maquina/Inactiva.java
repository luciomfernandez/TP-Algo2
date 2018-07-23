package maquina;

import java.util.ArrayList;

import excepciones.MiException;
import tpFabrica.ConceptoProducto;
import tpFabrica.ReglaConstruccion;

public class Inactiva implements EstadoMaquina {
	
private Maquina maquina;
	
	
	public Inactiva(Maquina maquina){
		this.maquina=maquina;
	}
	
	
	
	@Override
	public void fabricar() throws MiException {
		if(this.hayStockParaFabricar()){
			this.maquina.setEstado(new Fabricando(this.maquina));
		}else {
			throw new MiException("ERROR: No se puede fabricar por falta de stock");
		}
	}

	public Boolean hayStockParaFabricar() {
		Boolean cumplePerdida=true;
		ConceptoProducto cpAux=null;
		//ReglaConstruccion auxRegla=algoritmo.perdida(this.regla);		
		ReglaConstruccion auxRegla=maquina.getRegla();
		ArrayList<ConceptoProducto> conceptos = auxRegla.obtenerConceptoProductos();
		
		
		for(int i=0;i<conceptos.size();i++){
			cpAux=conceptos.get(i);
			cumplePerdida=cumplePerdida && cpAux.getStock()>=auxRegla.getCantidad(cpAux);
		}
		
		//SI CUMPLE PERDIDA ACTUALIZO EL STOCK
		if(cumplePerdida) {
			for(int i=0;i<conceptos.size();i++){
				cpAux=conceptos.get(i);
				cpAux.decrementarStock(auxRegla.getCantidad(cpAux));
			}
		}
		
		return cumplePerdida;
	}
	
	
	
	@Override
	public void finalizarFabricacion() throws MiException {
		throw new MiException("ERROR: no se puede finalizar fabricación de maquina inactiva");
	}

	
	
}
