/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package AStar;

/**
 *
 * @author atef
 */
public class Grid {
    
    static int width = 20;
    static int height = 20;
    
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
    
    public void print(){
        
        for (int i = 0; i < width; i++){
            
            for (int j = 0; j < height; j++){
            
                System.out.print(grid[i][j].toString());
            
            }
            
            System.out.println();
            
        }
        
    }
    
}
