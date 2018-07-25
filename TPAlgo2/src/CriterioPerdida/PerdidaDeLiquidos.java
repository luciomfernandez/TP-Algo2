package CriterioPerdida;

import java.util.ArrayList;

import fabrica.ConceptoProducto;
import fabrica.ReglaConstruccion;

public class PerdidaDeLiquidos implements CriterioPerdida {
	//Se pierde un 10% de liquido en litros
	
	@Override
	public Boolean perdida(ReglaConstruccion regla) {
		Boolean cumplePerdida=true;
		ConceptoProducto cpAux=null;	
		ArrayList<ConceptoProducto> conceptos = regla.obtenerConceptoProductos();
		Integer cantidad;
		Double porcentaje;
		
		for(int i=0;i<conceptos.size();i++){
			cpAux=conceptos.get(i);
			cantidad=regla.getCantidad(cpAux);
			if(cpAux.getUnidadMedida().equals("Litros")) {
				porcentaje = (10.0 / 100) * cantidad.doubleValue();
				cumplePerdida=cumplePerdida && (cpAux.getStock()>=cantidad+(porcentaje.intValue()));
			}else {
				cumplePerdida=cumplePerdida && (cpAux.getStock()>=cantidad);
			}
		}
		
		
		//SI CUMPLE PERDIDA ACTUALIZO EL STOCK
		if(cumplePerdida){
			for(int i=0;i<conceptos.size();i++){
				cpAux=conceptos.get(i);
				cantidad=regla.getCantidad(cpAux);
				if(cpAux.getUnidadMedida().equals("Litros")) {
					porcentaje = (10.0 / 100) * cantidad.doubleValue();
					cpAux.decrementarStock(cantidad+(porcentaje.intValue()));
				}else{
					cpAux.decrementarStock(cantidad);
				}		
			}
		}
		
		
		return cumplePerdida;
	}

}
