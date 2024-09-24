/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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
