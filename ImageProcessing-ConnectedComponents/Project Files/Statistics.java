public class Statistics {
	
	// Data Members
	private int x_min = 5000000;
	private int x_max = 0;
	private int y_min = 5000000;
	private int y_max = 0;
		
	// Accessor Method
	public int getx_min(){return x_min;}
	public int getx_max(){return x_max;}
	public int gety_min(){return y_min;}
	public int gety_max(){return y_max;}
	
	public int sumx_value(LinkList.Node First){                            // Method to give Summation of x value
		LinkList tempList = new LinkList();
		LinkList.Node NodeReference = new LinkList.Node();
		 NodeReference =  tempList.get_first(); 	                       // Creates a reference to the first Node												
		 NodeReference = First; 
		 int temp=0;
		while(NodeReference != null){                                      // Traversing through entire Linked List
		temp  = temp + NodeReference.getx_value();
			NodeReference = NodeReference.get_next();
		} return temp;
	}	
	
	public int sumy_value(LinkList.Node First){                            // Method to give Summation of y value 
		LinkList tempList = new LinkList();
		LinkList.Node NodeReference = new LinkList.Node();
		 NodeReference = tempList.get_first(); 	                           // Creates a reference to the first Node												
		 NodeReference = First; 		
		 int temp=0;
		while(NodeReference != null){                                      // Traversing through entire Linked List
		temp  = temp + NodeReference.gety_value();
			NodeReference = NodeReference.get_next();
		
		} return temp;
	}	
	
	public void centroid(LinkList temp,LinkList.Node First){
		//LinkList tempList = new LinkList();
		LinkList.Node NodeReference = new LinkList.Node();
		NodeReference = temp.get_first(); 	
		NodeReference = First; 
		//int tempsize = LinkList.get_size();
		//tempsize = a;
		float tempx, tempy;
		tempx = (float) sumx_value(NodeReference) / temp.get_size();
		tempy = (float) sumy_value(NodeReference) / temp.get_size();
		
		System.out.println("Centroid     = (" + tempx + " , " + tempy + ")");
	}
	
		
	public void compare(LinkList.Node First){
		LinkList.Node NodeReference = new LinkList.Node();
    	NodeReference = First;
		
    	while(NodeReference != null){                   // Traversing through entire Linked List
    		//System.out.println("Original value of x = " +NodeReference.getx_value());
    		if (NodeReference.getx_value() < x_min ){ x_min = NodeReference.getx_value();} 
        	  else if (NodeReference.getx_value() > x_max) { x_max = NodeReference.getx_value();}

        	 if (NodeReference.gety_value() < y_min ){  y_min = NodeReference.gety_value() ;}
       	   else if (NodeReference.gety_value() > y_max ) {y_max = NodeReference.gety_value();}  
    		
    		
    			NodeReference = NodeReference.get_next();
    		} 
       // Comparing all incoming Node 	
	}

}
