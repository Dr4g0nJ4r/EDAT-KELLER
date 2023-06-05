/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import jerarquicas.dinamicas.ArbolGenerico;
import lineales.dinamicas.Lista;

/**
 *
 * @author Luis
 */
public interface ArbolGenerico_Interface {
    
    public boolean insertar(Object elem, Object elemPadre);
    
    public boolean pertenece(Object elem);
    
    public Lista_Interface ancestros(Object elem);
    
    public boolean esVacio();
    
    public int altura();
    
    public int nivel(Object elem);
    
    public Object padre(Object elem);
    
    public Lista listarPreorden();
    
    public Lista listarInorden();
    
    public Lista listarPosorden();
    
    public Lista listarPorNiveles();
    
    public ArbolGenerico clone();
    
    public void vaciar();
    
    public String toString();
}
