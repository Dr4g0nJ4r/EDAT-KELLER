/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lineales.dinamicas;

/************* Autores ***********
KELLER LUIS EULOGIO, Legajo FAI-2321
*/
public class Nodo {
    private Object elem;
    private Nodo enlace;
    
    //Constructor completo de Nodo
    public Nodo(Object elem, Nodo enlace){
        this.elem = elem;
        this.enlace = enlace;
    }
    
    public Object getElem(){
        return this.elem;
    }
    
    public void setElem(Object elem){
        this.elem = elem;
    }
    
    public Nodo getEnlace(){
        return this.enlace;
    }
    
    public void setEnlace(Nodo enlace){
        this.enlace = enlace;
    }
}
