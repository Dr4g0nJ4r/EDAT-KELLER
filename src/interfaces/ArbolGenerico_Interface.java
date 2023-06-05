/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

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
    
    public Lista_Interface listarPreorden();
    
    public Lista_Interface listarInorden();
    
    public Lista_Interface listarPosorden();
    
    public Lista_Interface listarPorNiveles();
    
    public ArbolGenerico_Interface clone();
    
    public void vaciar();
    
    public String toString();
}
