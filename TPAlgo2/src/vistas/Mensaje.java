package vistas;

public enum Mensaje {
	MENU_USUARIO_OP_1("1-Dar de alta una materia prima\n"),
	MENU_USUARIO_OP_2("2-Dar de alta un producto manufacturado\n"),
	MENU_USUARIO_OP_3("3-Crear una regla de construccion\n"),
	MENU_USUARIO_OP_4("4-Dar de alta una maquina\n"),
	MENU_USUARIO_OP_5("5-Comenzar fabricaci�n de producto\n"),
	MENU_USUARIO_OP_6("6-Finalizar fabricaci�n de producto\n"),
	MENU_USUARIO_OP_7("7-Comprar materia prima\n"),
	MENU_USUARIO_OP_8("8-Vender producto manufacturado\n"),
	MENU_USUARIO_OP_9("9-Ver productos en proceso de fabricaci�n\n"),
	MENU_USUARIO_OP_10("10-Ver registro de compra y venta\n"),
	MENU_USUARIO_OP_11("11-ver stock de productos\n"),
	MENU_USUARIO_OP_12("12-Salir\n"),
	
	MENU_USUARIO_OPCION_INCORRECTA("Ingrese una opci�n v�lida:"),
	
	SELECCIONE_OPCION("Seleccione una opci�n:\n\n"),
	
	NOMBRE_MATERIA_PRIMA("Ingrese nombre materia prima"),
	
	SELECCION_CANTIDAD("Ingrese cantidad"),
	
	NOMBRE_PRODUCTO("Ingrese nombre del nuevo producto manufacturado"),
	
	SELECCION_PRODUCTO("Seleccione el producto manufacturado para asociar nueva regla\n"),
	
	SELECCION_MATERIA_PRIMA("Seleccione una materia prima:\n"),
	
	VOLVER_MENU("1-Volver al menu"),
	
	ALTA_MAQUINA_PROD("Ingrese producto que desea fabricar:"),
	
	MAQUINA_PEDIR_NOMBRE("Ingrese nombre para la nueva maquina"),
	
	PEDIR_CANT_REGLA("Ingrese el numero de elementos que tendr� la regla"),
	
	SELECCIONE_UNIDAD("Seleccione unidad de medida:\n"),
	
	
	STOCK_ACTUAL("Stock actual:\n"),
	
	MATERIA_PRIMA_OK("Materia prima dada de alta correctamente"),
	
	PRODUCTO_OK("Producto manufacturado dado de alta correctamente"),
	
	
	NOMBRE_UNIDAD_MEDIDA("Ingrese unidad de medida"),
	
	//VENTA
	VENTA_SELECT("Seleccione producto a vender"),
	VENTA_OK("Venta OK..."),
	VENTA_CANTIDAD("Ingrese cantidad a vender"),
	
	//MAQUINAS
	MENU_MAQUINA_1("Seleccione producto al que asociar� la nueva maquina"),
	MENU_MAQUINA_2("Seleccione regla de construcci�n que asociar� a esta m�quina:\n"),
	
	MAQUINA_OK("Maquina dada de alta correctamente"),
	MENU_MAQUINA_PERDIDAS("Seleccione el tipo de perdid� que tendr� la m�quina:\n"
				+ "1:Sin perdida 1\n"
				+ "2:P�rdida total\n"
				+ "3:P�rdida una unidad\n"
				+ "4:P�rdida de l�quidos\n"
				+ "5:P�rdida de gramos\n"
				+ "6:P�rdida del 50% en todos los elementos "),
	//FABRICACION
	FABRICACION_SELECT("Seleccione maquina con la que desea fabricar\n"),
	FABRICACION_SELECT_END("Seleccione maquina a finalizar\n"),
	FABRICACION_OK("La fabricaci�n de la m�quina seleccionada comenz� exiotosamente"),
	FABRICACION_END_OK("La m�quina seleccionada finaliz� su fabricaci�n correctamente"),
	FABRICACION_EN("En proceso de fabricaci�n:"),
	
	//REGISTRO
	REGISTRO("Registro de compras,ventas y fabricaciones"),
	
	//COMPRA
	COMPRA_SELECCION("Seleccione materia prima que desea comprar:\n"),
	COMPRA_CANTIDAD("Ingrese cantidad a comprar"),
	COMPRA_OK("Compra realizada exitosamente"),
	//REGLAS
	NOMBRE_REGLA("Ingrese un nombre para la nueva regla"),
	REGLA_OK("Regla creado correctamente\n"),
	
	MENU_REGLA("Seleccione tipo de producto que desea agregar a la regla de construccion:\n"
			+ "1:Materia prima\n"
			+ "2:Producto manufacturado\n"),
	MENU_REGLA_2("1:Seguir modificando regla\n"
			   + "2:Listo");
	
	
	
	private final String mensaje;

	Mensaje(String mensaje){
		this.mensaje=mensaje;
	}
	

	public String getMensaje() {
		return this.mensaje;	
	}
}
