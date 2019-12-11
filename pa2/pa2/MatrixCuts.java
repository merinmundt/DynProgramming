package pa2;


import java.io.*; 
import java.util.*; 

public class MatrixCuts{

    static ArrayList<Tuple> widthCut(int[][] M){
    	ArrayList<Tuple> minCost = new ArrayList<Tuple>();
//    	Tuple[] answers;
//    	for (int i = 0; i < M.length; i++) {
//    		//add first tuple to list?
//    		for(int j = 0; j < 3; j++) {
//    			//check the next three options
//    			
//    		}
//    	}
    	
    	
    	
    	
    	//all of this is before I actually knew what I was doing. 
    	int cost = 0;
    	int lowest = M[0][0];
    	//Tuple curr = new Tuple(0,0);
    	int x = 0;
    	int y = 0;
    	for(int i = 0; i < M[0].length; i++) {
    		int num = M[0][i];
    		if(num < lowest) {
    			lowest = num;
    			x = 0;
    			y = i;
    		}
    	}
    	//first add the tuple that will be in place for the cost of the final path
    	//will get updated at the end with the ending cost
    	cost = cost + M[x][y];
    	minCost.add(new Tuple(x,y));
    	
    	for(int j = 0; j < M.length; j++) {
    		int min = 0; 
    		int min2 = 0;
    		int min3 = 0;
    		
    		//need to check if valid**
    		if((y-1 >= 0) && (x+1 <= M.length-1)) {
        		min = M[x+1][y-1];
    		}
    		else {
    			//moving this way is not a valid move
    			//therefore set min to be very very large
    			min = 10000;
    		}
    		//need to check if valid**
    		if(x+1 <= M.length-1) {
    			min2 = M[x+1][y];
    		}
    		else {
    			//moving this way is not a valid move
    			//therefore set min to be very very large
    			min2 = 10000;
    		}
    		//need to check if valid**
    		if(y+1 <= M[j].length) {
    			min3 = M[x+1][y+1];
    		}
    		else {
    			//moving this way is not a valid move
    			//therefore set min to be very very large
    			min2 = 10000;
    		}
    		
    		//finding the best move
    		if(min < min2) {
    			if(min < min3) {
    				x = x+1;
    				y = y-1;
    			}
    			else {
    				x = x+1;
    				y = y+1;
    			}
    		}
    		else {
    			if(min2 < min3) {
    				x = x+1;
    			}
    			else {
    				x = x+1;
    				y = y+1;
    			}
    		}
    	
    		minCost.add(new Tuple(x,y));
    		cost = cost + M[x][y];
    		
    	}
    	
    		
    	minCost.add(0, new Tuple(cost, -1));
    	return minCost;
    }
    	
    static ArrayList<Tuple> stitchCut(int[][] M){
    	ArrayList<Tuple> minCost = new ArrayList<Tuple>();
    	int cost = 0;
    	minCost.add(new Tuple(0,0));
    	cost = cost + M[0][0];
    	int worstCase = M.length * M[M.length].length;
    	for (int i = 0; i < worstCase; i++) {
    		int min = 0; 
    		int min2 = 0;
    		int min3 = 0;
    	}
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	return minCost;
    }
}