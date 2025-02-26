/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

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
    
    
}
