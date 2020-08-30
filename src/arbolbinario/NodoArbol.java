/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbolbinario;

import javax.swing.JPanel;
import utils.ArbolGrafico;

/**
 *
 * @author JPPM
 */
public class NodoArbol {
    private double numero;
    NodoArbol hijoDerecho;
    NodoArbol hijoIzquierdo;
    NodoArbol(double numero){
        this.numero=numero;
        hijoIzquierdo = null;
        hijoDerecho = null;
    }
    public double getNumero(){
        return numero;
    }
    
    public NodoArbol getDer() {
        return this.hijoDerecho;
    }
    
    public NodoArbol getIzq() {
        return this.hijoIzquierdo;
    }
    
    
}
