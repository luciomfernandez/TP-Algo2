package CriterioPerdida;

import java.util.ArrayList;

import fabrica.ConceptoProducto;
import fabrica.ReglaConstruccion;

public class PerdidaPorGramos implements CriterioPerdida {
//Todos los elementos con unidad de medida en gramos pierden el total de su cantidad
	@Override
	public Boolean perdida(ReglaConstruccion regla) {
		Boolean cumplePerdida=true;
		ConceptoProducto cpAux=null;	
		ArrayList<ConceptoProducto> conceptos = regla.obtenerConceptoProductos();
		Integer cantidad;
		
		for(int i=0;i<conceptos.size();i++){
			cpAux=conceptos.get(i);
			cantidad=regla.getCantidad(cpAux);
			if(cpAux.getUnidadMedida().equals("Gramos")) {
				cumplePerdida=cumplePerdida && (cpAux.getStock()>=cantidad*2);
			}else {
				cumplePerdida=cumplePerdida && (cpAux.getStock()>=cantidad);
			}
		}
		
		
		//SI CUMPLE PERDIDA ACTUALIZO EL STOCK
				if(cumplePerdida) {
					for(int i=0;i<conceptos.size();i++){
						cpAux=conceptos.get(i);
						cantidad=regla.getCantidad(cpAux);
						if(cpAux.getUnidadMedida().equals("Gramos")) {
							cpAux.decrementarStock(cantidad*2);
						}else {
							cpAux.decrementarStock(cantidad*2);
						}
					}
				}
		
		
		return cumplePerdida;
	}	
}
