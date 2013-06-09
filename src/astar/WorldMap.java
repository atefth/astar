/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package astar;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author atef
 */
public class WorldMap {
    int rowNum;
    int columnNum;

    String[][] map;
    Map<String, MatrixPosition> index;

    public WorldMap(int rowNum, int columnNum) {
        this.rowNum = rowNum;
        this.columnNum = columnNum;
        map = new String[rowNum][columnNum];
        index = new HashMap<String, MatrixPosition>();
    }
    
}
