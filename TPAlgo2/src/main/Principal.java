package main;

import java.util.Scanner;

import controladores.MiControlador;
import modelo.Modelo;
import vistas.MiVistaUsuarioConsola;

public class Principal {

	public static void main(String[] args) {
		Modelo modelo=new Modelo();
		MiControlador controlador=new MiControlador();
		MiVistaUsuarioConsola vista=new MiVistaUsuarioConsola();
		
		
		controlador.setModelo(modelo);
		modelo.setVista(vista);
		vista.setControlador(controlador);
		
		vista.initVista();
		
	
	}

}
