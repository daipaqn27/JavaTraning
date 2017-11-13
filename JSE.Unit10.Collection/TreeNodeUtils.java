/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package techmatter.lab10;

import java.util.List;

/**
 *
 * @author PA
 */
public class TreeNodeUtils {
    public static <T> boolean contains(TreeNode<T> node, T avalue){
        if(node.getValue().equals(avalue)) return true;
        TreeNode<T> temp = node.getFirstChild();
        while (temp != null) {
            if(contains(temp, avalue)) return true;
            temp = temp.getNextSibling();
        }
        
        return false;
    }
    
    public static <T> void visit(TreeNode<T> node,
            TreeNodeFilter<T> filter, List<T> list){
        
        if(filter.filter(node.getValue())) list.add(node.getValue());
        
        TreeNode<T> temp = node.getFirstChild();
        while(temp != null){
            visit(temp, filter, list);
            temp = temp.getNextSibling();
        }
    }
}
