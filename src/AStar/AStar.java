/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package AStar;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author atef
 */
public class AStar {
    private List<Node> openList;
    private List<Node> closedList;
    private Node start;
    private Node end;
    private Node currentNode;
    
    public AStar(Node root, Node target){
        
        openList = new ArrayList();
        closedList = new ArrayList();
        start = root;
        end = target;
        init();
        
    }
    
    public final void init(){
        
        openList.add(start);
        currentNode = start;
        
    }
    
    public int calculateCost(Node n){
        
        return Math.abs(currentNode.getPosition().getCost() - n.getPosition().getCost());
        
    }
    
    public Node findMin(){
        
        Object[] nodes = openList.toArray();
        if (nodes.length >0){
            
            Node min = (Node)nodes[0];
            if (min == null)
                min = (Node)nodes[1];
            
            for (int i = 1; i < nodes.length; i++){
                
                if (nodes[i] != null){
                    if (calculateCost((Node)nodes[i]) < calculateCost(min))
                        min = (Node)nodes[i];
                }

            }
            openList.remove(min);
            closedList.add(min);
            currentNode = min;
            return min;
            
        }else{
            
            return null;
            
        }
    }
    
    public boolean search(){
        Node minCostNode = findMin();
        if (minCostNode == null){
            
            return false;
            
        }else if (check(minCostNode)){
            
            return true;
            
        }else{
            currentNode = minCostNode;
            Node[] adjacentNodes = currentNode.getAdjacentNodes();
            for (int i =1; i < adjacentNodes.length; i++){

                openList.add(adjacentNodes[i]);

            }
            return search();
        }
        
    }

    public boolean check(Node n) {
        if (n.equals(end))
            return true;
        else
            return false;        
    }
    
}
