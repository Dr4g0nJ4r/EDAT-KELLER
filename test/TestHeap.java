
import conjuntistas.ArbolHeapMax;
import conjuntistas.ArbolHeapMin;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Luis
 */
public class TestHeap {
    public static void main(String args[]) {
        System.out.println("Test Heap Min");
        ArbolHeapMin arbolMin = new ArbolHeapMin();
        ArbolHeapMax arbolMax = new ArbolHeapMax();
        //Insertar elem 4 ->[4]
        //Insertar elem 5 ->[4,5]
        //Insertar elem 2 ->[4,5,2] -> [2,5,4]
        System.out.println("Se insertar 4 en arbol: " + arbolMin.insertar(4) + " Arbol:" + arbolMin.toString());
        System.out.println("Se insertar 5 en arbol: " + arbolMin.insertar(5)+ " Arbol:" + arbolMin.toString());
        System.out.println("Se insertar 2 en arbol: " + arbolMin.insertar(2)+ " Arbol:" + arbolMin.toString());
        System.out.println("Se insertar 8 en arbol: " + arbolMin.insertar(8)+ " Arbol:" + arbolMin.toString());
        System.out.println("Se insertar 5 en arbol: " + arbolMin.insertar(5)+ " Arbol:" + arbolMin.toString());
        System.out.println("Se insertar 1 en arbol: " + arbolMin.insertar(1)+ " Arbol:" + arbolMin.toString());
        System.out.println("Arbol Heap Min: " + arbolMin.toString());
        
        System.out.println("Test Heap Max");
        System.out.println("Se insertar 4 en arbol: " + arbolMax.insertar(4) + " Arbol:" + arbolMax.toString());
        System.out.println("Se insertar 5 en arbol: " + arbolMax.insertar(5)+ " Arbol:" + arbolMax.toString());
        System.out.println("Se insertar 2 en arbol: " + arbolMax.insertar(2)+ " Arbol:" + arbolMax.toString());
        System.out.println("Se insertar 8 en arbol: " + arbolMax.insertar(8)+ " Arbol:" + arbolMax.toString());
        System.out.println("Se insertar 5 en arbol: " + arbolMax.insertar(5)+ " Arbol:" + arbolMax.toString());
        System.out.println("Se insertar 1 en arbol: " + arbolMax.insertar(1)+ " Arbol:" + arbolMax.toString());
        System.out.println("Arbol Heap Max: " + arbolMax.toString());
    }  
}
