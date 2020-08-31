/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbolbinario;

import Screens.Home;
import java.util.Scanner;
import java.util.Stack;
import javax.swing.JOptionPane;
import java.io.File;
import java.io.IOException;

/**
 *
 * @author JPPM
 */
public class ArboleBinario {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        Home app = new Home();
          Arbol a = new Arbol ();
          Scanner tecla = new Scanner (System.in);
          int c=0;
          int n;
          while(c<4){
              System.out.println("digite n");
              n=tecla.nextInt();
              a.addNodo(n);
              c++;
          }
          a.recorridoInOrder(a.getRaiz());
          System.out.println("\n");
          System.out.println("digite s");
          int s=tecla.nextInt();
          a.eliminarNodo(s);
          System.out.println("\n");
          a.recorridoInOrder(a.getRaiz());
    }
}

