package maquina;

import java.util.ArrayList;

import excepciones.MiException;
import fabrica.ConceptoProducto;
import fabrica.ReglaConstruccion;

public class Inactiva implements EstadoMaquina {
	
private Maquina maquina;
	
	
	public Inactiva(Maquina maquina){
		this.maquina=maquina;
	}
	
	
	
	@Override
	public void fabricar() throws MiException {
		if(this.maquina.getCriterioPerdida().perdida(this.maquina.getRegla())){ 
			this.maquina.setEstado(new Fabricando(this.maquina));
		}else {
			throw new MiException("ERROR: No se puede fabricar por falta de stock");
		}
	}

	

	
	@Override
	public void finalizarFabricacion() throws MiException {
		throw new MiException("ERROR: no se puede finalizar fabricación de maquina inactiva");
	}

	
	
}
