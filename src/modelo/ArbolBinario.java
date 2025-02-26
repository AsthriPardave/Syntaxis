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
    public static class Nodo <T> {
        public T dato;
        public int frecuencia;
        public Nodo<T> derecha;
        public Nodo<T> izquierda;
        
        public Nodo(T dato){
            this.dato = dato;
            izquierda =  derecha =  null;
            frecuencia = 0;
        }
        public Nodo(T dato, int frecuencia){
            this.dato = dato;
            this.frecuencia = frecuencia;
            izquierda =  derecha =  null;
        }
    }
    
    public interface Comparador<T>{
        boolean comparar(T a, T b);
    }
    
    private Nodo<T> raiz;
    Mapa<T, String> tablaCodigos = new Mapa<>();
    public ArbolBinario(){
        raiz = null;
    }
    public ArbolBinario(Nodo<T> raiz){
        this.raiz = raiz;
    }

    public Mapa<T, String> getTablaCodigos() {
        return tablaCodigos;
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
    
    public String preOrden (Nodo <T> nodo, String resultado){
        if(nodo == null) return resultado;
        resultado = resultado.concat(nodo.dato + " ");
        resultado = preOrden(nodo.izquierda, resultado);
        resultado = preOrden(nodo.derecha, resultado);
        return resultado;
    }
    
    public void construirTablaCodigos(ArbolBinario.Nodo raiz, String codigo) {
        if (raiz == null) return;
        if (raiz.izquierda == null && raiz.derecha == null) {
            tablaCodigos.insertar((T) raiz.dato, codigo);
        }
        construirTablaCodigos(raiz.izquierda, codigo + "0");
        construirTablaCodigos(raiz.derecha, codigo + "1");
    }
    public void construirTablaCodigos(String codigo) {
        construirTablaCodigos(raiz, codigo);
    }
    
    public void postOrden(Nodo <T> nodo){
        if(nodo == null) return;
        postOrden(nodo.izquierda);
        postOrden(nodo.derecha);
        System.out.println(nodo.dato + " ");
    }
}
