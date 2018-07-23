package tpFabrica;

public enum UnidadMedida {
	LITROS("Litros"),
	MILILITROS("Mililitros"),
	KILOGRAMOS("Kilos"),
	GRAMOS("Gramos"),
	MILIGRAMOS("Miligramos");

	private final String descripcion;
	
	UnidadMedida(String descripcion){
		this.descripcion=descripcion;
	}

	public String getDescripcion(){
		return this.descripcion;
	}

}
