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
public class TestStack {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(23);
        stack.push(45);
        stack.push(12);
        stack.push(89);
        stack.push(11);
        
        while(stack.hasNext()){
            System.out.println("data = "+ stack.pop());
        }
    }
}
