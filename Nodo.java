/*
 Esta clase nos permitira crear nuestros Nodos en las deferentes clases que necesitemos.

* El metodo setData recibe un dato tipo Object el cual se almacenara en el nodo
* El metodo setNext recibe el nodo que ira despues del nodo actual
* El metodo setBefore recibe el nodo antorior al que apuntara el actual
* El metodo getData retorna un tipo Object con los datos contenidos en un nodo
* El metodo getBefore retorna el nodo anterior al nodo actual
* El metodo getNext retorna al nodo en la posicion siguiente al nodo actual 
 
*/
public class Nodo {
    private Object data;
    private Nodo siguiente,anterior;
    public void setData(Object o){
		data=o;
		}
    public Object getData(){
		return data;
		}
    public Nodo getNext(){
		return siguiente;
		}
    public void setNext(Nodo n){
		siguiente=n;
		}
    public Nodo getBefore(){
		return anterior;
		}
    public void setBefore(Nodo n){
		anterior=n;
		}

}
