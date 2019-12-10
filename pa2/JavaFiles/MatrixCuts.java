package pa2;

import java.io.*; 
import java.util.*; 

public class MatrixCuts{

    static ArrayList<Tuple> widthCut(int[][] M){
    	ArrayList<Tuple> minCost = new ArrayList<Tuple>();
    	int cost;
    	int lowest = M[0][0];
    	Tuple curr = new Tuple(0,0);
    	for(int i = 0; i < M[0].length(); i++) {
    		int num = M[0][i];
    		if(num < lowest) {
    			lowest = num;
    			curr.x = 0;
    			curr.y = i;
    		}
    	}
    	cost = cost + M[curr.x][curr.y];
    	minCost.add(curr);
    	
    	for(int j = 0; j < M.length(); j++) {
    		int min = M[curr.x +1][curr.y-1];
    		int min2 = M[curr.x+1][curr.y];
    		int min3 = M[curr.x+1][curr.y+1];
    		if(min < min2) {
    			if(min < min3) {
    				curr.x = curr.x+1;
    				curr.y = curr.y-1;
    			}
    			else {
    				curr.x = curr.x+1;
    				curr.y = curr.y+1;
    			}
    		}
    		else {
    			if(min2 < min3) {
    				curr.x = curr.x+1;
    				curr.y = curr.y;
    			}
    			else {
    				curr.x = curr.x+1;
    				curr.y = curr.y+1;
    			}
    		}
    	}
    	
    }
    static ArrayList<Tuple> stitchCut(int[][] M){

    }
}