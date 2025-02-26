/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import modelo.ArbolBinario;
import modelo.ColaPrioridad;
import modelo.Lista;
import modelo.Mapa;
import modelo.Pila;

/**
 *
 * @author HP
 */
public class ControladorAlgoritmos {
    private static int prioridad(char operador) {
        switch (operador) {
            case '+':
            case '-': return 1;
            case '*':
            case '/': return 2;
            case '^': return 3;
            default: return -1;
        }
    }
    
    public static String infijaAPrefija(String expresion) {
        StringBuilder resultado = new StringBuilder();
        StringBuilder expresionInvertida = new StringBuilder(expresion).reverse();
        Pila<Character> pila = new Pila<>();

        for (int i = 0; i < expresionInvertida.length(); i++) {
            char c = expresionInvertida.charAt(i);
            
            if (Character.isLetterOrDigit(c)) {
                resultado.append(c);
            } else if (c == ')') {
                pila.agregar(c);
            } else if (c == '(') {
                while (!pila.vacia() && pila.verUltimo()!= ')') {
                    resultado.append(pila.eliminar());
                }
                pila.eliminar();
            } else {
                while (!pila.vacia() && prioridad(c) <= prioridad(pila.verUltimo())) {
                    resultado.append(pila.eliminar());
                }
                pila.agregar(c);
            }
        }

        while (!pila.vacia()) {
            resultado.append(pila.eliminar());
        }

        return resultado.reverse().toString();
    }
    
    public static int resolverPrefija(String expresion) {
        Pila<Integer> pila = new Pila<>();
        
        for (int i = expresion.length() - 1; i >= 0; i--) {
            char c = expresion.charAt(i);
            
            if (Character.isDigit(c)) {
                pila.agregar(c - '0');
            } else {
                int op1 = pila.eliminar();
                int op2 = pila.eliminar();
                
                switch (c) {
                    case '+': pila.agregar(op1 + op2); break;
                    case '-': pila.agregar(op1 - op2); break;
                    case '*': pila.agregar(op1 * op2); break;
                    case '/': pila.agregar(op1 / op2); break;
                    case '^': pila.agregar((int) Math.pow(op1, op2)); break;
                }
            }
        }
        return pila.eliminar();
    }
    
    public static String infijaAPosfija(String expresion) {
        StringBuilder resultado = new StringBuilder();
        Pila<Character> pila = new Pila<>();
        
        for (int i = 0; i < expresion.length(); i++) {
            char c = expresion.charAt(i);
            
            if (Character.isLetterOrDigit(c)) {
                resultado.append(c);
            } else if (c == '(') {
                pila.agregar(c);
            } else if (c == ')') {
                while (!pila.vacia() && pila.verUltimo() != '(') {
                    resultado.append(pila.eliminar());
                }
                pila.eliminar();
            } else {
                while (!pila.vacia() && prioridad(c) <= prioridad(pila.verUltimo())) {
                    resultado.append(pila.eliminar());
                }
                pila.agregar(c);
            }
        }
        
        while (!pila.vacia()) {
            resultado.append(pila.eliminar());
        }
        
        return resultado.toString();
    }    
    
    public static int resolverPosfija(String expresion) {
        Pila<Integer> pila = new Pila<>();
        
        for (int i = 0; i < expresion.length(); i++) {
            char c = expresion.charAt(i);
            
            if (Character.isDigit(c)) {
                pila.agregar(c - '0');
            } else {
                int op2 = pila.eliminar();
                int op1 = pila.eliminar();
                
                switch (c) {
                    case '+': pila.agregar(op1 + op2); break;
                    case '-': pila.agregar(op1 - op2); break;
                    case '*': pila.agregar(op1 * op2); break;
                    case '/': pila.agregar(op1 / op2); break;
                    case '^': pila.agregar((int) Math.pow(op1, op2)); break;
                }
            }
        }
        return pila.eliminar();
    }
    
    public static String huffman(String texto){
        
        Mapa<Character, Integer> frecuencias = new Mapa<>();
        for (char c : texto.toCharArray()) {
            frecuencias.insertar(c, frecuencias.obtener(c, 0) + 1);
        }
        ArbolBinario.Nodo<Character> raiz = construirArbolHuffman(frecuencias);

        ArbolBinario<Character> arbol = new ArbolBinario(raiz);
        arbol.construirTablaCodigos(texto);
        
        Mapa<Character, String> tablaCodigos = arbol.getTablaCodigos();
        
        
        StringBuilder resultado = new StringBuilder();
        
        Lista<Character> claves = frecuencias.getClaves();
        for (int i=0; i<claves.getTamanio(); i++) {
            resultado.append(claves.verElemento(i)).append(" -> ").append(tablaCodigos.obtener(claves.verElemento(i))).append("\n");
        }
        
        for (char c : texto.toCharArray()) {
            resultado.append(tablaCodigos.obtener(c));
        }
        return resultado.toString();
        
    }
    
    
    public static ArbolBinario.Nodo<Character> construirArbolHuffman(Mapa<Character, Integer> frecuencias) {
        ColaPrioridad<ArbolBinario.Nodo<Character>> cola = new ColaPrioridad<>();

        Lista<Character> claves = frecuencias.getClaves();
        for (int i=0; i<claves.getTamanio(); i++) {            
            char clave = claves.verElemento(i);
            int freq = frecuencias.obtener(clave);
            
            cola.agregar(new ArbolBinario.Nodo<>(clave, freq), freq);
        }

        while (cola.getTamanio() > 1) {
            ArbolBinario.Nodo<Character> izq = cola.eliminar();
            ArbolBinario.Nodo<Character> der = cola.eliminar();
            ArbolBinario.Nodo<Character> nuevo = new ArbolBinario.Nodo<>('\0', izq.frecuencia + der.frecuencia);
            nuevo.izquierda = izq;
            nuevo.derecha = der;
            cola.agregar(nuevo, nuevo.frecuencia);
        }
        return cola.eliminar();
    }
}
