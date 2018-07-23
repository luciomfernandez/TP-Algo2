package vistas;

import java.util.ArrayList;
import java.util.Iterator;

import excepciones.MiException;

public class InfoMaquinas {
	private ArrayList<String> maquinas;
	private ArrayList<String> maquinasProducto;

	private ArrayList<String> maquinasActivas;
	private ArrayList<String> maquinasActivasProducto;
	
	
	public void agregarMaquinaProducto(String maquina, String producto){
		if(this.maquinas==null){
			this.maquinas=new ArrayList<String>();
		}
	
		if(this.maquinasProducto==null) {
			this.maquinasProducto=new ArrayList<String>();
		}
	
		this.maquinas.add(maquina);
		this.maquinasProducto.add(maquina+" (fabrica:"+producto+")");
	}
	
	
	public void agregarMaquinaActiva(String maquina, String producto){
		if(this.maquinasActivas==null){
			this.maquinasActivas=new ArrayList<String>();
		}
	
		if(this.maquinasActivasProducto==null) {
			this.maquinasActivasProducto=new ArrayList<String>();
		}

	
		this.maquinasActivas.add(maquina);
		this.maquinasActivasProducto.add(maquina+" (fabricando... "+producto+")");
	}
	
	public void quitarMaquinaActiva(String maquina){
		Iterator<String> it=this.maquinasActivas.iterator();
		int pos=0;
		int posEliminar;
		
		while(it.hasNext()){
			if(it.next().equals(maquina)){
				posEliminar=pos;
				it.remove();
				this.maquinasActivasProducto.remove(posEliminar);
			}
			pos+=1;
		}
	
	
	}


	public ArrayList<String> getMaquinas() {
		return maquinas;
	}


	public ArrayList<String> getMaquinasProducto() {
		return maquinasProducto;
	}


	public ArrayList<String> getMaquinasActivas() {
		return maquinasActivas;
	}


	public ArrayList<String> getMaquinasActivasProducto() throws MiException {
		if(this.maquinasActivasProducto==null) {
			throw new MiException("ERROR: No hay productos en proceso de fabricación");
		}
		return maquinasActivasProducto;
	}
	
	
	
	
	
}
