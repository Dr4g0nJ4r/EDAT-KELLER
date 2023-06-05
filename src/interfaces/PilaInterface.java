/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

/************* Autores ***********
KELLER LUIS EULOGIO, Legajo FAI-2321
*/

public interface PilaInterface {
    
    public boolean apilar(Object elemento);
    
    public boolean desapilar();
    
    public Object obtenerTope();
    
    public boolean esVacia();
    
    public void vaciar();
    
    public PilaInterface clone();
    
    @Override
    public String toString();
}
