package ec.edu.ups.patron.composite.model;

import ec.edu.ups.patron.composite.controller.ArchivoComponent;

public class ArchivoPDF extends ArchivoComponent{

	private double tamanio;
	
	@Override
	public String mostrarArchivo() {
		return "Archivo: ";
	}

	@Override
	public String getNombre() {
		return this.getNombre() + ".pdf";
	}

}
