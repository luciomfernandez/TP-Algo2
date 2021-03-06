package CriterioPerdida;

import java.util.ArrayList;

import fabrica.ConceptoProducto;
import fabrica.ReglaConstruccion;

public class PerdidaTotal implements CriterioPerdida {

	@Override
	public Boolean perdida(ReglaConstruccion regla) {
		Boolean cumplePerdida=true;
		ConceptoProducto cpAux=null;	
		ArrayList<ConceptoProducto> conceptos = regla.obtenerConceptoProductos();
		Integer cantidad;
		
		for(int i=0;i<conceptos.size();i++){
			cpAux=conceptos.get(i);
			cantidad=regla.getCantidad(cpAux);
			cumplePerdida=cumplePerdida && (cpAux.getStock()>=cantidad*2);
		}
		
		
		//Si cumple perdida actualiza stock
		if(cumplePerdida) {
			for(int i=0;i<conceptos.size();i++){
				cpAux=conceptos.get(i);
				cantidad=regla.getCantidad(cpAux);
				cpAux.decrementarStock(cantidad*2);
			}
		}
		
		
		return cumplePerdida;
	}
}
