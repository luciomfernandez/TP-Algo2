package vistas;
import java.util.ArrayList;

import fabrica.UnidadMedida;

public class InfoUnidadMedida {
	ArrayList<UnidadMedida> unidadesDisponibles;
	UnidadMedida[] unidades;
	
	public InfoUnidadMedida(){
	unidades=UnidadMedida.values();
	
	
	}

	public UnidadMedida[] getUnidadesMedida(){
		return this.unidades;
	}

	public UnidadMedida getPos(Integer pos) {
		return this.unidades[pos];
	}
	
}
