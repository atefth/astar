/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package astar;

import java.util.Set;

/**
 *
 * @author atef
 */
public class Adjacency<N extends Node>{
    protected N node;
    protected Set<N> neighbors;
}
