/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package AStar;

/**
 *
 * @author atef
 */
class Position {

    private int x;
    private int y;
    
    public Position() {
        this.x = -1;
        this.y = -1;
    }

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    @Override
    public String toString(){
        
        return "._" + x + "," + y + "_. ";
        
    }
    
    public int getCost(){
        
        return (x+y);
        
    }
    
}
