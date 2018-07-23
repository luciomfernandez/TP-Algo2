package tpFabrica;

public class ConceptoProducto {
	
	private String idUnico;
	private String nombre;
	private String unidadMedida;
	private Integer stock;
		
	public ConceptoProducto(String nombre, String unidadMedida) {
		super();
		this.nombre = nombre;
		this.unidadMedida = unidadMedida;
		this.stock = 0;
		this.idUnico=generarId();
	}
	
	
	public static final String generarId()
	{
	    String result = java.util.UUID.randomUUID().toString();

	    result.replaceAll("-", "");
	    result.substring(0, 32);

	    return result;
	}
	

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getUnidadMedida() {
		return unidadMedida;
	}
	public void setUnidadMedida(String unidadMedida) {
		this.unidadMedida = unidadMedida;
	}
	public Integer getStock() {
		return stock;
	}
	public void setStock(Integer cant) {
		this.stock=cant;
	}
	
	public void incrementarStock(Integer i) {
		this.stock=this.stock+i;
	}
	
	
	public void decrementarStock(Integer i) {
		this.stock=this.stock-i;
	}
	
	
	
	
}
