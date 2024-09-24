package ec.edu.ups.composite.model;

/**
 *
 * @author Grupo 3
 */
public abstract class ArchivoComponenteAbstract {

	private String nombre;

	public abstract int getTamanio();

	public abstract String mostrarArchivo();

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
