/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lineales.estaticas;

/**
 *
 * @author Luis
 */
public class Cola {
    private static int TAM = 10;
    private Object[] arreglo;
    private int frente;
    private int cola;
    
    //Constructor vacío
    public Cola(){
        this.arreglo = new Object[TAM];
        this.frente = 0;
        this.cola = 0;
    }
    
    //Poner elemento en cola
    public boolean poner(Object elem){
        boolean resultado = false;
        if((this.cola + 1)%TAM == this.cola)
        {
            //Colocar el elemento en el frente
            this.arreglo[this.cola] = elem;
            this.cola = (this.cola + 1)%TAM;
            resultado = true;
        }
        return resultado;
    }
    
    //Operación sacar
    public boolean sacar(){
        boolean resultado = false;
        if(frente != cola)
        {
            //Sacar elemento de la cola
            this.arreglo[frente] = null;
            this.frente = (this.frente - 1)%TAM; 
            resultado = true;
        }
        return resultado;
    }
    
    //Operación obtenerFrente
    public Object obtenerFrente(){
        Object elemento = null;
        if(!this.esVacia())
        {
            elemento = this.arreglo[this.frente];
        }
        return elemento;
    }
    
    
    
    //Operación consulta si Cola es vacía
    public boolean esVacia(){
        boolean resultado = false;
        if(this.frente == this.cola)
        {
            resultado = true;
        }
        return resultado;
    }
    
    //Operación para vaciar la cola
    public void vaciar(){
        for(int i=0; i<TAM; i++)
        {
            this.arreglo[i]=null;
        }
    }
    
    //Operación para clonar una cola
    public Cola clone(){
        Cola nuevaCola = new Cola();
        for(int i=0; i<TAM; i++)
        {
            nuevaCola.poner(this.arreglo[i]);
        }
        return nuevaCola;
    }
    
    //Operación para imprimir String
    public String toString(){
        String resultado = "";
        if(this.esVacia())
        {
            resultado = "Cola es vacía";
        }else{
            resultado = "Frente ->";
            int i = this.frente;
            while(i != this.cola){
                resultado += this.arreglo[this.cola].toString();
                i = (i++)%TAM;
                if(i != this.cola)
                {
                    resultado += " - ";
                }
            }
            resultado = "<- Cola";
        }
        return resultado;
    }
}
