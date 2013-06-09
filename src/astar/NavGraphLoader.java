/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package astar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;

/**
 *
 * @author atef
 */
public class NavGraphLoader {

    public NavGraphData load(String filePath) {
        try {
            String json = this.readFileAsString(filePath);
            JSONReader reader = new JSONReader();
            Map map = (Map) reader.read(json);
            NavGraphData data = new NavGraphData();
            data.fromJSON(map);

            return data;
        } catch (IOException e) {
            throw new RuntimeException("Cannot read file " + filePath);
        }
    }

    String readFileAsString(String filePath) throws java.io.IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(this.getClass().getResourceAsStream(filePath)));
        StringBuffer sb = new StringBuffer(4096);

        String line = reader.readLine();
        while(line != null){
            sb.append(line);
            line = reader.readLine();
        }

        reader.close();

        return sb.toString();
    }
}
