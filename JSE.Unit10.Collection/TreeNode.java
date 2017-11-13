/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package techmatter.lab10;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author PA
 */
public class TreeNode<T> {
    private T value;
    
    private TreeNode<T> nextSibling;
    private TreeNode<T> firtChild;
    private TreeNode<T> parent;
    
    public TreeNode(T v){
        value = v;
    }
    
    public TreeNode<T> getNextSibling(){ return nextSibling;}
    
    public TreeNode<T> getParent(){ return parent; }
    
    public TreeNode<T> getFirstChild(){ return firtChild;}
    
    public T getValue(){ return value;}
    
    public void addChild(TreeNode<T> child){
        if(child == null) return;
        child.parent = parent;
        if(firtChild == null){
            firtChild = child;
        }else{
            TreeNode<T> temp = firtChild;
            while(temp.nextSibling != null){
                temp = temp.nextSibling;
            }
            temp.nextSibling = child;
        }
    }
    
    public TreeNode<T> addChild(T value){
        TreeNode<T> node = new TreeNode<T>(value);
        addChild(node);
        return node;
    }
    
    public List<T> chonloc(TreeNodeFilter<T> filter){
        List<T> list = new ArrayList<>();
        TreeNodeUtils.visit(this, filter, list);
        return list;
    }
}
