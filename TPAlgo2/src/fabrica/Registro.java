package fabrica;

import java.util.ArrayList;
import java.util.Calendar;

public class Registro {
	private Calendar calendario;
	private ArrayList<String> registro;
		
	
	public Registro() {
		calendario= Calendar.getInstance();
	}
	
	
	public void registrarVenta(String nombreProducto, Integer cantidad, String unidadMedida) {
		String date=calendario.getTime().toString();
		String reg=date+"...Se registró una venta de "+cantidad+" "+unidadMedida+" de "+nombreProducto;
		if(this.registro==null) {
			this.registro=new ArrayList<String>();
		}
		this.registro.add(reg);
	}
	
	public void registrarCompra(String nombreMateriaP, Integer cantidad, String unidadMedida) {
		String date=calendario.getTime().toString();
		String reg=date+"...Se registró una compra de "+cantidad+" "+unidadMedida+" de "+nombreMateriaP;
		if(this.registro==null) {
			this.registro=new ArrayList<String>();
		}
		this.registro.add(reg);
	}
	
	public void registrarFabricacion(String nombreProducto, String nombreMaquina) {
		String date=calendario.getTime().toString();
		String reg=date+"...Se registró una fabricación de "+nombreProducto+" luego de finalizar la maquina:"+nombreMaquina;
		if(this.registro==null) {
			this.registro=new ArrayList<String>();
		}
		this.registro.add(reg);
	}
	

	public ArrayList<String> getRegistro() {
		return registro;
	}	
	
}
