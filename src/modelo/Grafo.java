/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author HP
 */
public class Grafo {
    public static class Nodo{
        int dato;
        Nodo[] vecinos;
        int numVecinos;
        
        public Nodo(int dato){
            this.dato = dato;
            vecinos = new Nodo[10];
            this.numVecinos = 0;
        }
        
        public void agregarVecino(Nodo vecino){
            if(numVecinos < vecinos.length && !existeVecino(vecino)){
                vecinos[numVecinos] = vecino;
                numVecinos++;
            }
        }
        
        public boolean existeVecino(Nodo vecino){
            for (int i = 0; i < numVecinos; i++) {
                if(vecinos[i] == vecino) return true;
            }
            return false;
        }
    }
    
    Nodo[] nodos;
    int numNodos;
    
    public Grafo(){
        this.nodos = new Nodo[20];
        this.numNodos = 0;
    }
    
    public void agregarArista(int origen, int destino){
        Nodo nodoOrigen = obtenerNodo(origen);
        Nodo nodoDestino = obtenerNodo(destino);
        if(nodoOrigen == null || nodoDestino == null){
            System.out.println("uno o ambos no existen");
            return;
        }
        nodoOrigen.agregarVecino(nodoDestino);
        nodoDestino.agregarVecino(nodoOrigen);
    }
    
    private Nodo obtenerNodo(int dato){
        for (int i = 0; i < numNodos; i++) {
            if(dato == nodos[i].dato){
                return nodos[i];
            }
        }
        return null;
    }
    
    public void agregarNodo(int dato){
        if(!existeNodo(dato)){
            Nodo nuevo = new Nodo(dato);
            nodos[numNodos] = nuevo;
            numNodos++;
        } else {
            System.out.println("Nodo con valor " + dato + " ya existe");
        }
    }
    
    public boolean existeNodo(int dato){
        for (int i = 0; i < numNodos; i++) {
            if(dato == nodos[i].dato) return true;
        }
        return false;
    }
}
