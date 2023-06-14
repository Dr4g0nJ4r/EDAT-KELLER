/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conjuntistas;

import interfaces.ArbolHeap_Interface;
import static java.lang.Math.floor;
import lineales.dinamicas.Lista;

/**
 *
 * @author Luis
 */
public class ArbolHeapMax implements ArbolHeap_Interface{

    private static int TAM=17;
    private Object[] heap;
    private int ultimo = 0;
    
    //Constructor vacío
    public ArbolHeapMax(){
        this.heap = new Object[TAM];
    }
    
    @Override
    public boolean insertar(Object elem) {
        boolean resultado = false;
        if(this.ultimo < TAM-1)
        {
            //Primer paso: Almacena en ultimo nodo el elem
            this.heap[this.ultimo] = elem;
            int aux = this.ultimo;
            this.ultimo++;
            //Segundo paso: Revisa el padre si es mayor o menor. Si es menor, no rota. Sino rota.
            if(aux > 0)
            {
                int padre;
                if(aux < 3)
                {
                    padre = 0;
                }else{
                    padre = (int) floor((aux-1) / 2);
                }
                while(aux != 0 && (int)this.heap[padre] < (int)this.heap[aux])
                {
                    Object elemAux = this.heap[padre];
                    this.heap[padre] = this.heap[aux];
                    this.heap[aux] = elemAux;
                    aux = padre;
                    padre = (int) (aux-1) / 2;
                }
            }
            resultado = true;
            
        }
        return resultado;
    }

    @Override
    public boolean eliminarCima() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Object recuperarCima() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean esVacia() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void vaciar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Lista listarPreorden() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Lista listarInorden() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Lista listarPosorden() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Lista listarPorNiveles() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public String toString(){
        String res="[";
        if(this.ultimo > 0)
        {
            int aux = 0;
            while(aux < this.ultimo){
                res += this.heap[aux].toString();
                aux++;
                if(aux < this.ultimo)
                {
                    res+=",";
                }
            }
            
        }
        res+="]";
        return res;
    }
}
