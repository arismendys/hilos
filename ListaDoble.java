/*
Esta clase nos serve para crear una lista de nodos en la cual siempre conoceremos cual es el nodo siguiente al que apunta el
nodo en que estamos, tambien se conoce como lista simple.

* El metodo getHead nos retorna el primer nodo de nuestra lista.
* El metodo Agregar nos añade un nodo al final de la lista, pero al mismo tiempo le indica al ultimo nodo de la lista que debe 
aputar hacia el nodo que le estamos añadiendo y nos va creando un contador de los nodos que hemos añadidos.
* El metodo AgregarPrimero nos añade un nodo al inicio de la lista y al mismo tiempo le indica al nodo que estamos añadiendo
que debe aputar hacia el nodo que anteriormente era quien encabezaba la lista.
* El metodo get nos permite retornar un nodo de una posicion especifica de la lista al recibir un valor entero, su implementacion
en otra clase para una variable tipo lista a la cual llamaremos l seria "l.get(valor del la posicion del nodo)", podemos acompañarlo
del metodo getData de la clase nodo de la siguiente manera "l.get(1).getData()" de esta manera retornariamos dato almacenado en el
nodo en la posicion indicada de la lista.
* El metodo Eliminar nos permite eliminar un nodo de la lista y al mismo tiempo reduce el tamaño de la lista.
* El metodo size nos retornara el tamaño de la lista.

*/
public class ListaDoble {
    private Nodo head;
    private int cant = 0;
    
    ListaDoble (Nodo n){ 
		head = n; 
	}
    ListaDoble (){}
    
    public Nodo getHead() {
		return head;
		}
    public void Agregar (Nodo n){
        Nodo l = null, z = null;
        cant++;
        
        if (head == null) head = n;
        else
        {
            for (l = head; l.getNext()!= null; l=l.getNext(), z=l.getBefore());
            l.setNext(n);
            l.setBefore(l);
        }
    }
    public void AgregarPrimero (Nodo n){
        cant++;
        if (head == null) head = n;
        else
        {
            n.setNext(head);
            head = n;
        }
    }
    public int size(){ 
		return cant;
		}
    public Nodo get(int pos){
        int i;
        Nodo l;
        if (cant >= pos && pos >= 0)
        {
            if(pos == 0) return head;
            for (i = 0, l = head ; i < pos ; i++, l = l.getNext());
                return (l);
        }
        return null;
    }

    public void Eliminar (Nodo d){
        Nodo l;
        cant--;
        if(d == head)
        {
            head = head.getNext();
        }
        else
        {
            for(l=head; l.getNext()!= d ; l=l.getNext());
            d.getBefore().setNext(d.getNext());
            d.getNext().setBefore(d.getBefore());
        }
    }


}
