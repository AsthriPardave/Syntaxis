
import controlador.ControladorPrincipal;
import modelo.Lista;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author HP
 */
public class App {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        /*Lista lista = new Lista ();
        
        lista.agregar(2, 0); 
        lista.agregar(4, 1);  
        lista.agregar(6, 1);
        lista.agregar(8, 0);
        System.out.println(lista);
        lista.eliminar(0);
        System.out.println(lista);
        */
        ControladorPrincipal controlador = new ControladorPrincipal();
        controlador.run();
    }
    
}
