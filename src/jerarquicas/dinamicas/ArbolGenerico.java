/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jerarquicas.dinamicas;
import interfaces.ArbolGenerico_Interface;
import interfaces.Lista_Interface;
/**
 *
 * @author Luis
 */
public class ArbolGenerico implements ArbolGenerico_Interface{

    private NodoGen raiz;
    
    //Constructor
    public ArbolGenerico(){
        this.raiz = null;
    }
    
    @Override
    public boolean insertar(Object elem, Object elemPadre) {
        boolean resultado = false;
        //Consulta primero si el árbol está vacío
        if(this.raiz == null)
        {
            this.raiz = new NodoGen(elem);
        }else{
            resultado = this.insertarRecursivo(elem, elemPadre, this.raiz);
        }
        return resultado;
    }

    //método recursivo privado usado para insertar elementos. Recorrido en PreOrden
    private boolean insertarRecursivo(Object elem, Object elemPadre, NodoGen nodo){
        boolean resultado = false;
        if(nodo.getElem().equals(elemPadre))
        {
            NodoGen nodoAux = new NodoGen(elem);
            //Si hijoIzquierdo es vacio, lo guarda. Sino inserta en el siguiente nodoHermano del hijo
            if(nodo.getHijoIzq() == null){
                nodo.setHijoIzq(nodoAux);
            }else{
                nodoAux.setHermanoDer(nodo.getHijoIzq());
                nodo.setHijoIzq(nodoAux);
            }
            resultado = true;
        }else{
            //Caso base
            if(nodo.getHijoIzq() != null)
            {
                //Caso recursivo en hijoIzq
                resultado = this.insertarRecursivo(elem, elemPadre, nodo.getHijoIzq());
                if(!resultado)
                {
                    //Caso recursivo en hermanos hijoIzq
                    NodoGen nodoAux = nodo.getHijoIzq().getHermanoDer();
                    while(nodoAux != null && !resultado){
                        resultado = this.insertarRecursivo(elem, elemPadre, nodoAux);
                        nodoAux = nodoAux.getHermanoDer();
                    }
                }
            }
        }
        return resultado;
    }
    
    @Override
    public boolean pertenece(Object elem) {
        boolean resultado = false;
        //Verifica que el árbol no esté vacío
        if(this.raiz != null)
        {
            resultado = this.perteneceRecursivo(elem, this.raiz);
        }
        return resultado;
    }

    //método recursivo privado para buscar elemento. recorrido en preorden
    private boolean perteneceRecursivo(Object elem, NodoGen nodo){
        boolean resultado = false;
        if(nodo.getElem().equals(elem))
        {
            resultado = true;
        }else{
            //Caso base
            if(nodo.getHijoIzq() != null)
            {
                //Caso recursivo en hijoIzq
                resultado = this.perteneceRecursivo(elem, nodo.getHijoIzq());
                if(!resultado)
                {
                    //Caso recursivo en hermanos hijoIzq
                    NodoGen nodoAux = nodo.getHijoIzq().getHermanoDer();
                    while(nodoAux != null && !resultado)
                    {
                        resultado = this.perteneceRecursivo(elem, nodoAux);
                        nodoAux = nodoAux.getHermanoDer();
                    }
                }
            }
        }
        return resultado;
    }
    
    @Override
    public Lista_Interface ancestros(Object elem) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean esVacio() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int altura() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int nivel(Object elem) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Object padre(Object elem) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Lista_Interface listarPreorden() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Lista_Interface listarInorden() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Lista_Interface listarPosorden() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Lista_Interface listarPorNiveles() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArbolGenerico_Interface clone() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void vaciar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
