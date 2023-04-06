/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lineales.dinamicas;

import lineales.interfaces.PilaInterface;


/************* Autores ***********
KELLER LUIS EULOGIO, Legajo FAI-2321
*/
public class Pila implements PilaInterface{

    private Nodo tope;
    
    //Constructor vacío
    public Pila(){
        this.tope = null;
    }
    
    @Override
    public boolean apilar(Object elemento) {
        //Crea un nuevo nodo, con el elemento ingresado y enlace igual a tope
        Nodo nuevo = new Nodo(elemento, this.tope);
        //El nodo nuevo es el nuevo tope
        this.tope = nuevo;
        return true;
    }

    @Override
    public boolean desapilar() {
        boolean resultado = false;
        //Asigna el tope al enlace del tope actual. Si el enlace es nulo, entonces la Pila quedará vacía.
        if(this.tope != null)
        {
            this.tope = this.tope.getEnlace();
            resultado = true;
        }
        return resultado;
    }

    @Override
    public Object obtenerTope() {
        Object elemento = null;
        if(this.tope != null)
        {
            elemento = this.tope.getElem();
        }
        return elemento;
    }

    @Override
    public boolean esVacia() {
        boolean resultado = false;
        if(this.tope == null)
        {
            resultado = true;
        }
        return resultado;
    }

    @Override
    public void vaciar() {
        this.tope = null;
    }

    @Override
    public Pila clone() {
        //Creo nueva Pila
        Pila pilaClonada = new Pila();
        //Verifico primero si la pila está vacía. Si no es así, recorro todos los elementos a clonar
        if(this.tope != null)
        {
            clonarPilaRecursivo(pilaClonada, this.tope);
        }
        return pilaClonada;
    }
    
    private void clonarPilaRecursivo(Pila pila, Nodo nodo){
        //Método privado auxiliar del método público Clone
        //Mientras el nodo sea distinto a nulo, se realiza el paso recursivo para recorrer todos los elementos de la Pila
        if(nodo != null)
        {
            //Paso recursivo
            clonarPilaRecursivo(pila, nodo.getEnlace());
            //Paso de clonación de Pila
            Nodo nuevoNodo = new Nodo(nodo.getElem(), nodo.getEnlace());
            pila.apilar(nuevoNodo);
        }
    }
    
    @Override
    public String toString(){
        String resultado = "";
        if(this.tope == null)
        {
            resultado = "Pila vacía";
        }else{
            //Se crea un nodo auxiliar para recorrer la Pila
            Nodo aux = this.tope;
            resultado = "[";
            //Se recorre la pila
            while(aux != null)
            {
                resultado += aux.getElem().toString();
                aux = aux.getEnlace();
                if(aux != null)
                {
                    resultado +=",";
                }
            }
            resultado += "]";
        }
        return resultado;
    }
    
}
