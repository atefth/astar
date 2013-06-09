/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package AStar;

/**
 *
 * @author atef
 */
public class Node {
    
    static int sides = 4;
    static int right = 0;
    static int up = 1;
    static int left = 2;
    static int down = 3;
    private Position position;
    private Node[] adjacentNodes = new Node[sides];
    
    public Node (){
        
        position = new Position();
        
    }
    
    public Node(int x, int y){
        
        position = new Position(x, y);
        
    }
    
    public Node (int x, int y, Node[] adjacents){
        
        position = new Position(x, y);
        this.adjacentNodes = adjacents;
        
    }
    
    public void setRightSide(Node rightNode){
        
        this.adjacentNodes[right] = rightNode;
        
    }
    
    public void setUpSide(Node upNode){
        
        this.adjacentNodes[up] = upNode;
        
    }
    
    public void setLeftSide(Node leftNode){
        
        this.adjacentNodes[left] = leftNode;
        
    }
    
    public void setDownSide(Node downNode){
        
        this.adjacentNodes[down] = downNode;
        
    }
    
    public void setPosition(int x, int y){
        
        this.position.setPosition(x, y);
        
    }
    
    public Position getPosition(){
        
        return this.position;
        
    }
    
    @Override
    public String toString(){
        
        return this.position.toString();
        
    }
    
}
