/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package modelo;

/**
 *
 * @author HP
 */
public class Mapa<K, V> {
    private static class Nodo<K, V> {
        V valor;
        K clave;
        Nodo<K, V> siguiente;
        public Nodo(K clave, V valor) {
            this.clave = clave;
            this.valor = valor;
            siguiente = null;
        }
    }
    Nodo<K, V> cabeza;
    int tamanio;
    
    public Mapa() {
        this.cabeza = null;
        this.tamanio = 0;
    }
    
    public void insertar(K clave, V valor) {
        Nodo<K, V> nuevo = new Nodo(clave, valor);
        if (cabeza == null) {
            cabeza = nuevo;
        } else {
            Nodo<K, V> aux = cabeza;
            Nodo<K, V> aux2 = cabeza;
            while (aux != null) {
                if (aux.clave == clave) {
                    aux.valor = valor;
                    return;
                }
                aux2 = aux;
                aux = aux.siguiente;
            }
            aux2.siguiente = nuevo;
        }
        tamanio++;
    }
    
    public V obtener(K clave) {
        Nodo<K, V> aux = cabeza;
        while (aux != null) {
            if (aux.clave == clave) {
                return aux.valor;
            }
            aux = aux.siguiente;
        }
        throw new IllegalStateException("No existe la clave");
    }
    public V obtener(K clave, V defecto) {
        Nodo<K, V> aux = cabeza;
        while (aux != null) {
            if (aux.clave == clave) {
                return aux.valor;
            }
            aux = aux.siguiente;
        }
        return defecto;
    }
    public void eliminar(K clave) {
        Nodo<K, V> aux1 = cabeza;
        Nodo<K, V> aux2 = cabeza;
        while(aux1 != null && aux1.clave != clave) {
            aux2 = aux1;
            aux1 = aux1.siguiente;
        }
        if (aux1 == cabeza) {
            cabeza = cabeza.siguiente;
        } else if (aux1 != null) {
            aux2.siguiente = aux1.siguiente;
        } else {
            throw new IllegalStateException("No se encuentra el elemento");
        }
        tamanio--;
    }
    public Lista<K> getClaves() {
        Lista<K> claves = new Lista();
        Nodo<K, V> aux = cabeza;
        while (aux != null) {
            claves.agregar(aux.clave);
            aux = aux.siguiente;
        }
        return claves;
    }
}
