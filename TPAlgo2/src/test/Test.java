package test;

import java.util.ArrayList;

import fabrica.UnidadMedida;
import modelo.Modelo;
import vistas.NombreCant;

public class Test {
	public static void testCasas(Modelo modelo){
		modelo.altaMateriaPrima("Madera",UnidadMedida.UNIDAD);
		modelo.altaMateriaPrima("Metal",UnidadMedida.UNIDAD);
		modelo.altaMateriaPrima("Cemento",UnidadMedida.KILOGRAMO);
		modelo.altaMateriaPrima("Piedra",UnidadMedida.KILOGRAMO);
		modelo.altaMateriaPrima("Marmol",UnidadMedida.UNIDAD);
		modelo.altaMateriaPrima("Ladrillo",UnidadMedida.UNIDAD);
		modelo.altaMateriaPrima("Pegamento",UnidadMedida.MILILITRO);	
		modelo.altaMateriaPrima("Pintura",UnidadMedida.LITRO);
		modelo.altaMateriaPrima("Vidrio",UnidadMedida.METRO_CUADRADO);		
		modelo.altaMateriaPrima("Clavo", UnidadMedida.UNIDAD);
		
		
		//modelo.registrarCompra("Madera", 10000);
		modelo.registrarCompra("Metal", 10000);
		modelo.registrarCompra("Piedra", 10000);
		//modelo.registrarCompra("Marmol", 10000);
		modelo.registrarCompra("Ladrillo", 10000);
		modelo.registrarCompra("Pegamento", 10000);
		//modelo.registrarCompra("Cemento", 10000);
		modelo.registrarCompra("Pintura", 10000);
		//modelo.registrarCompra("Vidrio", 10000);		
		
		
		
		modelo.altaProducto("Pared", UnidadMedida.METRO_CUADRADO);
		modelo.altaProducto("Puerta", UnidadMedida.METRO_CUADRADO);
		modelo.altaProducto("Techo", UnidadMedida.METRO_CUADRADO);
		modelo.altaProducto("Ventana", UnidadMedida.METRO);
		modelo.altaProducto("Casa", UnidadMedida.METRO_CUADRADO);
		modelo.altaProducto("Habitacion", UnidadMedida.METRO_CUADRADO);
	
		
		//REGLA_PARED
		ArrayList<NombreCant> nc1= new ArrayList<NombreCant>();
		nc1.add(new NombreCant("Ladrillo",200));
		nc1.add(new NombreCant("Cemento",1));
		nc1.add(new NombreCant("Pintura",2));

		//REGLA_PUERTA
		ArrayList<NombreCant> nc2= new ArrayList<NombreCant>();
		nc2.add(new NombreCant("Madera",20));
		nc2.add(new NombreCant("Pegamento",1));
		nc2.add(new NombreCant("Clavo",100));
		
		
		modelo.altaRegla("Pared", "Regla_pared_1", nc1);
		modelo.altaRegla("Puerta", "Regla_puerta_1", nc2);
	
	}

}
