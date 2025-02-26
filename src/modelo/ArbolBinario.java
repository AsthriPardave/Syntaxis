/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author HP
 */
public class ArbolBinario<T> {
    private static class Nodo <T> {
        T dato;
        int frecuencia;
        Nodo<T> derecha;
        Nodo<T> izquierda;
        
        public Nodo(T dato){
            this.dato = dato;
            izquierda =  derecha =  null;
        }
    }
    
    public interface Comparador<T>{
        boolean comparar(T a, T b);
    }
    
    private Nodo<T> raiz;
    public ArbolBinario(){
        raiz = null;
    }
    
    public void insertar(T dato, Comparador <T> comparador){
        raiz = insertar(raiz, dato, comparador);
    }
    
    private Nodo insertar(Nodo<T> nodo, T dato, Comparador <T> comparador){
        if (nodo == null){
            return new Nodo(dato);
        } else {
            if(nodo.dato == dato){
            } else {
                if (comparador.comparar(dato , nodo.dato)){
                    nodo.derecha = insertar(nodo.derecha, dato, comparador);
                } else if (!comparador.comparar(dato, nodo.dato)){
                    nodo.izquierda = insertar(nodo.izquierda, dato, comparador);
                }
            }
            return nodo;
        }
    }
    
    public void eliminar (T dato, Comparador<T> comparador){
        raiz = eliminar(raiz, dato, comparador);
    }
    
    public Nodo <T> eliminar(Nodo<T> nodo, T dato, Comparador<T> comparador){
        if(nodo == null) return null;
        if(dato == nodo.dato){
            if(nodo.izquierda == null && nodo.derecha == null){
                return null;
            } else if(nodo.izquierda == null){
                return nodo.derecha;
            } else if(nodo.derecha == null){
                return nodo.izquierda;
            } else {
                T valor = getMayor(nodo.izquierda);
                nodo.dato = valor;
                nodo.izquierda = eliminar(nodo.izquierda,valor, comparador);
            }
        } else if(comparador.comparar(dato, nodo.dato)){
            nodo.izquierda = eliminar(nodo.izquierda, dato, comparador);
        } else {
            nodo.derecha = eliminar(nodo.derecha, dato, comparador);
        }
        return nodo;
    }
    
    public T getMayor(Nodo<T> nodo){
        while(nodo.derecha != null){
            nodo = nodo.derecha;
        }
        return nodo.dato;
    }
    
    public void inOrden(Nodo <T> nodo){
        if(nodo == null) return;
        inOrden(nodo.izquierda);
        System.out.print(nodo.dato + " ");
        inOrden(nodo.derecha);
    }
    
    public void preOrden (Nodo <T> nodo){
        if(nodo == null) return;
        System.out.println(nodo.dato + " ");
        preOrden(nodo.izquierda);
        preOrden(nodo.derecha);
    }
    
    public void postOrden(Nodo <T> nodo){
        if(nodo == null) return;
        postOrden(nodo.izquierda);
        postOrden(nodo.derecha);
        System.out.println(nodo.dato + " ");
    }
}
