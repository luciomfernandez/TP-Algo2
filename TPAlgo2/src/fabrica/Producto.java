package fabrica;

import java.util.ArrayList;

public class Producto extends ConceptoProducto{
	
	
	private ArrayList<ReglaConstruccion> reglasConstruccion;
	
	public Producto(String nombre, UnidadMedida unidadMedida) {
		super(nombre,unidadMedida);	
	}


	public void agregarRegla(ReglaConstruccion regla){
		if(reglasConstruccion==null){
			this.reglasConstruccion=new ArrayList<ReglaConstruccion>();
		}
		this.reglasConstruccion.add(regla);
	}
	
	public ArrayList<ReglaConstruccion> getReglas() {
		return this.reglasConstruccion;
	}
			
	public ReglaConstruccion obtenerReglaPorNombre(String nombreRegla) {
		ReglaConstruccion regla=null;
		if(this.reglasConstruccion!=null) {
			for(int i=0;i<reglasConstruccion.size();i++) {
				if(this.reglasConstruccion.get(i).getNombre().equals(nombreRegla)) {
					regla=this.reglasConstruccion.get(i);
				}
			}
		}
		return regla;
	}
	
}
