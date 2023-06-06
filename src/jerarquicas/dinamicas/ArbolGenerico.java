/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jerarquicas.dinamicas;
import interfaces.ArbolGenerico_Interface;
import interfaces.Lista_Interface;
import lineales.dinamicas.Cola;
import lineales.dinamicas.Lista;
import lineales.dinamicas.Pila;
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
    public Lista ancestros(Object elem) {
        Lista lista_ancestros = new Lista();
        if(this.raiz != null)
        {
            Pila pila = new Pila();
            this.ancestrosRecursivo(elem, pila, this.raiz);
            if(!pila.esVacia())
            {
                while(!pila.esVacia())
                {
                    lista_ancestros.insertar(pila.obtenerTope(), lista_ancestros.longitud()+1);
                    pila.desapilar();
                }
            }
        }
        return lista_ancestros;
    }

    //Método recursivo preorden privado que sirve para recuperar los ancestros de un elemento
    private void ancestrosRecursivo(Object elem, Pila pila, NodoGen nodo)
    {
        if(nodo.getElem().equals(elem))
        {
            pila.apilar(nodo.getElem());
        }else{
            //Caso base
            if(nodo.getHijoIzq() != null)
            {
                //Caso recursivo en hijoIzq
                this.ancestrosRecursivo(elem, pila, nodo.getHijoIzq());
                if(!pila.esVacia())
                {
                    pila.apilar(nodo.getElem());
                }else{
                    NodoGen nodoAux = nodo.getHijoIzq().getHermanoDer();
                    while(nodoAux != null && pila.esVacia())
                    {
                        //Caso recursivo en hermanos de HijoIzq
                        this.ancestrosRecursivo(elem, pila, nodoAux);
                        if(pila.esVacia())
                        {
                            nodoAux = nodoAux.getHermanoDer();
                        }else{
                            pila.apilar(nodo.getElem());
                        }
                    }
                }
            }
        }
    }
    
    @Override
    public boolean esVacio() {
        boolean resultado = false;
        if(this.raiz == null)
        {
            resultado = true;
        }
        return resultado;
    }

    @Override
    public int altura() {
        int altura = -1;
        if(this.raiz != null)
        {
            this.alturaRecursivo(this.raiz);
        }
        return altura;
    }

    //Método privado recursivo que recorre en posorden el árbol para hallar la altura del mismo
    private int alturaRecursivo(NodoGen nodo)
    {
        int altura = 0;
        if(nodo.getHijoIzq() != null)
        {
            NodoGen nodoAux = nodo.getHijoIzq();
            int alturaAux;
            // caso base
            while(nodoAux != null)
            {
                //Caso recursivo
                alturaAux = this.alturaRecursivo(nodoAux) + 1;
                if(alturaAux > altura)
                {
                    altura = alturaAux;
                }
                nodoAux = nodoAux.getHermanoDer();
            }
        }
        return altura;
    }
    
    @Override
    public int nivel(Object elem) {
        int nivel = -1;
        if(this.raiz != null)
        {
            this.nivelRecursivo(elem, this.raiz, false);
        }
        return nivel;
    }

    //Método privado recursivo que recorre en preorden el arbol hasta hallar el elemento buscado
    private int nivelRecursivo(Object elem, NodoGen nodo, boolean encontrado)
    {
        int altura = -1;
        //El elemento aún no se encuentra en el árbol
        if(!encontrado){
            if(nodo.getElem().equals(elem))
            {
                altura = 0;
            }else{
                NodoGen nodoAux = nodo.getHijoIzq();
                //Caso base
                while(nodoAux != null && !encontrado)
                {
                    //Caso recursivo
                    altura = this.nivelRecursivo(elem, nodoAux, encontrado);
                    if(altura > 0)
                    {
                        encontrado = true;
                    }else{
                        nodoAux = nodoAux.getHermanoDer();
                    }
                }
            }
        }
        return altura;
    }
    
    @Override
    public Object padre(Object elem) {
        Object elemento = null;
        if(this.raiz != null)
        {
            if(!this.raiz.getElem().equals(elem))
            {
                this.padreRecursivo(elem, this.raiz);
            }
        }
        return elemento;
    }

    //Método privado recursivo que lista en posorden buscando al elemento
    private Object padreRecursivo(Object elem, NodoGen nodo)
    {
        Object elemento = null;
        NodoGen nodoAux = nodo.getHijoIzq();
        boolean encontrado = false;
        while(!encontrado && nodoAux != null && elemento != null)
        {
            if(nodoAux.getElem().equals(elem)){
                encontrado = true;
                elemento = nodo.getElem();
            }else{
                elemento = this.padreRecursivo(elem, nodoAux);
                nodoAux = nodoAux.getHermanoDer();
            }
        }
        return elemento;
    }
    
    @Override
    public Lista listarPreorden() {
        Lista lista = new Lista();
        if(this.raiz != null)
        {
            this.listarPreordenRecursivo(lista, this.raiz);
        }
        return lista;
    }

    //método privado recursivo que guarda en una lista los elementos del árbol con recorrido en preorden
    private void listarPreordenRecursivo(Lista lista, NodoGen nodo){
        //guarda el elemento en la lista
        lista.insertar(nodo.getElem(), lista.longitud()+1);
        //Recorre los hijos
        NodoGen nodoAux = nodo.getHijoIzq();
        while(nodoAux != null){
            this.listarPreordenRecursivo(lista, nodoAux);
            nodoAux = nodoAux.getHermanoDer();
        }
    }
    
    @Override
    public Lista listarInorden() {
        Lista lista = new Lista();
        if(this.raiz != null)
        {
            this.listarInordenRecursivo(lista, this.raiz);
        }
        return lista;
    }

    //método privado recursivo que guarda en una lista los elementos del árbol con recorrido en inorden
    private void listarInordenRecursivo(Lista lista, NodoGen nodo){
        //Guarda el hijo izquierdo en la lista
        NodoGen nodoAux = nodo.getHijoIzq();
        if(nodoAux != null)
        {
            this.listarInordenRecursivo(lista, nodoAux);
        }
        //guarda el elemento en la lista
        lista.insertar(nodo.getElem(), lista.longitud()+1);
        //Recorre los otros hijos
         if(nodoAux != null)
        {
            nodoAux = nodoAux.getHermanoDer();
            while(nodoAux != null){
                this.listarPreordenRecursivo(lista, nodoAux);
                nodoAux = nodoAux.getHermanoDer();
            }
        }
    }
    
    @Override
    public Lista listarPosorden() {
        Lista lista = new Lista();
        if(this.raiz != null)
        {
            this.listarPosordenRecursivo(lista, this.raiz);
        }
        return lista;
    }

    //método privado recursivo que guarda en una lista los elementos del árbol con recorrido en inorden
    private void listarPosordenRecursivo(Lista lista, NodoGen nodo){
        //Recorre todos los hijos
        NodoGen nodoAux = nodo.getHijoIzq();
        if(nodoAux != null)
        {
            while(nodoAux != null){
                this.listarPreordenRecursivo(lista, nodoAux);
                nodoAux = nodoAux.getHermanoDer();
            }
        }
        //guarda el elemento en la lista
        lista.insertar(nodo.getElem(), lista.longitud()+1);
    }
    
    @Override
    public Lista listarPorNiveles() {
        Lista lista = new Lista();
        if(this.raiz != null)
        {
            Cola cola = new Cola();
            NodoGen nodoAux;
            cola.poner(this.raiz);
            while(!cola.esVacia())
            {
                nodoAux = (NodoGen) cola.obtenerFrente();
                //Guardo elemento en lista
                lista.insertar(nodoAux.getElem(), lista.longitud()+1);
                //Recorre los hijos y carga en la cola
                nodoAux = nodoAux.getHijoIzq();
                while(nodoAux != null)
                {
                    cola.poner(nodoAux);
                    nodoAux = nodoAux.getHermanoDer();
                }
                cola.sacar();
            }
        }
        return lista;
    }

    @Override
    public ArbolGenerico clone() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void vaciar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
