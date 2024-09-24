package ec.edu.ups.composite.model;

/**
 *
 * @author Grupo 3
 */
public class ArchivoDocx extends ArchivoComponenteAbstract {

	@Override
	public String mostrarArchivo() {
		return "  Archivo docx: " + this.getNombre() + " Tamanio :" + this.getTamanio() + " MB";
	}

	@Override
	public String toString() {
		return "docx {" + this.getTamanio() + '}';
	}

	@Override
	public int getTamanio() {
		return 150;
	}

}
