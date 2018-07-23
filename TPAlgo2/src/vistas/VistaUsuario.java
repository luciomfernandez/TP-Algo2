package vistas;
	
import java.util.ArrayList;

public interface VistaUsuario {
	
	//INIT
	public void initVista();
	
	//ALTA MATERIA PRIMA
	public void onAltaMP(String producto,String err);
	
	//ALTA PRODUCTO MANUFACTURADO
	public void onAltaProducto(String producto,String err);
	
	//ALTA REGLA CONSTRUCCION
	public void onAltaRegla(String nombreRegla, String nombreProducto, String err);
	
	//ACTUALIZACIÓN DE STOCK
	public void onActualizaStock(ArrayList<String> stockActualizado);
	
	//ACTUALIZACION REGISTRO
	public void onActualizaRegistro(ArrayList<String> registroActualizado);
	
	//ALTA MAQUINA
	public void onAltaMaquina(String nombreMaquina,String nombreProducto,String err);
	
	//INIT FABRICACION
	public void onInitFabricacion(String nombreMaquina,String nombreProducto, String err);
	
	//END FABRICACION
	public void onEndFabricacion(String nombreMaquina, String err);

}
