
package fabrica;
import java.util.HashMap;
import java.util.ArrayList;

public class ReglaConstruccion {
	private HashMap<ConceptoProducto,Integer> regla;
	private String nombre;
	
	
	public ArrayList<ConceptoProducto> obtenerConceptoProductos() {
		ArrayList<ConceptoProducto> productos=new ArrayList<ConceptoProducto>();
		productos.addAll(regla.keySet());
		return productos;
	}
	
	
	public ReglaConstruccion(String nombre) {
		this.nombre=nombre;
	}
	
	public ReglaConstruccion() {
		// TODO Auto-generated constructor stub
	}


	public void agProdCant(ConceptoProducto producto,Integer cantidad) {
		if(this.regla==null){
			this.regla=new HashMap<ConceptoProducto,Integer>();
		}
		regla.put(producto, cantidad);
	}
	
	
	public Integer getCantidad(ConceptoProducto p) {
		return regla.get(p);
	}
	
	public void setNombre(String nombre) {
		this.nombre=nombre;
	} 
	
	public String getNombre() {
		return this.nombre;
	}
	
}
