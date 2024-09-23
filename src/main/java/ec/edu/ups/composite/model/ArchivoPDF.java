/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.composite.model;

import ec.edu.ups.composite.controller.ArchivoComponente;
import ec.edu.ups.composite.controller.ArchivoComponenteAbstract;

/**
 *
 * @author user
 */
public class ArchivoPDF extends ArchivoComponenteAbstract {
    
    private String nombre;
    private int tamano;
    
    public ArchivoPDF(String nombre, int tamano) {
        this.nombre = nombre;
        this.tamano = tamano;
    }


 @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public int getTamano() {
        return tamano;
    }
    
}
