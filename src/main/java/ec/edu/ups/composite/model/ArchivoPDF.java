/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.composite.model;

/**
 *
 * @author Grupo 3
 */
public class ArchivoPDF extends ArchivoComponenteAbstract {
    
    private String nombre;
    
    public ArchivoPDF(String nombre) {
        this.nombre = nombre;
    }


 @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public int getTamano() {
        return 50;
    }
    
}
