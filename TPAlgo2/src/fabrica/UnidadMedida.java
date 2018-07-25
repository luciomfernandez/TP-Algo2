package fabrica;

public enum UnidadMedida {
	LITRO("Litros"),
	MILILITRO("Mililitros"),
	KILOGRAMO("Kilos"),
	GRAMO("Gramos"),
	UNIDAD("Unidades"),
	MILIGRAMO("Miligramos"),
	METRO("Metros"),
	METRO_CUADRADO("Metros cuadrados"),
	MILIMETRO("Milimetro");

	private final String descripcion;
	
	UnidadMedida(String descripcion){
		this.descripcion=descripcion;
	}

	public String getDescripcion(){
		return this.descripcion;
	}

}
