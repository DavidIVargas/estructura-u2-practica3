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

    public Nodo getRoot() {
        return raiz;
    }

    public void insert(Contacto newContacto) {
        if (raiz == null) {
            raiz = new Nodo(newContacto);
        } else {
            insertRecursivo(raiz, newContacto);
        }
    }

    private void insertRecursivo(Nodo nodo, Contacto newContacto) {
        if (newContacto.getNombre().compareTo(nodo.getContacto().getNombre()) < 0) {
            if (nodo.getLeft() == null) {
                nodo.setLeft(new Nodo(newContacto));
            } else {
                insertRecursivo(nodo.getLeft(), newContacto);
            }

        } else if (newContacto.getNombre().compareTo(nodo.getContacto().getNombre()) > 0) {
            if (nodo.getRight() == null) {
                nodo.setRight(new Nodo(newContacto));
            } else {
                insertRecursivo(nodo.getRight(), newContacto);
            }
        } else {
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

    private int obtenerAltura(Nodo nodo) {
        if (nodo == null) {
            return 0;
        }
        int alturaIzquierda = obtenerAltura(nodo.getLeft());
        int alturaDerecha = obtenerAltura(nodo.getRight());

        return Math.max(alturaIzquierda, alturaDerecha) + 1;
    }

    //{Elinminar un nodo}
    private void eliminarContacto(String nombre) {
        raiz = eliminarContactoRecursivo(raiz, nombre);

    }

    private Nodo eliminarContactoRecursivo(Nodo nodo, String nombre) {
        //Caso base: si el nodo es nulo, no se puede eliminar.
        if (nodo == null) {
            return nodo;
        }
        //Buscar el nodo a eliminar segun el nombre que llega como argumento
        if (nombre.compareTo(nodo.getLeft().getContacto().getNombre()) < 0) {
            //si el nombre es menor, es decir si nombre del contacto esta en el 
            //subarbol izquierdo
            nodo.setLeft(eliminarContactoRecursivo(nodo.getLeft(), nombre));
        } else if (nombre.compareTo(nodo.getRight().getContacto().getNombre()) > 0) {
            //Si el nombre es mayor, es decir si el nombre del contacto esta en el 
            //subarbol derecho
            nodo.setRight(eliminarContactoRecursivo(nodo.getRight(), nombre));
        } else {
            //si el nombre coicide, el nodo es que le deberias eliminar
            ///caso 1
            if (nodo.getLeft() == null && nodo.getRight() == null) {
                return null;
            }
            //caso 2: que el nodo a elimianr tena un solo hijo
            if (nodo.getLeft() == null) {
                return nodo.getRight();
            } else if (nodo.getRight() == null) {
                return nodo.getLeft();
            }

            //Caso 3: nodo con dos hijos
            Nodo susesor = encontrarMinimo(nodo.getRight());
            //Analizamos el objeto contacto con el obtenido en [encontrarMinimo]
            nodo.setContacto(susesor.getContacto());
            nodo.setRight(eliminarContactoRecursivo(nodo.getRight(), susesor.getContacto().getNombre()));
        }
        return nodo;
    }

    //El menor nodo de lado derecho de un nodo
    private Nodo encontrarMinimo(Nodo nodo) {
        while (nodo.getLeft() != null) {
            nodo = nodo.getLeft();
        }
        return nodo;
    }

    public void printTreeNode(Nodo root, String prefix, boolean isLeft) {
        if (root != null) {
            System.out.println(prefix + (isLeft ? "|-- " : "\\-- ") + root.getContacto());
            printTreeNode(root.getLeft(), prefix + (isLeft ? "|   " : "    "), true);
            printTreeNode(root.getRight(), prefix + (isLeft ? "    " : "|   "), false);
        }
    }
}
