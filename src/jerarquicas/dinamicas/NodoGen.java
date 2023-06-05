/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jerarquicas.dinamicas;

import interfaces.NodoGen_Interface;

/**
 *
 * @author Luis
 */
public class NodoGen implements NodoGen_Interface{
    
    private Object elem;
    private NodoGen hijoIzquierdo;
    private NodoGen hermanoDerecho;

    public NodoGen(Object elem){
        this.elem = elem;
        this.hijoIzquierdo = null;
        this.hermanoDerecho = null;
    }
    
    @Override
    public Object getElem() {
        return this.elem;
    }

    @Override
    public NodoGen getHijoIzq() {
        return this.hijoIzquierdo;
    }

    @Override
    public NodoGen getHermanoDer() {
        return this.hermanoDerecho;
    }

    @Override
    public void setElem(Object elem) {
        this.elem = elem;
    }

    @Override
    public void setHijoIzq(NodoGen nodo) {
        this.hijoIzquierdo = nodo;
    }

    
    @Override
    public void setHermanoDer(NodoGen nodo) {
        this.hermanoDerecho = nodo;
    }
    
    
}
