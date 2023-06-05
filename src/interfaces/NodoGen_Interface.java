/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;
import jerarquicas.dinamicas.NodoGen;
/**
 *
 * @author Luis
 */
public interface NodoGen_Interface {
    
    public Object getElem();
    
    public NodoGen_Interface getHijoIzq();
    
    public NodoGen_Interface getHermanoDer();
    
    public void setElem(Object elem);
    
    public void setHijoIzq(NodoGen nodo);
    
    public void setHermanoDer(NodoGen nodo);
}
