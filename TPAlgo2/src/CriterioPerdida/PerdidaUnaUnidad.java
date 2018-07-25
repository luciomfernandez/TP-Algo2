package CriterioPerdida;

import java.util.ArrayList;

import fabrica.ConceptoProducto;
import fabrica.ReglaConstruccion;

public class PerdidaUnaUnidad implements CriterioPerdida {
//Pierde una unidad en los elementos "contables"
	@Override
	public Boolean perdida(ReglaConstruccion regla) {
		Boolean cumplePerdida=true;
		ConceptoProducto cpAux=null;	
		ArrayList<ConceptoProducto> conceptos = regla.obtenerConceptoProductos();
		Integer cantidad;
		
		for(int i=0;i<conceptos.size();i++){
			cpAux=conceptos.get(i);
			cantidad=regla.getCantidad(cpAux);
			if(cpAux.getUnidadMedida().equals("Unidades")) {
				cumplePerdida=cumplePerdida && (cpAux.getStock()>=cantidad+1);
			}else {
				cumplePerdida=cumplePerdida && (cpAux.getStock()>=cantidad);
			}
		}
		
		
		
		//Si cumple perdida actualizo el stock
		if(cumplePerdida) {	
			for(int i=0;i<conceptos.size();i++){
				cpAux=conceptos.get(i);
				cantidad=regla.getCantidad(cpAux);
				if(cpAux.getUnidadMedida().equals("Unidades")) {
					cpAux.decrementarStock(cantidad+1);
				}else {
					cpAux.decrementarStock(cantidad);
				}
			}
		}
		
		
		return cumplePerdida;
	}

}
