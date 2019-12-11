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
    		int min; 
    		int min2;
    		int min3;
    		
    		//need to check if valid**
    		if((curr.y-1 >= 0) && (curr.x+1 <= M.length()-1)) {
        		min = M[curr.x +1][curr.y-1];
    		}
    		else {
    			//moving this way is not a valid move
    			//therefore set min to be very very large
    			min = 10000;
    		}
    		//need to check if valid**
    		if(curr.x+1 <= M.length()-1) {
    			min2 = M[curr.x+1][curr.y];
    		}
    		else {
    			//moving this way is not a valid move
    			//therefore set min to be very very large
    			min2 = 10000;
    		}
    		//need to check if valid**
    		if(curr.y+1 <= M[j].length()) {
    			min3 = M[curr.x+1][curr.y+1];
    		}
    		else {
    			//moving this way is not a valid move
    			//therefore set min to be very very large
    			min2 = 10000;
    		}
    		
    		//finding the best move
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
    		
    		minCost.add(curr)
    		
    		//check if at the bottom row, and not at the end corner
    		if((curr.x == M.length() - 1) && (curr.y != M[M.length()-1].length()-1){
    			printf("unable to reach destination");
    		}
    	}
    	
    }
    static ArrayList<Tuple> stitchCut(int[][] M){

    }
}