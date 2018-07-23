package vistas;

public class NombreCant {
	private String nombre;
	private Integer cant;
	
	public NombreCant(String nombre, Integer cant){
		this.nombre=nombre;
		this.cant=cant;
	}

	public String getNombre(){
		return this.nombre;
	}

	public Integer getCant(){
		return this.cant;
	} 
	
}
