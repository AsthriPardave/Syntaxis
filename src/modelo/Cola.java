/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author HP
 */
public class Cola <T> {
    protected static class Nodo<T>{
        T dato;
        Nodo<T> siguiente;
        
        Nodo (T dato){
            this.dato = dato;
            siguiente = null;
        }
    }
    
    protected Nodo<T> ultimo;
    protected Nodo<T> primero;
    protected int tamanio;
    
    public Cola(){
        ultimo = primero = null;
        tamanio = 0;
        
    }
    
    public void agregar (T dato){
        Nodo<T> nuevo = new Nodo<>(dato);
        
        if(vacia()){
            ultimo = primero = nuevo;
        } else {
            ultimo.siguiente = nuevo;
            ultimo = nuevo;   
        }
        tamanio++;
    }
    
    public T eliminar(){
        if(vacia()){
            throw new IllegalStateException("La cola está vacía");
        }
        T x = primero.dato;
        primero = primero.siguiente;
        tamanio--;
        
        return x;
    }
    
    public boolean vacia(){
        return primero == null;
    }
    
    public T verPrimero(){
        if(vacia()){
            throw new IllegalStateException("La cola está vacía");
        }
        return primero.dato;
    }
    
    public T verUltimo(){
        if(vacia()){
            throw new IllegalStateException("La cola está vacía");
        }
        return ultimo.dato;
    }
    
    
    public int getTamanio(){
        return tamanio;
    }
 
}