/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.practica_3;

import com.mycompany.practica_3.modelo.Contacto;
import com.mycompany.practica_3.controlador.ArbolContactos;

/**
 *
 * @author ESTUDIANTE
 */
public class Practica_3 {

    public static void main(String[] args) {
        ArbolContactos arbol = new ArbolContactos();
        
        Contacto c1 = new Contacto("Juan", "0981446108");
        Contacto c2 = new Contacto("Maria", "0912345678");
        Contacto c3 = new Contacto("Pedro", "0933442231");
        Contacto c4 = new Contacto("Pablo", "0922314142");
        
        arbol.insert(c1);
        arbol.insert(c2);
        arbol.insert(c3);
        arbol.insert(c4);
        arbol.insert(new Contacto("Juliana", "0912141211"));
        arbol.insert(new Contacto("Jhon", "0978126173"));
        System.out.println(" ");
        //arbol.eliminarContacto("/n");
        //arbol.printTreeNodo(arbol.getRoot(), prefix:"",isLeft:true);
    }
}
