package maquina;

import excepciones.MiException;

public interface EstadoMaquina {
	public void fabricar() throws MiException;
	public void finalizarFabricacion() throws MiException;
}
