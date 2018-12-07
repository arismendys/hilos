/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hilos;

/**
 *
 * @author Arismendys Marte
 */

/*
Uso de Thread hilos y procesos simultaneos en java en java
Cada cajero atendera una fila tres cajeros en total C1, C2, C3

Lista de eventos o personas, cada cajero tendra un tiempo de 5 segundos
Buscar el comando syncronized() y Random(), Notify(), Wait()
Investigar condicion de carrera programacion en paralello en java

P solo hara push() canda 1 a 5 segundos generando nuevos nodos, los tipos son A,B,C
De 1-60% sera A, de 61-75% sera B, de 76-100% sera C
Osea en random seria de 0-0.6 A, de 0.61-0.75 B y de >0.75 C
Cada vez que procese un nodo al final del proceso cada cajero tendra una lista de los que atendio
La suma de los tres debe ser igual al total de nodos que genero P
Digitar cuantos usuarios se van a generar "Trabajaremos con un total de 100 nodos"
 Cada vez que P genere un nodo avisara a los cajeros que hay un nuevo nodo
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
