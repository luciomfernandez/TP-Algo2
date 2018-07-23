package vistas;

import java.util.ArrayList;

public class ProductoReglas {
	String nombre;
	ArrayList<String> reglas;
	
	ProductoReglas(String nombre){
		this.nombre=nombre;
		reglas=new ArrayList<String>();
	}
	
	public void addRegla(String regla){
		this.reglas.add(regla);
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public ArrayList<String> getReglas(){
		return this.reglas;
	}
	
}
