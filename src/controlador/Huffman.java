/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


package controlador;
import modelo.*;
/**
 *
 * @author HP
 */
class NodoHuffman implements Comparable<NodoHuffman> {
    char caracter;
    int frecuencia;
    NodoHuffman izquierdo, derecho;

    public NodoHuffman(char caracter, int frecuencia) {
        this.caracter = caracter;
        this.frecuencia = frecuencia;
        this.izquierdo = this.derecho = null;
    }

    @Override
    public int compareTo(NodoHuffman otro) {
        return Integer.compare(this.frecuencia, otro.frecuencia);
    }
}

public class Huffman {
    public static Mapa<Character, String> tablaCodigos = new Mapa<>();

    public static void construirTablaCodigos(NodoHuffman raiz, String codigo) {
        if (raiz == null) return;
        if (raiz.izquierdo == null && raiz.derecho == null) {
            tablaCodigos.insertar(raiz.caracter, codigo);
        }
        construirTablaCodigos(raiz.izquierdo, codigo + "0");
        construirTablaCodigos(raiz.derecho, codigo + "1");
    }

    public static NodoHuffman construirArbolHuffman(Mapa<Character, Integer> frecuencias) {
        ColaPrioridad<NodoHuffman> cola = new ColaPrioridad<>();

        Lista<Character> claves = frecuencias.getClaves();
        for (int i=0; i<claves.getTamanio(); i++) {            
            char clave = claves.verElemento(i);
            int freq = frecuencias.obtener(clave);
            
            cola.agregar(new NodoHuffman(clave, freq), freq);
        }

        while (cola.getTamanio() > 1) {
            NodoHuffman izq = cola.eliminar();
            NodoHuffman der = cola.eliminar();
            NodoHuffman nuevo = new NodoHuffman('\0', izq.frecuencia + der.frecuencia);
            nuevo.izquierdo = izq;
            nuevo.derecho = der;
            cola.agregar(nuevo, nuevo.frecuencia);
        }
        return cola.eliminar();
    }

    public static String codificar(String texto) {
        StringBuilder resultado = new StringBuilder();
        for (char c : texto.toCharArray()) {
            resultado.append(tablaCodigos.obtener(c));
        }
        return resultado.toString();
    }
}
