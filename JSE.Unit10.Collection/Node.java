/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package techmatter.lab10;

/**
 *
 * @author PA
 */
public class Node<T> {
    T value;
    
    Node<T> next;
    
    Node(T v){
        value = v;
    }
    
    Node(T v, Node<T> n){
        value = v;
        next = n;
    }
    
    T getValue() { return value;}
}
