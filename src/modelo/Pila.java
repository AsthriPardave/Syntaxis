/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author HP
 */
public class Pila<T>{
    private static class Nodo<T>{
        T dato;
        Nodo<T> anterior;
        
        Nodo (T dato){
            this.dato = dato;
            anterior = null;
        }
    }
    
    private Nodo <T> ultimo;
    private int tamanio;
    
    public Pila(){
        ultimo = null;
        tamanio = 0;
    }
    
    public void agregar (T dato){
        Nodo<T> nuevo = new Nodo<>(dato);
        nuevo.anterior = ultimo;
        ultimo = nuevo;
        tamanio++;
    }
    
    public T eliminar() {
        if(vacia()){
            throw new IllegalStateException("Pila vacia");
        }
        T x = ultimo.dato;
        ultimo = ultimo.anterior;
        tamanio--;
        return x;
    }
    
    public boolean vacia(){
        return ultimo == null;
    }
    
    public T verUltimo(){
        if(vacia()){
            throw new IllegalStateException("Pila vacia");
        }
        return ultimo.dato;
    }
    
    public int getTamanio(){
        return tamanio;
    }
}
