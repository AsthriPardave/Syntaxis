/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

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
/*
public class Huffman {
    public static Map<Character, String> tablaCodigos = new HashMap<>();

    public static void construirTablaCodigos(NodoHuffman raiz, String codigo) {
        if (raiz == null) return;
        if (raiz.izquierdo == null && raiz.derecho == null) {
            tablaCodigos.put(raiz.caracter, codigo);
        }
        construirTablaCodigos(raiz.izquierdo, codigo + "0");
        construirTablaCodigos(raiz.derecho, codigo + "1");
    }

    public static NodoHuffman construirArbolHuffman(Map<Character, Integer> frecuencias) {
        PriorityQueue<NodoHuffman> cola = new PriorityQueue<>();
        for (Map.Entry<Character, Integer> entrada : frecuencias.entrySet()) {
            cola.add(new NodoHuffman(entrada.getKey(), entrada.getValue()));
        }

        while (cola.size() > 1) {
            NodoHuffman izq = cola.poll();
            NodoHuffman der = cola.poll();
            NodoHuffman nuevo = new NodoHuffman('\0', izq.frecuencia + der.frecuencia);
            nuevo.izquierdo = izq;
            nuevo.derecho = der;
            cola.add(nuevo);
        }
        return cola.poll();
    }

    public static String codificar(String texto) {
        StringBuilder resultado = new StringBuilder();
        for (char c : texto.toCharArray()) {
            resultado.append(tablaCodigos.get(c));
        }
        return resultado.toString();
    }
}
*/
