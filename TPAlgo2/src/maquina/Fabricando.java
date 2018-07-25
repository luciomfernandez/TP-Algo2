package maquina;
import excepciones.MiException;

public class Fabricando implements EstadoMaquina {
	
	private Maquina maquina;
	
	public Fabricando(Maquina maquina){
		this.maquina=maquina;
	}
	
	
	@Override
	public void fabricar() throws MiException {
		throw new MiException("ERROR: no se puede fabricar si una maquina esta activa");
	}

	@Override
	public void finalizarFabricacion() {
		this.maquina.getProductoAsociado().incrementarStock(1);
		this.maquina.setEstado(new Inactiva(this.maquina));
	}

	
}
