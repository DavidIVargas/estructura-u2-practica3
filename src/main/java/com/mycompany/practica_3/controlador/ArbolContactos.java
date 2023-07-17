/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practica_3.controlador;

import com.mycompany.practica_3.modelo.Contacto;
import com.mycompany.practica_3.modelo.Nodo;

/**
 *
 * @author ESTUDIANTE
 */
public class ArbolContactos {

    private Nodo raiz;

    public ArbolContactos() {
        this.raiz = null;
    }

    public void insert(Contacto newContacto) {
        if (raiz == null) {
            raiz = new Nodo(newContacto);
        } else {
            insertRecursivo(raiz, newContacto);
        }
    }

    private void insertRecursivo(Nodo nodo, Contacto newContacto) {
        if(newContacto.getNombre().compareTo(nodo.getContacto().getNombre()) < 0){
            if(nodo.getLeft() == null){
                nodo.setLeft(new Nodo(newContacto));
            } else{
                insertRecursivo(nodo.getLeft(), newContacto);
            }
            
        } else if(newContacto.getNombre().compareTo(nodo.getContacto().getNombre()) > 0){
            if(nodo.getRight() == null){
                nodo.setRight(new Nodo(newContacto));
            }else {
                insertRecursivo(nodo.getRight(), newContacto);
            }
        }else{
            /// Si el nombre del contacto nuevo es igual a un oexistente
        }
    }

    public boolean estaEquilibrado() {
        return verificarBalance(raiz);
    }

    private boolean verificarBalance(Nodo nodo) {
        if (nodo == null) {
            return true;
        }
        int alturaIzquierda = obtenerAltura(nodo.getLeft());
        int alturaDerecha = obtenerAltura(nodo.getRight());
        int diferencia = Math.abs(alturaIzquierda - alturaDerecha);
        if (diferencia > 1) {
            return false;
        }
        return verificarBalance(nodo.getLeft()) && verificarBalance(nodo.getRight()); 
    }
    

     private int obtenerAltura(Nodo nodo){
        if(nodo == null){
            return 0;
        }
        int alturaIzquierda= obtenerAltura(nodo.getLeft());
        int alturaDerecha = obtenerAltura(nodo.getRight());
        
        return Math.max(alturaIzquierda, alturaDerecha)+1;
    }
}
