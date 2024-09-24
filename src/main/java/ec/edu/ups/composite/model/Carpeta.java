/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.composite.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Gruopo 3
 */
public class Carpeta extends ArchivoComponenteAbstract {

    private List<ArchivoComponenteAbstract> listComponente = new ArrayList<ArchivoComponenteAbstract>();

    public List<ArchivoComponenteAbstract> getListaArchivoComponent() {
        return listComponente;
    }

    public void setListaArchivoComponent(List<ArchivoComponenteAbstract> listaArchivoComponent) {
        this.listComponente = listaArchivoComponent;
    }

    public void agregar(ArchivoComponenteAbstract componente) {
        this.getListaArchivoComponent().add(componente);
    }

    public void eliminar(ArchivoComponenteAbstract componente) {
        this.getListaArchivoComponent().remove(componente);
    }

    @Override
    public int getTamanio() {
        int tamanoTotal = 0;
        for (ArchivoComponenteAbstract componente : listComponente) {
            tamanoTotal += componente.getTamanio();
        }
        return tamanoTotal;
    }

    @Override
    public String mostrarArchivo() {
        String texto = "";
        for (ArchivoComponenteAbstract lista : this.getListaArchivoComponent()) {
            texto += " Archivos: " + lista.getNombre() + " Tamanio :" + lista.getTamanio();
        }
        return texto;
    }
}
