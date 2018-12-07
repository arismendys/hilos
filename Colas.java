/*
Las Colas son como una Lista o una pila, pero en estas el primer dato en entrar es el primero en salir,
ademas las colas son igual a una lista doble porque conocen que nodo esta delante del otro y quien esta detras.

* El metodo push nos servira para introducir un nodo en la pila y lo convierte de inmediato en el primer valor de esta.
* El metodo pop nos permite sacar el primer elemento de pila y al mismo tiempo nos va reduciendo el tamaño de la pila.
* El metodo peek nos permite visializar cual es el primer valor de nuestra pila sin afectar el contenido de esta.
* El metodo size lo utilizaremos para visializar el tamaño de la pila.

Cuando vaciamos una pila su tamaño final sera 0 debido a que el metodo pop reduce la cantidad de nodos restantes en la pila
a medida que toma una nodo.
*/
public class Colas {
    private Nodo head;
    private int cant = 0;
    private int cont = 0;
    
    Colas (Nodo n){ head = n; }
    Colas (){}

        public void push (Nodo n){
            Nodo l = null;
            cant++;
            cont++;
            if (head == null) head = n;
            else
            {
                for (l = head; l.getNext() != null; l=l.getNext());
                l.setNext(n);
            }
        }
        public Nodo pop() {
            Nodo l=head;
            head=head.getNext();
            cant--;
            return l;
        }
        public Object peek(){
            return head.getData();
        }
        public int size(){ 
            return cant; 
        }
        public int conteo(){ 
            return cont; 
        }
        
}
