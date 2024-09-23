package ec.edu.ups.patron.composite.model;

import ec.edu.ups.patron.composite.controller.ArchivoComponent;

public class ArchivoDocx extends ArchivoComponent{
	
	@Override
	public String mostrarArchivo() {
		return "Archivo: ";
	}

	@Override
	public String getTamanio() {
		// TODO Auto-generated method stub
		return null;
	}

	

}
