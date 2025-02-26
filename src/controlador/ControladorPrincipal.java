/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.Lista;
import vista.VistaPrincipal;

/**
 *
 * @author HP
 */
public class ControladorPrincipal {
    VistaPrincipal fr;
    
    public ControladorPrincipal(){
        this.fr = new VistaPrincipal();
        
        this.fr.btnEnter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String texto = fr.input.getText();
                texto = texto.toUpperCase();
                if("".equals(texto)){
                    JOptionPane.showMessageDialog(fr, "Texto vacio, escribe algo oe");
                } else {
                    if(texto.contains("RESOLVER")){
                        String expresion = texto.substring(9);
                        expresion = expresion.replace(" ", "");
                        String posfija = ControladorAlgoritmos.infijaAPosfija(expresion);
                        int resultado = ControladorAlgoritmos.resolverPosfija(posfija);
                        fr.output.setText(resultado+"");
                    } else if (texto.contains("PREFIJA")){
                        String expresion = texto.substring(8);
                        expresion = expresion.replace(" ", "");
                        String prefija = ControladorAlgoritmos.infijaAPrefija(expresion);
                        fr.output.setText(prefija);
                    } else if (texto.contains("POSFIJA")){
                        String expresion = texto.substring(8);
                        expresion = expresion.replace(" ", "");
                        String posfija = ControladorAlgoritmos.infijaAPosfija(expresion);
                        fr.output.setText(posfija);
                    } else if (texto.contains("HUFFMAN")) {
                        String expresion = texto.substring(8);
                        String codificacion = ControladorAlgoritmos.huffman(expresion);
                        fr.output.setText(codificacion);
                    } else if(texto.contains("ORDENAR")){
                        String expresion = texto.substring(8);
                        String[] items = expresion.split(" ");
                        Lista<String> elementos = new Lista <>();
                        boolean numeros = true;
                        for (int i = 0; i < items.length; i++) {
                            try{
                                Double.parseDouble(items[i]);
                            } catch(NumberFormatException ex) {
                                numeros = false;
                            }
                            elementos.agregar(items[i]);
                        }
                        if(numeros == true){
                            elementos.ordenar((a,b)-> Double.parseDouble(a) < Double.parseDouble(b));
                        } else {
                            elementos.ordenar((a,b)-> a.charAt(0) < b.charAt(0));
                        }
                        fr.output.setText(elementos+"");
                    }
                }
            }
        });
        
    }
    public void run(){
        fr.setVisible(true);
    }
}
