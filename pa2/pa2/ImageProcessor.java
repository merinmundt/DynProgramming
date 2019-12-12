package pa2;

import java.util.*;


//@author Merin Mundt

public class ImageProcessor{
    static Picture reduceWidth(int x, String inputImage){
        Picture pic = new Picture(inputImage);
        int n = 0;
        //int[][] I = new int[][];
        while(n < x) {
        	//get the imporance array from the importance array method
        	int[][] I = getImportance(pic);
        	Picture newPic = new Picture(pic.width() - 1, pic.height());
        	ArrayList<Tuple> minCost = new ArrayList<Tuple>();
        	minCost.addAll(MatrixCuts.widthCut(I));
        	minCost.remove(0);
        	
        	//setting the pic to its new pic without the pixels that have been removed
        	for(int i = 0; i < minCost.size(); i++) {
        		for(int j = 0; j + 1 < pic.width(); j++) {
        			if(j < minCost.get(i).getY()) {
        				newPic.set(j, i, pic.get(j, i));
        			}
        			else if(j >= minCost.get(i).getY()) {
        				newPic.set(j, i, pic.get(j+1, i));
        			}
        		}
        	}
        	pic = newPic;
        }
        
        return pic;
    	
    }
    
    static int[][] getImportance(Picture image){
    	int imageHeight = image.height();
    	int imageWidth = image.width();
    	int[][] importanceArr = new int[imageHeight][imageWidth];
    	
    	//getting the array for each (i,j) based on the importance algorithms given on the assignmnet pdf
    	for(int i = 0; i < imageHeight; i++) {
    		
    		for(int j = 0; j < imageWidth; j++) {
    			if((j > 0) && (j < imageWidth - 1)) {
    				importanceArr[i][j] = ImageStitch.pixelDistance(image.get(j-1, i), image.get(j+1, i));
    			}
    			else if(j == 0) {
    				importanceArr[i][j] = ImageStitch.pixelDistance(image.get(j, i), image.get(j+1, i));
    			}
    			else if(j == imageWidth -1) {
    				importanceArr[i][j] = ImageStitch.pixelDistance(image.get(j, i), image.get(j-1, i));
    			}
    		}
    	}
    	return importanceArr;
    }
}


