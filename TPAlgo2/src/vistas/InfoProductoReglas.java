package vistas;

import java.util.ArrayList;

import excepciones.MiException;

public class InfoProductoReglas {
	ArrayList<ProductoReglas> productoReglas;

	public void agregarReglaAproducto(String nombreProducto, String nombreRegla) {
		Boolean definido=false;
		if(this.productoReglas==null){
			this.productoReglas=new ArrayList<ProductoReglas>();
		}
		
		for(int i=0;i<this.productoReglas.size();i++){
			if(this.productoReglas.get(i).getNombre().equals(nombreProducto)) {
				this.productoReglas.get(i).addRegla(nombreRegla);
				definido=true;
			}
		}
	
		if(!definido){
			ProductoReglas nuevoPR=new ProductoReglas(nombreProducto);
			nuevoPR.addRegla(nombreRegla);
			this.productoReglas.add(nuevoPR);
		}
		
	}


	public ArrayList<String> getReglasDeProducto(String nombreProd) throws MiException{

		if(this.definido(nombreProd)){
			if(this.productoReglas!=null){
				for(int i=0;i<this.productoReglas.size();i++){
					if(this.productoReglas.get(i).getNombre().equals(nombreProd)){
						return this.productoReglas.get(i).getReglas();
					}
				}
			};
		}
		
		throw new MiException("ERROR:No existen reglas para ese producto, no puede crear maquina");
	
	}

	private Boolean definido(String nombreProd){
		Boolean res=false;
		if(this.productoReglas!=null){
			for(int i=0;i<this.productoReglas.size();i++){
				if(this.productoReglas.get(i).getNombre().equals(nombreProd)){
					res=true;
				}
			}
		}
	
		return res;
	}	
}
