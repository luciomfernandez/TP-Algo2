package CriterioPerdida;

import java.util.ArrayList;

import fabrica.ConceptoProducto;
import fabrica.ReglaConstruccion;

public class Perdida50PorCiento implements CriterioPerdida {
//Se pierde un 50% de todos los elementros de la regla, sin importar la unidad
	@Override
		public Boolean perdida(ReglaConstruccion regla) {
			Boolean cumplePerdida=true;
			ConceptoProducto cpAux=null;	
			ArrayList<ConceptoProducto> conceptos = regla.obtenerConceptoProductos();
			Integer cantidad;
			Double porcentaje;
			
			
			
			//VERIFICA SI CUMPLE PERDIDA
			for(int i=0;i<conceptos.size();i++){
				cpAux=conceptos.get(i);
				cantidad=regla.getCantidad(cpAux);
				porcentaje = (50.0 / 100) * cantidad.doubleValue();
				cumplePerdida=cumplePerdida && (cpAux.getStock()>=cantidad+(porcentaje.intValue()));
	
			}
			
			
			//SI CUMPLE PERDIDA ACTUALIZO EL STOCK
			if(cumplePerdida){
				for(int i=0;i<conceptos.size();i++){
				cpAux=conceptos.get(i);
				cantidad=regla.getCantidad(cpAux);
				porcentaje = (50.0 / 100) * cantidad.doubleValue();
				cpAux.decrementarStock(cantidad+(porcentaje.intValue()));
				}
			}
			
			return cumplePerdida;
		}
	

}
