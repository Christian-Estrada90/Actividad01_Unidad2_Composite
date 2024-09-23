/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
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
public class CarpetaController {
      
    public  void agregarArchivo(String nombre, String Tipo){
       Carpeta carpetaPrincipal = new Carpeta("Carpeta Principal");        
        switch (Tipo) {
            case "PDF":  
                ArchivoComponenteAbstract pdf1 = new ArchivoPDF(nombre+".pdf");
              carpetaPrincipal.agregar(pdf1);
              break;
            case "DOCX":
                ArchivoComponenteAbstract docx1 = new ArchivoDocx(nombre+".docx");
                carpetaPrincipal.agregar(docx1);
                break;
            case "XLSX":
               ArchivoComponenteAbstract xlsx1 = new ArchivoXlsx(nombre+".xlsx");
               carpetaPrincipal.agregar(xlsx1);
                break;
            case "Subcarpeta":  
               Carpeta subCarpeta = new Carpeta("Subcarpeta");
               ArchivoComponenteAbstract docx2 = new ArchivoDocx("SubDocumento.docx");
               subCarpeta.agregar(docx2);
               carpetaPrincipal.agregar(subCarpeta);
                break;    
            default:
                throw new AssertionError();
        }
       

        System.out.println("TamaÃ±o de la Carpeta Principal: "+nombre+ "-" + carpetaPrincipal.getTamano() + " KB");
}
}
