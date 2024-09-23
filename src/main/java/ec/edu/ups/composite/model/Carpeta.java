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
