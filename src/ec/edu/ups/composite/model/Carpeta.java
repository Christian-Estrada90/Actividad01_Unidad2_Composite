/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.composite.model;

import java.util.ArrayList;
import java.util.List;

import ec.edu.ups.composite.controller.ArchivoComponenteAbstract;

/**
 *
 * @author user
 */
public class Carpeta extends ArchivoComponenteAbstract {
    private String nombre;
    private List<ArchivoComponenteAbstract> componentes;

    public Carpeta(String nombre) {
        this.nombre = nombre;
        this.componentes = new ArrayList<>();
    }

    public void agregar(ArchivoComponenteAbstract componente) {
        componentes.add(componente);
    }

    public void eliminar(ArchivoComponenteAbstract componente) {
        componentes.remove(componente);
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public int getTamano() {
        int tamanoTotal = 0;
        for (ArchivoComponenteAbstract componente : componentes) {
            tamanoTotal += componente.getTamano();
        }
        return tamanoTotal;
    }    
}
