/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package ec.edu.ups.composite.controller;

import ec.edu.ups.composite.model.ArchivoComponenteAbstract;
import ec.edu.ups.composite.model.ArchivoDocx;
import ec.edu.ups.composite.model.ArchivoPDF;
import ec.edu.ups.composite.model.ArchivoXlsx;
import ec.edu.ups.composite.model.Carpeta;

/**
 *
 * @author Grupo 3
 */
public class Actividad01_Unidad2_Composite {

    public static void main(String[] args) {
        CarpetaController car = new CarpetaController();
        car.agregarArchivo("prueba 0", "PDF");
    }
}
