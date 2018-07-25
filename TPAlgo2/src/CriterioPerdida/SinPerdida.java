package CriterioPerdida;

import java.util.ArrayList;

import fabrica.ConceptoProducto;
import fabrica.ReglaConstruccion;

public class SinPerdida implements CriterioPerdida {
	public Boolean perdida(ReglaConstruccion regla) {
		ConceptoProducto cpAux=null;	
		ArrayList<ConceptoProducto> conceptos = regla.obtenerConceptoProductos();
		Integer cantidad;
		Boolean cumplePerdida=true;
		
		
		for(int i=0;i<conceptos.size();i++){
			cpAux=conceptos.get(i);
			cantidad=regla.getCantidad(cpAux);
			cumplePerdida=cumplePerdida && (cpAux.getStock()>=cantidad);
		}
		
		
		if(cumplePerdida){
			for(int i=0;i<conceptos.size();i++){
				cpAux=conceptos.get(i);
				cantidad=regla.getCantidad(cpAux);
				cpAux.decrementarStock(cantidad);
			}
		}

		return cumplePerdida;
	}
}