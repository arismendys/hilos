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
public class Nodo {
    private Object data;
    private Nodo siguiente,anterior;
    public void setData(Object o){data=o;}
    public Object getData(){return data;}
    public Nodo getNext(){return siguiente;}
    public void setNext(Nodo n){siguiente=n;}
    public Nodo getBefore(){return anterior;}
    public void setBefore(Nodo n){anterior=n;}

}
