/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author HP
 */

public class Lista<T> {
    
    public interface Comparator<T> {
        boolean comparar(T a, T b);
    }
    
    private static class Nodo <T>{
        T dato;
        Nodo <T> anterior;
        Nodo <T> siguiente;
        
        public Nodo(T dato){
            this.dato = dato;
            anterior = siguiente = null;
        }
    }
    
    private Nodo<T> cabeza;
    private Nodo<T> aux1;
    private int tamanio;
    
    public Lista(){
        cabeza = null;
        tamanio = 0;
    }
    
    public int getTamanio(){
        return tamanio;
    }
    
    public void agregar(T dato, int indice){
        Nodo nuevo = new Nodo(dato);
        aux1 = cabeza;
        if(tamanio >= indice){
            if(cabeza == null){
            cabeza = nuevo;
            cabeza.anterior = cabeza.siguiente = cabeza;
            } else{
                if(indice == 0){
                    nuevo.anterior = aux1.anterior;
                    nuevo.siguiente = aux1;
                    aux1.anterior.siguiente = nuevo;
                    aux1.anterior = nuevo;
                    cabeza = nuevo;
                } else {
                    for (int i = 0; i < indice - 1; i++) {
                        aux1 = aux1.siguiente;
                    }
                    nuevo.siguiente = aux1.siguiente;
                    nuevo.anterior = aux1;
                    aux1.siguiente.anterior = nuevo;
                    aux1.siguiente = nuevo;
                }
            }
            tamanio++;
        } else{
            throw new IllegalStateException("ERROR");
        }
    }
    
    public void agregar(T dato) {
        Nodo nuevo = new Nodo(dato);
        aux1 = cabeza;
        if(cabeza == null){
            cabeza = nuevo;
            cabeza.anterior = cabeza.siguiente = cabeza;
        } else{
            nuevo.siguiente = cabeza;
            nuevo.anterior = cabeza.anterior;
            cabeza.anterior.siguiente = nuevo;
            cabeza.anterior = nuevo;
        }
        tamanio++;
    }
    
    public T eliminar(int indice){
        aux1 = cabeza;
        T x;
        int cont = 0;
        if(cabeza == null){
            throw new IllegalStateException("Lista vacía");
        }
        if(indice < tamanio && indice >= 0){
            if(tamanio == 1){
                x = aux1.dato;
                cabeza = null;
                tamanio--;
                return x;
            }
            while(cont != indice && aux1 != null){
                aux1 = aux1.siguiente;
                cont++;  
            }
            x = aux1.dato;
            aux1.anterior.siguiente = aux1.siguiente;
            aux1.siguiente.anterior = aux1.anterior;
             
            if (indice == 0){
                cabeza = cabeza.siguiente;
            }
            tamanio--;
            return x;  
        } else {
            throw new IllegalStateException("Error");
        }
    }
    
    public T verElemento(int indice){
        aux1 = cabeza;
        T x;
        int cont = 0;
        
        if(aux1 == null){
            throw new IllegalStateException("Error");
        }
        while(cont != indice && aux1 != null){
            aux1 = aux1.siguiente;
            cont++;
        }
        x = aux1.dato;
        return x;
    }
    
    @Override
    public String toString(){
        aux1 = cabeza;
        String texto = "";
        for (int i = 0; i < tamanio; i++) {
            texto += aux1.dato +" "; 
            aux1 = aux1.siguiente;
        }
        return texto;
    }
    
    public boolean vacia(){
        return cabeza == null;
    }
    
    public void eliminarTodo(){
        cabeza = null;
        tamanio = 0;
    }
    
    public void ordenar(Comparator<T> comparador) {
        if (cabeza == null || tamanio < 2) {
            return;
        }

        boolean b;
        do {
            b = false;
            Nodo<T> actual = cabeza;

            for (int i = 0; i < tamanio - 1; i++) {

                if (comparador.comparar(actual.siguiente.dato, actual.dato)) { 
                    T temp = actual.dato;
                    actual.dato = actual.siguiente.dato;
                    actual.siguiente.dato = temp;
                    b = true;
                }
                actual = actual.siguiente;
            }
        } while (b);
    }
}
