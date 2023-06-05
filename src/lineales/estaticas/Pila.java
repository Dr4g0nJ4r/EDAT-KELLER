/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lineales.estaticas;
import interfaces.PilaInterface;

/************* Autores ***********
KELLER LUIS EULOGIO, Legajo FAI-2321
*/
public class Pila implements PilaInterface{

    private static int TAM = 10;
    private Object[] arreglo;
    private int tope;
    
    public Pila(){
        this.arreglo = new Object[TAM];
        this.tope = -1;
    }
    
    @Override
    public boolean apilar(Object elemento) {
        boolean resultado = false;
        if(this.tope < TAM-1){
            this.arreglo[this.tope+1] = elemento;
            this.tope += 1;
            resultado = true;
        }
        return resultado;
    }

    @Override
    public boolean desapilar() {
        boolean resultado = false;
        if(this.tope != -1)
        {
            this.arreglo[this.tope] = null;
            this.tope -= 1;
            resultado = true;
        }
        return resultado;
    }

    @Override
    public Object obtenerTope() {
        Object elemento = null;
        if(this.tope >= 0)
        {
            elemento = this.arreglo[this.tope];
        }
        return elemento;
    }

    @Override
    public boolean esVacia() {
        boolean resultado = false;
        if(this.tope == -1)
        {
            resultado = true;
        }
        return resultado;
    }

    @Override
    public void vaciar() {
        //Verifica que la Pila no esté vacía
        if(this.tope != -1)
        {
            while(this.tope >= 0)
            {
                this.arreglo[this.tope] = null;
                this.tope -= 1;
            }
        }
    }

    @Override
    public Pila clone() {
        //Creo nueva Pila
        Pila pilaClonada = new Pila();
        //Recorro los elementos de la Pila a clonar, si es que no está vacía.
        if(this.tope != -1)
        {
            int aux = 0;
            while(aux <= this.tope)
            {
                pilaClonada.apilar(this.arreglo[aux]);
                aux += 1;
            }
        }
        return pilaClonada;
    }
    
    @Override
    public String toString(){
        String resultado = "";
        if(this.tope == -1)
        {
            resultado = "Pila vacía";
        }else{
            resultado = "[";
            //Recorro toda la Pila, desde el tope hasta la base
            int aux = this.tope;
            while(aux >= 0)
            {
                resultado += this.arreglo[aux].toString();
                aux -= 1;
                if(aux >= 0){
                    resultado += ",";
                }
            }
            resultado += "]";
        }
        return resultado;
    }
}
