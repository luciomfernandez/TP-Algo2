package vistas;

import java.util.ArrayList;
import java.util.HashMap;

import excepciones.MiException;
import fabrica.UnidadMedida;

public class InfoVista{
	private ArrayList<String> productosManufacturados;
	private ArrayList<String> materiaPrima;
	private InfoMaquinas infoMaquinas;
	private InfoProductoReglas infoProductoReglas;
	private InfoStock infoStock;
	private InfoVentaCompraFab infoRegistro;
	private InfoUnidadMedida infoUnidades;
	
	
	
	
	
	
	public void agregarProducto(String producto){
		if(this.productosManufacturados==null) {
			this.productosManufacturados=new ArrayList<String>();
		}
		this.productosManufacturados.add(producto);
	}

	public void agregarProductoRegla(String nombreProducto, String nombreRegla){
		if(this.infoProductoReglas==null){
			this.infoProductoReglas=new InfoProductoReglas();
		}
		this.infoProductoReglas.agregarReglaAproducto(nombreProducto, nombreRegla);
	}
	
	
	public void agregarMaquinaProducto(String maquina,String producto){
		if(this.infoMaquinas==null){
			this.infoMaquinas=new InfoMaquinas();
		}
	
		this.infoMaquinas.agregarMaquinaProducto(maquina, producto);
	}
	
	
	public void agregarMaquinaProductoActivas(String maquina,String producto){
		if(this.infoMaquinas==null){
			this.infoMaquinas=new InfoMaquinas();
		}
	
		this.infoMaquinas.agregarMaquinaActiva(maquina, producto);
	}
	
	
	

	
	
	public void agregarMateriaPrima(String producto){
		if(this.materiaPrima==null) {
			this.materiaPrima=new ArrayList<String>();
		}
		this.materiaPrima.add(producto);
	}
	
	
	
	
	public String getNombreMaquina(Integer pos) {
		return this.infoMaquinas.getMaquinas().get(pos);
	}
	
	
	public String getProductoPos(Integer pos){
		return productosManufacturados.get(pos);
	}

	public String getMateriaPrimaPos(Integer pos){
		return materiaPrima.get(pos);
	}
	
	public String maquinas(String mensaje) throws MiException{
		if(this.infoMaquinas==null) {
			throw new MiException("ERROR: el sistema no tiene máquinas dadas de altas");
		}
		
		ArrayList<String> maquinas=this.infoMaquinas.getMaquinasProducto();
		String menu=mensaje+"\n";
		for(int i=0;i<maquinas.size();i++){
		menu=menu+(i+1)+":"+maquinas.get(i)+"\n";
		}
		
		return menu;
	}
	
	
	
	public void quitarMaquinaActiva(String maquina){
		this.infoMaquinas.quitarMaquinaActiva(maquina);
	}
	
	public String maquinas2(String mensaje) throws MiException{
		if(this.infoMaquinas==null) {
			throw new MiException("ERROR: el sistema no tiene máquinas dadas de altas");
		}
		
		ArrayList<String> maquinas=this.infoMaquinas.getMaquinas();
		String menu=mensaje+"\n";
		for(int i=0;i<maquinas.size();i++){
		menu=menu+(i+1)+":"+maquinas.get(i)+"\n";
		}
		
		return menu;
	}

	
	public String getReglasProducto(String nombreProd,String mensaje) throws MiException{
		
		if(this.infoProductoReglas==null) {
			throw new MiException("ERROR: No existen reglas para ese producto, no puede crear maquina");
		}
	
		ArrayList<String> reglas=this.infoProductoReglas.getReglasDeProducto(nombreProd);
		String menu=mensaje+"\n";
		for(int i=0;i<reglas.size();i++){
		menu=menu+(i+1)+":"+reglas.get(i)+"\n";
		}
		
		return menu;
	}
	
	
	public String getReglaPos(String producto,Integer i) throws MiException{
		return this.infoProductoReglas.getReglasDeProducto(producto).get(i);
	}
	
	
	
	public String productosManufacturados(String mensaje)throws MiException{
		if(this.productosManufacturados==null) {
			throw new MiException("ERROR:No existen productos manufacturados");
		}
		
		String menu=mensaje+"\n";
		for(int i=0;i<this.productosManufacturados.size();i++){
			menu=menu+(i+1)+":"+this.productosManufacturados.get(i)+"\n";
		}
		
		return menu;
	}
	
	
	//MUESTRA LISTADO DE MATERIAS PRIMA ACTUALES CON UN MENSAJE

	public String materiaPrima(String mensaje)throws MiException{
		if(this.materiaPrima==null) {
			throw new MiException("ERROR:No existe materia prima");
		}
		
		String menu=mensaje+"\n";
		for(int i=0;i<this.materiaPrima.size();i++){
			menu=menu+(i+1)+":"+this.materiaPrima.get(i)+"\n";
		}
		
		return menu;
	}
	

	//ACTUALIZA STOCK
	
	public void actualizarStockVista(ArrayList<String> stockActualizado){
		if(this.infoStock==null){
			this.infoStock=new InfoStock();
		}
		this.infoStock.setStockActual(stockActualizado);
	}
	
	public String stock(String mensaje) throws MiException {
		if(this.infoStock==null) {
			throw new MiException("ERROR: No hay stock");
		}
		
		String menu="*"+mensaje+"\n";
		for(int i=0;i<this.infoStock.getStockActual().size();i++){
			menu=menu+this.infoStock.getStockActual().get(i)+"\n";
		}
		
		return menu;
	}
	
	
	public String enFabricacion(String mensaje) throws MiException {
		if(this.infoMaquinas==null) {
			throw new MiException("ERROR: No hay productos en proceso de fabricación");
		}
		
		String menu="*"+mensaje+"\n";
		for(int i=0;i<this.infoMaquinas.getMaquinasActivasProducto().size();i++){
			menu=menu+this.infoMaquinas.getMaquinasActivasProducto().get(i)+"\n";
		}
		
		return menu;
	}

	
	public String unidadesMedida(String mensaje) {
		if(this.infoUnidades==null) {
			this.infoUnidades=new InfoUnidadMedida();
		}
		
		String menu=mensaje+"\n";
		for(int i=0;i<this.infoUnidades.getUnidadesMedida().length;i++){
			menu=menu+(i+1)+":"+this.infoUnidades.getUnidadesMedida()[i].getDescripcion()+"\n";
		}
		
		return menu;
	}
	
	
	public UnidadMedida getUnidadPos(Integer pos) {
		return this.infoUnidades.getPos(pos);
	}
	
	
	
	public String registro(String mensaje)throws MiException{
		if(this.infoRegistro==null) {
			throw new MiException("ERROR: No se registraron movimientos");
		}
		
		String menu="*"+mensaje+"\n";
		for(int i=0;i<this.infoRegistro.getRegistro().size();i++){
			menu=menu+this.infoRegistro.getRegistro().get(i)+"\n";
		}
		
		return menu;
	}
	
	
	
	public void actualizarRegistro(ArrayList<String> registroActualizado){
		if(this.infoRegistro==null) {
			this.infoRegistro=new InfoVentaCompraFab();
		}
		this.infoRegistro.actualizarRegistro(registroActualizado);
	}
	
}	
