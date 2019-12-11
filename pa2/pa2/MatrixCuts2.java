package pa2;


import java.io.*; 
import java.util.*;

public class MatrixCuts2 {
	static int totalMinCost = 10000;
	 static ArrayList<Tuple> widthCut(int[][] M){
	    	ArrayList<Tuple> minCost = new ArrayList<Tuple>();
	    	int cost = 0;
	    	int x = 0;
	    	int y = 0;
	    	for(int i = 0; i < M[0].length; i++) {
	    		int j = 0;
	    		y = i;
	    		cost = cost + M[x][y];
	    		boolean visitedL = false;
	    		boolean visitedD = false;
	    		boolean visitedR = false;
	    		boolean next = true;
	    		
	    		//while loop to hold until all paths visited for the selected starting tuple
	    		while(next) {
		    		while(j < (M.length -1)) {
		    			//go to first option: diagonaly down to the left
		    			if(!visitedL) {
		    				if(y <= 0) {
		    					visitedL = true;
		    				}
		    				else {
		    					visitedL = true;
		    					x = x + 1;
		    					y = y - 1;
		    				}
		    			}
		    			//go to the spot below
		    			else if(!visitedD && visitedL) {
		    				visitedD = true;
		    				x = x+1;
		    			}
		    			//go to the diagonal down to the right
		    			else {
		    				if(y >= M[0].length) {
		    					visitedR = true;
		    				}
		    				visitedR = true;
		    				x = x+1;
	    					y = y+1;
		    			}
		    			//compute the cost, and go to the next spot
		    			cost = cost + M[x][y];
		    			j++;
		    		}
		    		//check if cost is lower than min
		    		if(cost<totalMinCost) {
		    			totalMinCost = cost;
		    		}
		    		//move backwards to previous position to get another path
		    		j--;
	    		}
	    	}
	    	
	    	return minCost;
	 }
	
}
