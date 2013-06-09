/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package AStar;

import java.util.Random;

/**
 *
 * @author atef
 */
public class Grid {
    
    static int width = 20;
    static int height = 20;
    static Random random = new Random();
    
    private int totalNodes;
    private Node[][] grid;
    
    public Grid(){
        
        this.totalNodes = width * height;
        grid = new Node[width][height];
        init();
        
    }
    
    public Grid(int w, int h){
        
        Grid.width = w;
        Grid.height = h;
        this.totalNodes = width * height;
        grid = new Node[width][height];
        init();
        setWalls();
        
    }
    
    public final void init(){
        
        for (int i = 0; i < width; i++){
            
            for (int j = 0; j < height; j++){
                
                grid[i][j] = new Node(i,j);
                
            }
            
        }
        
        for (int i = 0; i < width; i++){
            
            for (int j = 0; j < height; j++){
            
                if((i+1) < width){
                    grid[i][j].setRightSide(grid[i+1][j]);
                }
                if((j+1) < height){
                    grid[i][j].setDownSide(grid[i][j+1]);
                }
                if((i-1) >=0){
                    grid[i][j].setLeftSide(grid[i-1][j]);
                }
                if((j-1) >=0){
                    grid[i][j].setUpSide(grid[i][j-1]);
                }
                
            }
            
        }
        
    }
    
    public final void setWalls(){
        
        for (int i=0; i < width; i++){
            
            grid[i][0].setUpWall();
            grid[i][height-1].setDownWall();
            
        }
        
        for (int i=0; i < height; i++){
            
            grid[0][i].setLeftWall();
            grid[width-1][i].setRightWall();
            
        }
        
        Node currentNode;
        
        for (int i = 1; i < (width-1); i++){
            
            for (int j = 1; j < (height-1); j++){
                
                currentNode = grid[i][j];
                while (currentNode.canSetWall()){
                    
                    switch (random()){                                                  
                         
                        case 0:
                            currentNode.setRightWall();
                            break;
                        case 1:
                            currentNode.setUpWall();
                            break;
                        case 2:
                            currentNode.setLeftWall();
                            break;
                        case 3:
                            currentNode.setDownWall();
                            break;
                            
                    }
                    
                }
                
            }
            
        }
        
    }
    
    public int random(){
        
        return random.nextInt(4);
        
    }
    
    public void print(){
        
        for (int i = 0; i < width; i++){
            
            for (int j = 0; j < height; j++){
            
                System.out.print(grid[i][j].toString());
            
            }
            
            System.out.println();
            
        }
        
    }
    
    public Node getNode(int x, int y){
        
        return grid[x][y];
        
    }
    
}
