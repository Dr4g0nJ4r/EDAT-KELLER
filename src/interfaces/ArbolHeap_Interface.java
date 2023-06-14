/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import lineales.dinamicas.Lista;

/**
 *
 * @author Luis
 */
public interface ArbolHeap_Interface {
    
    public boolean insertar(Object elem);
    public boolean eliminarCima();
    public Object recuperarCima();
    public boolean esVacia();
    public void vaciar();
    public Lista listarPreorden();
    public Lista listarInorden();
    public Lista listarPosorden();
    public Lista listarPorNiveles();
    public String toString();
}
