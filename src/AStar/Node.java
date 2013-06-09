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
    private int[] walls = new int[4];
    private int totalWalls;
    private Position position;
    private Node[] adjacentNodes = new Node[sides];
    
    public Node (){
        
        position = new Position();
        totalWalls = 0;
        
    }
    
    public Node(int x, int y){
        
        position = new Position(x, y);
        totalWalls = 0;
        
    }
    
    public Node (int x, int y, Node[] adjacents){
        
        position = new Position(x, y);
        this.adjacentNodes = adjacents;
        totalWalls = 0;
        
    }
    
    public Node[] getAdjacentNodes(){
        
        return this.adjacentNodes;
        
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
    
    public int getTotalWallNumber(){
        
        return this.totalWalls;
        
    }
    
    public int[] getWalls(){
        
        return this.walls;
        
    }
    
    public boolean canSetWall(){
        
        if (getTotalWallNumber() >= 2){
            
            return false;
            
        }else{
            
            return true;
            
        }
        
    }
    
    public void setRightWall(){
        
        this.walls[0] = -1;
        if (this.adjacentNodes[0] != null && this.adjacentNodes[0].getWalls()[2] != -1){
            this.adjacentNodes[0].setLeftWall();
        }
        this.totalWalls++;
    }
    
    public void setUpWall(){
        
        this.walls[1] = -1;
        if (this.adjacentNodes[1] != null && this.adjacentNodes[1].getWalls()[3] != -1){
            this.adjacentNodes[1].setDownWall();
        }
        this.totalWalls++;
    }
    
    public void setLeftWall(){
        
        this.walls[2] = -1;
        if (this.adjacentNodes[2] != null && this.adjacentNodes[2].getWalls()[0] != -1){
            this.adjacentNodes[2].setRightWall();
        }
        this.totalWalls++;
    }
    
    public void setDownWall(){
        
        this.walls[3] = -1;
        if (this.adjacentNodes[3] != null && this.adjacentNodes[3].getWalls()[1] != -1){
            this.adjacentNodes[3].setUpWall();
        }
        this.totalWalls++;
    }
    
    @Override
    public String toString(){
       
        String toReturn = this.getPosition().toString();
        if (walls[0] == -1)
            toReturn += " has a right wall";
        if (walls[1] == -1)
            toReturn += " has a top wall";
        if (walls[2] == -1)
            toReturn += " has a left wall";
        if (walls[3] == -1)
            toReturn += " has a bottom wall";
        toReturn += "\n";
        return toReturn;
    }
    
}
