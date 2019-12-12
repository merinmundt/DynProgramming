package pa2;


public class ImageProcessor{
    static Picture reduceWidth(int x, String inputImage){
        Picture pic = new Picture(inputImage);
        int i = 0;
        while(i < x) {
        	
        }
        
        return pic;
    	
    }
    static int[][] getImportance(Picture image){
    	int imageHeight = image.height();
    	int imageWidth = image.width();
    	int[][] importanceArr = new int[imageWidth][imageHeight];
    	
    	//getting the array for each (i,j) based on the importance algorithms given on the assignmnet pdf
    	for(int i = 0; i < imageHeight; i++) {
    		
    		for(int j = 0; j < imageWidth; j++) {
    			if((j > 0) && (j < imageWidth - 1)) {
    				importanceArr[i][j] = ImageStitch.pixelDistance(image.get(j-1, i), image.get(j+1, i));
    			}
    			if(j == 0) {
    				importanceArr[i][j] = ImageStitch.pixelDistance(image.get(j, i), image.get(j+1, i));
    			}
    		}
    	}
    	return importanceArr;
    }
}
