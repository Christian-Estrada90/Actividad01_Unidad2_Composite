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
    
    @Override
    public String mostrarArchivo() {
        return "  Archivo pdf: " + this.getNombre() + " Tamanio :" + this.getTamanio() + " MB";
    }

    @Override
    public String toString() {
        return "pdf {" + this.getTamanio() + '}';
    }

    @Override
    public int getTamanio() {
        return 50;
    }
    
}
