/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author HP
 */
public class ColaPrioridad<T> extends Cola<T> {
    private class NodoP<T> extends Nodo<T> {
        int prioridad;
        public NodoP(T dato, int prioridad) {
            super(dato);
            this.prioridad = prioridad;
        }        
    }
    
    public void agregar(T dato, int prioridad) {
        NodoP nuevo = new NodoP(dato, prioridad);

        if (primero == null || prioridad < ((NodoP) primero).prioridad) {
            nuevo.siguiente = primero;
            primero = nuevo;
            if (ultimo == null) ultimo = nuevo;
        } else {
            NodoP temp = (NodoP) primero;
            while (temp.siguiente != null && ((NodoP) temp.siguiente).prioridad <= prioridad) {
                temp = (NodoP) temp.siguiente;
            }
            nuevo.siguiente = temp.siguiente;
            temp.siguiente = nuevo;
            if (nuevo.siguiente == null) ultimo = nuevo; 
        }
        tamanio++;
    }
    
    @Override
    public void agregar(T dato) {
        throw new IllegalStateException("Error");
    }
}