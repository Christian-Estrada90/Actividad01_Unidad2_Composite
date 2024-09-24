package ec.edu.ups.composite.controller;

import ec.edu.ups.composite.model.ArchivoComponenteAbstract;
import ec.edu.ups.composite.model.ArchivoDocx;
import ec.edu.ups.composite.model.ArchivoPDF;
import ec.edu.ups.composite.model.ArchivoXlsx;
import ec.edu.ups.composite.model.Carpeta;
import java.util.List;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

/**
 *
 * @author Grupo 3
 */
public class CarpetaArchivoController {

	ArchivoComponenteAbstract root;

	public CarpetaArchivoController() {
		root = new Carpeta();
		root.setNombre("root");
	}

	private Carpeta agregarArchivoRuta(Carpeta carpeta, String nombre, String tipo) {
		var ruta = nombre.split("/");
		if (ruta.length == 1) {
			switch (tipo) {
			case "Subcarpeta":
				var subcarpeta = new Carpeta();
				subcarpeta.setNombre(nombre);
				carpeta.agregar(subcarpeta);
				break;
			case "DOCX":
				var docx = new ArchivoDocx();
				docx.setNombre(nombre);
				carpeta.agregar(docx);
				break;
			case "XLSX":
				var xlsx = new ArchivoXlsx();
				xlsx.setNombre(nombre);
				carpeta.agregar(xlsx);
				break;
			case "PDF":
				var pdf = new ArchivoPDF();
				pdf.setNombre(nombre);
				carpeta.agregar(pdf);
				break;
			}
		} else {
			int item = 3;
			for (var archivo : carpeta.getListaArchivoComponent()) {
				if (archivo.getNombre().equals(ruta[0])) {
					var subcarpeta = (Carpeta) archivo;
					carpeta.eliminar(subcarpeta);
					var rutanombre = nombre.replaceFirst(ruta[0] + "/", "");
					carpeta.agregar(agregarArchivoRuta(subcarpeta, rutanombre, tipo));

					break;
				}
				item++;
			}
		}
		return carpeta;
	}

	public void agregarArchivo(String nombre, String tipo) {
		root = agregarArchivoRuta((Carpeta) root, nombre, tipo);
	}

	public void eliminarCarpeta(String ruta) {
		root = eliminar((Carpeta) root, ruta);
	}

	public void eliminarArchivo(String ruta, String file) {
		System.out.println("\n\n\n\n");
		eliminarArchivo((Carpeta) root, ruta, file);
	}

	private Carpeta eliminar(Carpeta carpeta, String ruta) {
		eliminarDirectorio(carpeta, ruta);
		return carpeta;
	}

	private void eliminarDirectorio(Carpeta carpeta, String ruta) {
		String rutaCompleta[] = ruta.split("/");
		String nombeCarpeta = rutaCompleta[0];
		if (carpeta.getListaArchivoComponent().isEmpty()) {
			return;
		}
		List<ArchivoComponenteAbstract> lista = carpeta.getListaArchivoComponent();
		for (ArchivoComponenteAbstract a : lista) {
			if (a.getNombre().equals(nombeCarpeta)) {
				if (rutaCompleta.length == 1) {
					carpeta.eliminar(a);
					return;
				}

				if (a instanceof Carpeta) {
					eliminarDirectorio((Carpeta) a, ruta.replace(nombeCarpeta + "/", ""));
				}

			}
		}
	}

	private void eliminarArchivo(Carpeta carpeta, String ruta, String file) {
		String rutaCompleta[] = ruta.split("/");
		String nombeCarpeta = rutaCompleta[0];
		if (carpeta.getListaArchivoComponent().isEmpty()) {
			return;
		}
		List<ArchivoComponenteAbstract> lista = carpeta.getListaArchivoComponent();
		for (ArchivoComponenteAbstract a : lista) {
			System.out.println("---> " + a.getNombre());
			if (ruta.equals("") && a.getNombre().equals(file.split("\\.")[0])) {
				carpeta.eliminar(a);
				return;
			}

			if (a instanceof Carpeta) {
				eliminarArchivo((Carpeta) a, ruta.replace(nombeCarpeta + "/", ""), file);
			}
		}
	}

	public DefaultTreeModel mostrar() {
		DefaultMutableTreeNode noderoot = new DefaultMutableTreeNode(
				root.getNombre() + " - " + String.valueOf(root.getTamanio()) + "mb");
		DefaultTreeModel model = new DefaultTreeModel(noderoot);

		for (var archivo : ((Carpeta) this.root).getListaArchivoComponent()) {
			DefaultMutableTreeNode node;
			if (archivo.getClass().getSimpleName().equals("Carpeta")) {

				if (((Carpeta) archivo).getListaArchivoComponent().isEmpty()) {
					node = new DefaultMutableTreeNode(
							archivo.getNombre() + " - " + String.valueOf(archivo.getTamanio()) + "mb");
				} else {
					node = obtenerNodo((Carpeta) archivo);
				}
			} else {
				node = new DefaultMutableTreeNode(archivo.getNombre() + "." + archivo.getClass().getSimpleName() + " - "
						+ String.valueOf(archivo.getTamanio()) + "mb");
			}
			noderoot.add(node);
		}
		return model;
	}

	private DefaultMutableTreeNode obtenerNodo(Carpeta carpeta) {
		DefaultMutableTreeNode nodeCarpeta = new DefaultMutableTreeNode(
				carpeta.getNombre() + " - " + String.valueOf(carpeta.getTamanio()) + "mb");
		for (var archivo : carpeta.getListaArchivoComponent()) {
			DefaultMutableTreeNode node;
			if (archivo.getClass().getSimpleName().equals("Carpeta")) {
				node = obtenerNodo((Carpeta) archivo);
			} else {
				node = new DefaultMutableTreeNode(archivo.getNombre() + "." + archivo.getClass().getSimpleName() + " - "
						+ String.valueOf(archivo.getTamanio()) + "mb");
			}
			nodeCarpeta.add(node);
		}
		return nodeCarpeta;
	}

}
