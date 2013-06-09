/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package AStar;

/**
 *
 * @author atef
 */
public class Driver {
 
    public static void main(String[] args) {
        
        Grid g = new Grid(5,5);
        g.print();
        AStar a = new AStar(g.getNode(2, 4), g.getNode(0, 3));
        if (a.search())
            System.out.println("Path exists!");
        else
            System.out.println("Path does not exist!");
    }
    
}
