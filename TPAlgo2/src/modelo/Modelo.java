package modelo;

import java.util.ArrayList;
import java.util.HashMap;

import excepciones.MiException;
import fabrica.ConceptoProducto;
import fabrica.MateriaPrima;
import fabrica.Producto;
import fabrica.Registro;
import fabrica.ReglaConstruccion;
import fabrica.UnidadMedida;
import maquina.Maquina;
import vistas.MiVistaUsuarioConsola;
import vistas.NombreCant;
import vistas.VistaUsuario;

public class Modelo {
	private Validador validador;
	private VistaUsuario vista;
	private ArrayList<MateriaPrima> materiaPrima;
	private ArrayList<Producto> productosManufacturados;
	private ArrayList<Maquina> maquinas;
	private Registro registro;
	
	
	public Modelo(){
		this.validador=new Validador(this);
		this.registro=new Registro();
	}	
	
	
	public void setVista(VistaUsuario vista){
		this.vista=vista;
		
	}
	
	
	//*******************************************/ALTA PRODUCTO/*****************************************
	public void altaProducto(String nombre,UnidadMedida unidadMedida) {
		try {
			validador.validarAltaProducto(nombre);	
			 Producto pm=new Producto(nombre,unidadMedida);
			
			
			if(this.productosManufacturados==null) {
				this.productosManufacturados=new ArrayList<Producto>();
			}
			
			this.productosManufacturados.add(pm);
			
			//Notifico a la vista
			vista.onAltaProducto(nombre,null);
			this.vista.onActualizaStock(this.generarStockActual());
		
		}catch(MiException e){
			this.vista.onAltaProducto(null,e.getMessage());
		}	
			
	
	}

	//****************************************/ALTA MATERIA PRIMA//***********************************
	public void altaMateriaPrima(String nombre, UnidadMedida unidadMedida) {
		try {
			this.validador.validarAltaMateriaPrima(nombre);
			MateriaPrima mp=new MateriaPrima(nombre,unidadMedida);
			if(this.materiaPrima==null) {
				materiaPrima=new ArrayList<MateriaPrima>();
			}
			
			this.materiaPrima.add(mp);
			//Notifico a la vista
			vista.onAltaMP(nombre,null);
			this.vista.onActualizaStock(this.generarStockActual());
		}catch(MiException e){
			this.vista.onAltaMP(null,e.getMessage());
		}
	}

	//*****************************************/ALTA REGLA/*********************************************
	
		public void altaRegla(String nombreProducto,String nombreRegla, ArrayList<NombreCant> nc) {
			try {
				this.validador.validarAltaRegla(nombreProducto, nc);
				
				ReglaConstruccion regla=new ReglaConstruccion(nombreRegla);
				Producto producto=(Producto)buscarConceptoProductoPorNombre(nombreProducto);
				
				for(int i=0;i<nc.size();i++){
					ConceptoProducto conceptoP=buscarConceptoProductoPorNombre(nc.get(i).getNombre());
					Integer cantidad=nc.get(i).getCant();
					regla.agProdCant(conceptoP, cantidad);	
				}
				producto.agregarRegla(regla);
				vista.onAltaRegla(nombreRegla,nombreProducto,null);
			}catch(MiException e) {
				vista.onAltaRegla(null,null,e.getMessage());
			}
		
		}

	
	
//**************************************/ALTA DE MAQUINA/*****************************************

	public void altaMaquina(String nombreMaquina,String nombreProducto,String nombreRegla,Integer tipoPerdida) {
		try {
			this.validador.validarAltaMaquina();
			Producto p=this.obtenerProductoPorNombre(nombreProducto);
			Maquina m = new Maquina(nombreMaquina,p);
			m.setRegla(p.obtenerReglaPorNombre(nombreRegla));
			m.setPerdida(tipoPerdida);
			
			
			if(this.maquinas==null){
				this.maquinas=new ArrayList<Maquina>();
			}
			
			maquinas.add(m);
			this.vista.onAltaMaquina(nombreMaquina,nombreProducto,null);
		
		}catch(MiException e) {
			this.vista.onAltaMaquina(null,null,e.getMessage());
		}
	}

//********************************/FABRICAR/*****************************************	
	
	public void fabricar(String nombreMaquina){
		Maquina maquina=obtenerMaquinaPorNombre(nombreMaquina);
		try {
			maquina.fabricar();
			this.vista.onInitFabricacion(nombreMaquina, maquina.getProductoAsociado().getNombre(), null);
			this.vista.onActualizaStock(this.generarStockActual());
		}catch(MiException e) {
			this.vista.onInitFabricacion(null,null, e.getMessage());
		}
	}
	
//*********************************/END FABRICACION/*********************************************
	public void endFabricar(String nombreMaquina){
		Maquina maquina=obtenerMaquinaPorNombre(nombreMaquina);
		try {
			maquina.finalizarFabricacion();
			this.registro.registrarFabricacion(maquina.getProductoAsociado().getNombre(), nombreMaquina);
			this.vista.onEndFabricacion(nombreMaquina, null);
			this.vista.onActualizaStock(this.generarStockActual());
			this.vista.onActualizaRegistro(this.generarRegistroActual());
		}catch(MiException e) {
			this.vista.onEndFabricacion(null, e.getMessage());
		}
		
		
	}
	
//*********************************/REGISTRO VENTA/*********************************************
	public void registrarVenta(String nombreProducto, Integer cantidad){
		try {
			this.validador.validarVenta(nombreProducto, cantidad);
			this.buscarConceptoProductoPorNombre(nombreProducto).decrementarStock(cantidad);
			String unidadMedida=this.buscarConceptoProductoPorNombre(nombreProducto).getUnidadMedida();
			this.registro.registrarVenta(nombreProducto, cantidad, unidadMedida);
			this.vista.onActualizaRegistro(this.generarRegistroActual());
			this.vista.onActualizaStock(this.generarStockActual());
		} catch (MiException e) {
			this.vista.onVentaProducto(e.getMessage());
		}
	}
	
//*********************************/REGISTRO COMPRA MATERIA PRIMA/*******************************	
	public void registrarCompra(String nombreMateriaP, Integer cantidad){
		try {
			this.validador.validarCompra();
			this.buscarConceptoProductoPorNombre(nombreMateriaP).incrementarStock(cantidad);
			String unidadMedida=this.buscarConceptoProductoPorNombre(nombreMateriaP).getUnidadMedida();
			this.registro.registrarCompra(nombreMateriaP, cantidad, unidadMedida);
			this.vista.onActualizaRegistro(this.generarRegistroActual());
			this.vista.onActualizaStock(this.generarStockActual());
		}catch(MiException e) {
			this.vista.onActualizaStock(null);
		}
	}
	
//*******************************/AUXILIARES/****************************************************
	
	
	public Producto obtenerProductoPorNombre(String nombre) {
		Producto p=null;
		
		for(int i=0;i<this.productosManufacturados.size();i++){
			if(this.productosManufacturados.get(i).getNombre().equals(nombre)) {
				p=this.productosManufacturados.get(i);
			}
		}
	
		return p;
	}
	
	

	ConceptoProducto buscarConceptoProductoPorNombre(String nombreProducto){
		ConceptoProducto cp=null;
		
		
		if(this.productosManufacturados!=null) {
			for(int i=0;i<this.productosManufacturados.size();i++) {
				if(this.productosManufacturados.get(i).getNombre().equals(nombreProducto)) {
					cp=this.productosManufacturados.get(i);
				}
			}
		}
		
		if(this.materiaPrima!=null) {	
			for(int i=0;i<this.materiaPrima.size();i++) {
				if(this.materiaPrima.get(i).getNombre().equals(nombreProducto)) {
					cp=this.materiaPrima.get(i);
				}
			}
		}	
		return cp;
	}
	

	
	public Maquina obtenerMaquinaPorNombre(String nombreMaquina) {
		Maquina result=null;
		for(int i=0;i<this.maquinas.size();i++){
			if(this.maquinas.get(i).getNombre().equals(nombreMaquina)){
				result = this.maquinas.get(i);
			}
		}
		return result;
	}
	
	
		
	public ArrayList<Producto> getProductosManufacturados() {
		return this.productosManufacturados;
	}
	
	
	public ArrayList<MateriaPrima> getMateriaPrima(){
		return this.materiaPrima;
	}
	
	public ArrayList<String> generarStockActual(){
		ArrayList<String> stock=new ArrayList<String>();
		stock.add("Productos manufacturados:");
		if(this.productosManufacturados!=null){
			Producto p;
			for(int i=0;i<this.productosManufacturados.size();i++) {
				p=this.productosManufacturados.get(i);
				stock.add(p.getNombre()+":"+p.getStock()+" "+p.getUnidadMedida());
			}
		}else {
			stock.add("Sin productos");
		}
		
		stock.add("\nMateria prima:");
		if(this.materiaPrima!=null){
			MateriaPrima mp;
			for(int i=0;i<this.materiaPrima.size();i++) {
				mp=this.materiaPrima.get(i);
				stock.add(mp.getNombre()+":"+mp.getStock()+" "+mp.getUnidadMedida());
			}
		}else {
			stock.add("Sin materia prima");
		}
		
		
		return stock;
	}
	
	
	public  ArrayList<String> generarRegistroActual() {
		return new ArrayList<String>(this.registro.getRegistro());
	}
	
}
