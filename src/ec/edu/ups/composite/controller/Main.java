/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.composite.controller;

import ec.edu.ups.composite.model.ArchivoDocx;
import ec.edu.ups.composite.model.ArchivoPDF;
import ec.edu.ups.composite.model.ArchivoXlsx;
import ec.edu.ups.composite.model.Carpeta;

/**
 *
 * @author user
 */
public class Main {
     public static void main(String[] args) {
        ArchivoComponenteAbstract pdf1 = new ArchivoPDF("Documento1.pdf", 500);
        ArchivoComponenteAbstract docx1 = new ArchivoDocx("Documento2.docx", 300);
        ArchivoComponenteAbstract xlsx1 = new ArchivoXlsx("Hoja1.xlsx", 100);

        Carpeta carpetaPrincipal = new Carpeta("Carpeta Principal");
        carpetaPrincipal.agregar(pdf1);
        carpetaPrincipal.agregar(docx1);
        carpetaPrincipal.agregar(xlsx1);

        Carpeta subCarpeta = new Carpeta("Subcarpeta");
        ArchivoComponenteAbstract docx2 = new ArchivoDocx("SubDocumento.docx", 200);
        subCarpeta.agregar(docx2);
        carpetaPrincipal.agregar(subCarpeta);

        System.out.println("Tamaño de la Carpeta Principal: " + carpetaPrincipal.getTamano() + " KB");
    }
}
