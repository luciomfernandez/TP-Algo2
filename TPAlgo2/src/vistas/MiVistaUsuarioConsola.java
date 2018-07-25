package vistas;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import javax.swing.SingleSelectionModel;

import controladores.Controlador;
import excepciones.MiException;
import fabrica.UnidadMedida;


public class MiVistaUsuarioConsola implements VistaUsuario {
	
	private Scanner scanner;
	private Controlador controlador;
	private InfoVista infoVista;
	
	
	
	public MiVistaUsuarioConsola(){
		scanner=new Scanner(System.in);
		this.infoVista=new InfoVista();
	}
	
	
	//PROPIA
	public void mostrarMenu() {
		Integer opcion;
		String menu=Mensaje.SELECCIONE_OPCION.getMensaje()+
					Mensaje.MENU_USUARIO_OP_1.getMensaje()+
					Mensaje.MENU_USUARIO_OP_2.getMensaje()+
					Mensaje.MENU_USUARIO_OP_3.getMensaje()+
					Mensaje.MENU_USUARIO_OP_4.getMensaje()+
					Mensaje.MENU_USUARIO_OP_5.getMensaje()+
					Mensaje.MENU_USUARIO_OP_6.getMensaje()+
					Mensaje.MENU_USUARIO_OP_7.getMensaje()+
					Mensaje.MENU_USUARIO_OP_8.getMensaje()+
					Mensaje.MENU_USUARIO_OP_9.getMensaje()+
					Mensaje.MENU_USUARIO_OP_10.getMensaje()+
					Mensaje.MENU_USUARIO_OP_11.getMensaje()+
					Mensaje.MENU_USUARIO_OP_12.getMensaje();

		do {
			
			opcion=this.pedirIntegerConsolaSinLimpiar(menu);
			
			switch(opcion) {
				case 1:
					altaMateriaPrima();
					break;
				case 2:
					altaProducto();
					break;
				case 3:
					try{
						altaReglaConstruccion();
					}catch(MiException e){
						this.mostrarMensaje(e.getMessage());
					}
					break;
				case 4:
					try {
						altaMaquina();
					}catch(MiException e) {
						this.mostrarMensaje(e.getMessage());
					}
					break;
				case 5:
					try {
						this.initFabricacion();
					}catch(MiException e) {
						this.mostrarMensaje(e.getMessage());
					}
					break;
				case 6:
					try {
						this.endFabricacion();
					}catch(MiException e) {
						this.mostrarMensaje(e.getMessage());
					}
					break;
				case 7:
					try {
						this.compraMP();
					}catch(MiException e) {
						this.mostrarMensaje(e.getMessage());
					}
					break;
				case 8:
					try {
						this.ventaProducto();
					}catch(MiException e) {
						this.mostrarMensaje(e.getMessage());
					}
					break;
				case 9:
					try {
						this.enFabricacion();
					}catch(MiException e) {
						this.mostrarMensaje(e.getMessage());
					}
					break;
				case 10:
					try {
						this.registro();
					}catch(MiException e) {
						this.mostrarMensaje(e.getMessage());
					}
					break;
				case 11:
					try {
						this.stock();
					}catch(MiException e) {
						this.mostrarMensaje(e.getMessage());
					}
					break;
				case 12:
					System.exit(0);
					break;
				default:
					this.mostrarMensaje(Mensaje.MENU_USUARIO_OPCION_INCORRECTA.getMensaje());
			}
			
		}while(true);
		
	}
	
	
	public void mostrarMensaje(String mensaje) {
		System.out.println(mensaje);
	}

	public void mostrarMensajeLimpiando(String mensaje) {
		refresh(50);
		System.out.println(mensaje);
	}
	
	public void altaMateriaPrima(){
		String nombre=null;
		UnidadMedida unidadMedida=null;
		Integer opcion;
		String menu=this.infoVista.unidadesMedida(Mensaje.SELECCIONE_UNIDAD.getMensaje());
		nombre=this.pedirStringConsola(Mensaje.NOMBRE_MATERIA_PRIMA.getMensaje());
		opcion=this.pedirIntegerConsola(menu);
		unidadMedida=this.infoVista.getUnidadPos(opcion-1);		
		
		this.peticionAltaMateriaPrima(nombre,unidadMedida);
	}

	
	public void altaProducto(){
		String nombre=null;
		UnidadMedida unidadMedida=null;
		Integer opcion;
		String menu=this.infoVista.unidadesMedida(Mensaje.SELECCIONE_UNIDAD.getMensaje());
		nombre=this.pedirStringConsola(Mensaje.NOMBRE_PRODUCTO.getMensaje());
		opcion=this.pedirIntegerConsola(menu);
		unidadMedida=this.infoVista.getUnidadPos(opcion-1);

				
		this.peticionAltaProducto(nombre, unidadMedida);
	
	}
	
	public void altaReglaConstruccion() throws MiException {
		Boolean seguirCargando=true;
		Integer opcion;
		Integer cantidad;
		String nombre;
		String nombreRegla;
		String nombreProdAFabricar;
		String menu;
		
		menu=this.infoVista.productosManufacturados(Mensaje.SELECCION_PRODUCTO.getMensaje());
		opcion=this.pedirIntegerConsola(menu);
		nombreProdAFabricar=this.infoVista.getProductoPos(opcion-1);		
		nombreRegla=this.pedirStringConsola(Mensaje.NOMBRE_REGLA.getMensaje());
		ArrayList<NombreCant> nombresCant = new ArrayList<NombreCant>();
		
		while(seguirCargando){
			
			
			opcion=this.pedirIntegerConsola(Mensaje.MENU_REGLA.getMensaje());
			switch(opcion) {
				case 1:			
					try {
						menu=this.infoVista.materiaPrima(Mensaje.SELECCION_MATERIA_PRIMA.getMensaje());
						opcion=this.pedirIntegerConsola(menu);
						nombre=this.infoVista.getMateriaPrimaPos(opcion-1);
						cantidad=this.pedirIntegerConsola(Mensaje.SELECCION_CANTIDAD.getMensaje());
						nombresCant.add(new NombreCant(nombre,cantidad));
									
						
					}catch(MiException e) {
						this.mostrarMensaje(e.getMessage());
					}
					break;
				case 2:
					menu=this.infoVista.productosManufacturados(Mensaje.SELECCION_PRODUCTO.getMensaje());
					opcion=this.pedirIntegerConsola(menu);
					nombre=this.infoVista.getProductoPos(opcion-1);
					cantidad=this.pedirIntegerConsola(Mensaje.SELECCION_CANTIDAD.getMensaje());
					nombresCant.add(new NombreCant(nombre,cantidad));
					break;
			}
		
			
			opcion=this.pedirIntegerConsola(Mensaje.MENU_REGLA_2.getMensaje());
			if(opcion==2)seguirCargando=false;
		}
		
		this.controlador.peticionAltaRegla(nombreProdAFabricar, nombreRegla, nombresCant);
	}
	
	

	
	
	public void altaMaquina() throws MiException {
		Integer opcion;
		String nombreProducto;
		String nombreMaquina;
		String nombreRegla;
		Integer tipoPerdida;
		String menu;
		String menuReglas;
		
		menu=this.infoVista.productosManufacturados(Mensaje.MENU_MAQUINA_1.getMensaje());
		opcion=this.pedirIntegerConsola(menu);
		nombreProducto=this.infoVista.getProductoPos(opcion-1);
		
		menuReglas=this.infoVista.getReglasProducto(nombreProducto, Mensaje.MENU_MAQUINA_2.getMensaje());
		opcion=this.pedirIntegerConsola(menuReglas);
		nombreRegla=this.infoVista.getReglaPos(nombreProducto, opcion-1);
		
		
		tipoPerdida=this.pedirIntegerConsola(Mensaje.MENU_MAQUINA_PERDIDAS.getMensaje());
		nombreMaquina=this.pedirStringConsola(Mensaje.MAQUINA_PEDIR_NOMBRE.getMensaje());
		
		this.peticionAltaMaquina(nombreMaquina,nombreProducto,nombreRegla,tipoPerdida);
	}
	
	
	
	public void initFabricacion() throws MiException{
		Integer opcion;
		String nombreMaquina;
		
		String menu=this.infoVista.maquinas(Mensaje.FABRICACION_SELECT.getMensaje());
		opcion=this.pedirIntegerConsola(menu);
		nombreMaquina=this.infoVista.getNombreMaquina(opcion-1);
		System.out.println("Maquina seleccionada:"+nombreMaquina);
		this.peticionInitFabricacion(nombreMaquina);
	
	}
	
	
	public void endFabricacion() throws MiException{
		Integer opcion;
		String nombreMaquina;
		
		String menu=this.infoVista.maquinas2(Mensaje.FABRICACION_SELECT_END.getMensaje());
		opcion=this.pedirIntegerConsola(menu);
		nombreMaquina=this.infoVista.getNombreMaquina(opcion-1);
		System.out.println("Maquina seleccionada:"+nombreMaquina);
		this.peticionEndFabricacion(nombreMaquina);
	
	
	}
	
	
	public void compraMP() throws MiException {
		String nombre;
		Integer cantidad;
		String menu;
		Integer opcion;
		
		menu=this.infoVista.materiaPrima(Mensaje.COMPRA_SELECCION.getMensaje());
		opcion=this.pedirIntegerConsola(menu);
		nombre=this.infoVista.getMateriaPrimaPos(opcion-1);
		cantidad=this.pedirIntegerConsola(Mensaje.COMPRA_CANTIDAD.getMensaje());
		
		this.peticionCompraMP(nombre, cantidad);
		
	}
	
	public void ventaProducto() throws MiException{
		Integer opcion;
		String nombre;
		Integer cantidad;
		String menu=this.infoVista.productosManufacturados(Mensaje.VENTA_SELECT.getMensaje());
		opcion=this.pedirIntegerConsola(menu);
		nombre=this.infoVista.getProductoPos(opcion-1);
		cantidad=this.pedirIntegerConsola(Mensaje.VENTA_CANTIDAD.getMensaje());
		
		this.peticionVenta(nombre,cantidad);
	}
	
	
	
	public void stock()throws MiException {
		String menu=this.infoVista.stock(Mensaje.STOCK_ACTUAL.getMensaje());
		this.mostrarMensajeLimpiando(menu);
		Integer opcion=this.pedirIntegerConsolaSinLimpiar("1:Volver al menú");
		
	}
	
	
	public void enFabricacion() throws MiException{	
		String menu=this.infoVista.enFabricacion(Mensaje.FABRICACION_EN.getMensaje());
		this.mostrarMensajeLimpiando(menu);
		Integer opcion=this.pedirIntegerConsolaSinLimpiar("1:Volver al menú");
	}
	
	
	public void registro() throws MiException{
		String menu=this.infoVista.registro(Mensaje.REGISTRO.getMensaje());
		this.mostrarMensajeLimpiando(menu);
		Integer opcion=this.pedirIntegerConsolaSinLimpiar("1:Volver al menú");
	}
	
	
	
	
	//PROPIA
	public String pedirStringConsola(String mensaje) {
		this.refresh(50);
		System.out.println(mensaje);
		String entrada;
		entrada=scanner.next();
		return entrada;
	}

	
	//PROPIA
	public String pedirStringConsolaSinLimpiar(String mensaje) {
		System.out.println(mensaje);
		String entrada;
		entrada=scanner.next();
		return entrada;
	}
	
	//PROPIA
	public Integer pedirIntegerConsola(String mensaje) {
		this.refresh(50);
		Integer entrada=0;
		while(entrada==0) {
			try {
				System.out.println(mensaje);
				entrada=scanner.nextInt();
			}catch(Exception e){
				this.mostrarMensaje("Ingrese un valor entero");		
				scanner.nextLine();
			}
		}
		return entrada;
	}
	
	
	
	public Integer pedirIntegerConsolaSinLimpiar(String mensaje) {
		Integer entrada=0;
		while(entrada==0) {
			try {
				System.out.println(mensaje);
				entrada=scanner.nextInt();
			}catch(Exception e){
				this.mostrarMensaje("Ingrese un valor entero");		
				scanner.nextLine();
			}
		}
		return entrada;
	}
//******************************************a**	/*ALTA MATERIA PRIMA*/ ******************************************************
	//SOBREESCRIBRE DE INTERFAZ
	public void peticionAltaMateriaPrima(String nombre, UnidadMedida unidadMedida){
		this.controlador.peticionAltaMP(nombre, unidadMedida);
	}

	//SOBREESCRIBE DE INTERFAZ
	public void onAltaMP(String mp, String err){
		if(err!=null){
			this.mostrarMensaje(err);
		}else {
			this.infoVista.agregarMateriaPrima(mp);
			this.mostrarMensaje(Mensaje.MATERIA_PRIMA_OK.getMensaje());
		}
		
	}

	//********************************************	/*ALTA PRODUCTO*/ ******************************************************	
	//SOBREESCRIBE DE INTERFAZ
	public void peticionAltaProducto(String nombre,UnidadMedida unidadMedida){
		this.controlador.peticionAltaP(nombre,unidadMedida);
	}
	
	//SOBREESCRIBE DE INTERFAZ
	public void onAltaProducto(String producto,String err) {
		if(err!=null){
			this.mostrarMensaje(err);
		}else {
			this.infoVista.agregarProducto(producto);
			this.mostrarMensaje(Mensaje.PRODUCTO_OK.getMensaje());
		}
	}	
	
	//********************************************	/*ALTA REGLA CONSTRUCCION*/ ******************************************************
	
	
		//SOBREESCRIBE DE INTERFAZ
		public void peticionAltaRegla(String nombreProducto,String nombreRegla, ArrayList<NombreCant> nc){
			this.controlador.peticionAltaRegla(nombreProducto,nombreRegla,nc);
		}
		
		//SOBREESCRIBE DE INTERFAZ
		public void onAltaRegla(String nombreRegla, String nombreProducto, String err) {
			if(err!=null){
				this.mostrarMensaje(err);
			}else {
				this.infoVista.agregarProductoRegla(nombreProducto, nombreRegla);
				this.mostrarMensaje(Mensaje.REGLA_OK.getMensaje());
			}
		}
		
	//********************************************	/*ALTA MAQUINA*/ ******************************************************	
	public void peticionAltaMaquina(String nombreMaquina,String nombreProducto,String nombreRegla,Integer tipoPerdida) {
		this.controlador.peticionAltaMaquina(nombreMaquina,nombreProducto,nombreRegla,tipoPerdida);
	}
	
	public void onAltaMaquina(String nombreMaquina,String nombreProducto,String err) {
		if(err!=null){
			this.mostrarMensaje(err);
		}else {
			this.infoVista.agregarMaquinaProducto(nombreMaquina, nombreProducto);
			this.mostrarMensaje(Mensaje.MAQUINA_OK.getMensaje());
		}
	}
	//****************************************** /*PETICION FABRICAR/******************************************************
	public void peticionInitFabricacion(String nombreMaquina){
		this.controlador.peticionInitFabricacion(nombreMaquina);
	}
	
	public void onInitFabricacion(String nombreMaquina,String nombreProducto, String err) {
		if(err!=null) {
			this.mostrarMensaje(err);
		}else {
			this.infoVista.agregarMaquinaProductoActivas(nombreMaquina, nombreProducto);
			this.mostrarMensaje(Mensaje.FABRICACION_OK.getMensaje());
		}
	}
	
	
	//*****************************************/PETICION END FABRICACION/******************************************************
	
	public void peticionEndFabricacion(String nombreMaquina) {
		this.controlador.peticionEndFabricacion(nombreMaquina);
	}
	
	
	public void onEndFabricacion(String nombreMaquina, String err) {
		if(err!=null) {
			this.mostrarMensaje(err);
		}else {
			this.infoVista.quitarMaquinaActiva(nombreMaquina);
			this.mostrarMensaje(Mensaje.FABRICACION_END_OK.getMensaje());
		}
	}
	
	
	
	//*****************************************/PETICION COMPRA/*********************************************
	public void peticionCompraMP(String nombre,Integer cantidad) {
		this.controlador.peticionComprarMateriPrima(nombre, cantidad);
	}
	
	
	//**************************************/PETICION VENTA/*********************************************
	
	public void peticionVenta(String nombreProducto,Integer cantidad) {
		this.controlador.peticionVentaProducto(nombreProducto, cantidad);
	}
	
	
	public void onVentaProducto(String err) {
		if(err!=null) {
			this.mostrarMensaje(err);
		}else {
			this.mostrarMensaje(Mensaje.VENTA_OK.getMensaje());
		}
	}
	//**************************************/ACTUALIZA STOCK/************************************************
	public void onActualizaStock(ArrayList<String> stockActualizado){
		this.infoVista.actualizarStockVista(stockActualizado);
	}
		
	//*******************************/ACTUALIZACION REGISTRO COMPRA VENTA FAB/************************************************
	public void onActualizaRegistro(ArrayList<String> registroActualizado){
		this.infoVista.actualizarRegistro(registroActualizado);
	}
	
	//SOBREESCRIBE DE INTERFAZ
	public void initVista() {
		
		this.mostrarMenu();
			
	}
	
	//SOBREESCRIBE DE INTERFAZ
	public void setControlador(Controlador controlador){
		this.controlador=controlador;
	}
	
	
	////////////////	
	//Limpiar consola, no encontre una forma que funcione con Windows
	public void refresh(Integer max) {
		for (int i=0; i < max; i++){
		  System.out.println();
		 }
	}

	
}