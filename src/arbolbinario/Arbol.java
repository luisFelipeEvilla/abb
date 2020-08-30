/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbolbinario;

import java.util.Stack;
import javax.swing.JPanel;
import utils.ArbolGrafico;

/**
 *
 * @author JPPM
 */
public class Arbol {
    
    NodoArbol raiz;
    //inicializo en raíz en nulo arbol vacío
    public Arbol() {
        raiz = null;
    }
    //inserta nodo
    public void addNodo(double numero) {
        NodoArbol nuevoNodo = new NodoArbol(numero);
        //cuando el árbol este vacío 
        // la raíz sera el NuevoNodo
        if (raiz == null) {
            raiz = nuevoNodo;
        }
        //no está vacío
        //lo que hara es ir buscando donde insertar el NuevoNodo
        else {
            //Utilizar un apuntador que lleve la referencia del nodo padre a NuevoNodo
            NodoArbol padre = raiz;
            //Localizar espacio disponible para insertar NuevoNodo
            // se localizara cuando llegue a null
            NodoArbol aux = null;
            while (true) {
                //padre se va moviendo cadavez entre al ciclo
                aux = padre;
                // si el NuevoNodo tiene un numero menor se mueve al hijo izquierdo aux
                if (numero < padre.getNumero()) {
                    aux = aux.hijoIzquierdo;
                    //encontro lugar 
                    if (aux == null) {
                        padre.hijoIzquierdo = nuevoNodo;
                        return;

                    } 
                    //se va moviendo el padre
                    else {
                        
                        padre = aux;
                    }   
                }
                // si el NuevoNodo tiene un numero mayor se mueve al hijo Derecha aux
                else {
                    aux = aux.hijoDerecho;
                    //encontro lugar 
                    if (aux == null) {
                        padre.hijoDerecho = nuevoNodo;
                        return;
                    }
                     //se va moviendo el padre
                    else {
                        padre = aux;
                    }
                }
            }
        }
    }

    public void recorridoInOrder(NodoArbol raiz) {
        if (raiz != null) {
            recorridoInOrder(raiz.hijoIzquierdo);
            System.out.println(raiz.getNumero());
            recorridoInOrder(raiz.hijoDerecho);
        }
    }

    public String iterativeInOrder(NodoArbol raiz) {
        String recorrido = "";
        if (raiz != null) {
            Stack<NodoArbol> p = new Stack<NodoArbol>();
            while (true) {
                if (raiz != null) {
                    p.push(raiz);
                    raiz=raiz.hijoIzquierdo;
                }else{
                    if(p.empty()){
                        break;
                    }
                    raiz=p.pop();
                    recorrido += raiz.getNumero();
                    raiz=raiz.hijoDerecho;
                }
            }
        }
        return recorrido;
    }

    public void recorridoPreOrder(NodoArbol raiz) {
        if (raiz != null) {
            System.out.println(raiz.getNumero());
            recorridoPreOrder(raiz.hijoIzquierdo);
            recorridoPreOrder(raiz.hijoDerecho);
        }

    }

    public String iterativePreOrder(NodoArbol raiz) {
        String recorrido = "";
        if (raiz == null) {
            return "";
        } else {
            Stack<NodoArbol> p = new Stack<NodoArbol>();
            p.push(raiz);
            while (p.empty() == false) {

                raiz = p.pop();
                recorrido = recorrido + raiz.getNumero() + ", ";
                if (raiz.hijoDerecho != null) {
                    p.push(raiz.hijoDerecho);
                }
                if (raiz.hijoIzquierdo != null) {
                    p.push(raiz.hijoIzquierdo);
                }
            }
        }
        return recorrido;
    }
    
    public String recorridoPostOrder(NodoArbol raiz){
        String recorrido = "";
        if(raiz==null){
            return "";
        }else{
         recorridoPostOrder( raiz.hijoIzquierdo);
         recorridoPostOrder( raiz.hijoDerecho);
           recorrido = recorrido + raiz.getNumero();
        }
        return recorrido;
    }
    public String iterativePostOrder(NodoArbol raiz){
        String recorrido = "";
        if(raiz==null){
            return "";
        }else{
             Stack<NodoArbol> p1 = new Stack<NodoArbol>();
             Stack<NodoArbol> p2 = new Stack<NodoArbol>();
             p1.push(raiz);
             while(p1.empty()==false){
                 raiz=p1.pop();
                 p2.push(raiz);
                 if(raiz.hijoIzquierdo!=null){
                     p1.push(raiz.hijoIzquierdo);
                 }
                 if(raiz.hijoDerecho!=null){
                    p1.push(raiz.hijoDerecho) ;
                 }
             }
             while(p2.empty()==false){
                 raiz=p2.pop();
                 recorrido = recorrido + raiz.getNumero() + ", ";
             }
        }
        return recorrido;
    }
    
    public int alturaArbol(NodoArbol raiz){
        if(raiz==null){
            return -1;
        }else{
            int alturaSubArbolIzq=alturaArbol(raiz.hijoIzquierdo);
            int alturaSubArbolDer=alturaArbol(raiz.hijoDerecho);
            return 1+Math.max(alturaSubArbolDer, alturaSubArbolIzq);
        }
    }

    public NodoArbol getRaiz() {
        return raiz;
    }
    
    public JPanel getDibujo() {
        return new ArbolGrafico(this);
    }
}