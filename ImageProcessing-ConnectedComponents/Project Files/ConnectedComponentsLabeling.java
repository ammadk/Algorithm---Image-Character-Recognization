public class ConnectedComponentsLabeling {

	public ConnectedComponentsLabeling(){}                               // Default Constructor
	
 	// Data Members 
	//Access Modifiers are set to private due to make the class secure                 
	private int[][] compgrid;                                   // Component Grid
	private static int compNum = 2;                             // Component Number. Static because being accessed by static method printstats
	private int width;                                          // Width of the given Image
	private int height;                                         // Height of the given Image
	private static LinkList[] listarray = new LinkList[200];    // Array of LinkedList. Static because being accessed by static method printstats
	

	// Accessor Methods for Grids. Set to Public 
	// It is being used with the Connected Component Labeling
	public int getGrid(int a,int b){ return compgrid[a][b];}
	public void setGrid(int a,int b,int compnum) {compgrid[a][b] = compnum;}
	
	

    // Method to stores the Image in Component Grid Matrix using JPegImage Class(given)
	public void Image2grid(){   
	

			JPegImage j1 = new JPegImage();                                      //Creates an Object
			j1. readImage("C:\\CS313\\FontsCourierNew48_TH161.jpg");                 // Loading up the Image
			compgrid = new int[j1.getImageWidth()][j1.getImageHeight()];         // Initializing the Component Grid
			width = j1.getImageWidth();                                                
			height  = j1.getImageHeight();
			 
			// Looping to Store grid and converting the grid from 0 - white(Background) and 1 - black(foreground) for feasibility
			for(int j = 0 ; j < height ; j++){
				for(int i = 0 ; i < width ; i++ ){
						compgrid[i][j] = j1.getPixelColor(i,j);
						
										if (compgrid[i][j] == 0){
                                                compgrid[i][j] = 1;                   // changing black from 0 to 1
						 				} else if (compgrid[i][j] == 1){
						 						compgrid[i][j] = 0;                   // changing white to 0 from 1
						 				}
				}
			 }
	
 }

 // Method to print Component Grid	
	public void printgrid(){
		for(int j=0; j < height; j++){
			for(int i=0; i < width; i++){
					System.out.print(compgrid[i][j]);
			}
		System.out.println();
		}
	System.out.println();System.out.println();
    }

	
 // Method to Perform Connected Component Labeling using recursion Algorithm for 8 Connectedness
 // Access Modifier is set to private because beginlabel method is the public method to start the labeling process

	private	void compLabel(int i, int j,int m){
		  if(getGrid(i,j)==1){                                   // if its 1 (black)
		   setGrid(i,j,compNum);                                 // compgrid[i][j] = component number
				  	if (listarray[m] == null) {                  // Linked List array are initialzed to null by default in Java
					   listarray[m] = new LinkList();            // Therefore setting it to create a new object for every array where connected component are being stored   
				  	}
		   listarray[m].addFirst(i, j);                          // Method to add connected component to Linked List
	
		   
		   // Calling Method recursively in 8 Connectedness, and test for connected components
		   compLabel(i-1,j-1,compNum);                           
		   compLabel(i-1,j,compNum);       
		   compLabel(i-1,j+1,compNum);     
		   compLabel(i,j-1,compNum);       
		   compLabel(i,j+1,compNum);       
		   compLabel(i+1,j-1,compNum);     
		   compLabel(i+1,j,compNum);       
		   compLabel(i+1,j+1,compNum);     
		  }
	}

 // Method to initiate the Connected Component Labelling Process
	public void beginLabel(){
		for(int j=0; j < height; j++){
			for(int i=0; i < width; i++){
		              if(getGrid(i,j)==1){        // if the pixel is black call recursion function 
		                   compLabel(i,j,compNum++);
		              }
		    }
	     }
	}
		     

	
	public static void printstats(){
				
		for(int i = 3; i<= compNum ; i++ ){
			int t;
			Statistics stats = new Statistics();
			int sumX, sumY;
			stats.compare(listarray[i].get_first());
			sumX = stats.sumx_value(listarray[i].get_first());
			sumY = stats.sumy_value(listarray[i].get_first());
			
			t=i-3;
			System.out.println("Connected Component " + t);
			System.out.println();
			
			System.out.println("Sum of x     = " + sumX);
			System.out.println("Sum of y     = " + sumY);
			System.out.println("No. of pixel = " + listarray[i].get_size());
			stats.centroid(listarray[i],listarray[i].get_first());
		    System.out.println("x min        = " + stats.getx_min());
			System.out.println("x max        = " + stats.getx_max());
			System.out.println("y min        = " + stats.gety_min());
			System.out.println("y max        = " + stats.gety_max());
		    System.out.println();System.out.println();
		}
}

public static void main(String[] args){
	ConnectedComponentsLabeling one = new ConnectedComponentsLabeling();                   // creating an object of the class
	
	one.Image2grid();                                  // Converting Image to Component Grid
	one.beginLabel();                                  // Doing the Connected Component Labeling using Recursion Algorithm
	System.out.println();                              //New Line

	System.out.println();
	ConnectedComponentsLabeling.printstats();
 
	
}
}