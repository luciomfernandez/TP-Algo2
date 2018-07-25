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
		
		
		modelo.registrarCompra("Madera", 10000);
		modelo.registrarCompra("Metal", 10000);
		modelo.registrarCompra("Piedra", 10000);
		modelo.registrarCompra("Marmol", 10000);
		modelo.registrarCompra("Ladrillo", 10000);
		modelo.registrarCompra("Pegamento", 10000);
		modelo.registrarCompra("Cemento", 10000);
		modelo.registrarCompra("Pintura", 10000);
		modelo.registrarCompra("Vidrio", 10000);		
		modelo.registrarCompra("Clavo", 10000);		
		
		
		modelo.altaProducto("Pared", UnidadMedida.METRO_CUADRADO);
		modelo.altaProducto("Puerta", UnidadMedida.METRO_CUADRADO);
		modelo.altaProducto("Techo", UnidadMedida.METRO_CUADRADO);
		modelo.altaProducto("Ventana", UnidadMedida.METRO);
		modelo.altaProducto("Casa", UnidadMedida.METRO_CUADRADO);
		modelo.altaProducto("Habitacion", UnidadMedida.METRO_CUADRADO);
		modelo.altaProducto("Pared_puerta", UnidadMedida.METRO_CUADRADO);

		//REGLA_PARED
		ArrayList<NombreCant> nc1= new ArrayList<NombreCant>();
		nc1.add(new NombreCant("Ladrillo",200));
		nc1.add(new NombreCant("Cemento",1));
		nc1.add(new NombreCant("Pintura",2));
		modelo.altaRegla("Pared", "Regla_pared_1", nc1);
		
		
		//REGLA_PUERTA
		ArrayList<NombreCant> nc2= new ArrayList<NombreCant>();
		nc2.add(new NombreCant("Madera",20));
		nc2.add(new NombreCant("Pegamento",1));
		nc2.add(new NombreCant("Clavo",100));
		modelo.altaRegla("Puerta", "Regla_puerta_1", nc2);
		
		
		//REGLA_PARED_CON_PUERTA
		ArrayList<NombreCant> nc3= new ArrayList<NombreCant>();
		nc3.add(new NombreCant("Puerta",1));
		nc3.add(new NombreCant("Pared",1));
		modelo.altaRegla("Pared_puerta", "Regla_pared_puerta", nc3);
		
		
		//REGLA_TECHO
		ArrayList<NombreCant> nc4= new ArrayList<NombreCant>();
		nc4.add(new NombreCant("Ladrillo",400));
		nc4.add(new NombreCant("Cemento",5));
		nc4.add(new NombreCant("Pintura",3));
		modelo.altaRegla("Techo", "Regla_techo", nc4);
		
		//MAQUINAS
		modelo.altaMaquina("MaquinaTecho", "Techo", "Regla_techo", 1);
		modelo.altaMaquina("MaquinaPared", "Pared", "Regla_pared_1", 1);
		modelo.altaMaquina("MaquinaPared_Puerta", "Pared_puerta", "Regla_pared_puerta", 1);
		modelo.altaMaquina("MaquinaPuerta","Puerta" , "Regla_puerta_1",1);
	}

}
