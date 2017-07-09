public class LinkList {
	
	static class Node {                                                    // Nested Node Class

		 // Data Members                                                                  
		private int x_value;
		private int y_value;
		private Node next;
		
		// Accessor Method for Node
		public int getx_value(){return x_value;}
		public int gety_value(){return y_value;}
		public Node get_next() {return next;}
		
		// Constructor for Node Class
		public Node(){
			this.x_value = 0;
			this.y_value = 0;
		}
		public Node(int x_value,int y_value){
			this.x_value = x_value;
			this.y_value = y_value;
		}

		// Method to print Node is order pair (x,y)
		public void printNode() {  System.out.println("(" + x_value + ","+ y_value + ")");}
	}

	
	// Data Members
	private Node firstNode;  
	private int size = 0;
	
	
	// Default Constructor
	public LinkList(){firstNode = null;}                 
	
	// Methods
	public int get_size(){ return size;}               // Method to returns size of linked List
	public boolean isEmpty(){return(firstNode == null);}      // Check if List is Empty
	public Node get_first(){return firstNode;}                // Returns first Node
	public void addFirst(int x, int y){                       // Add a Nodes in the List 
		Node newNode = new Node(x,y);
		newNode.next = firstNode;                             // Shift first to second
		firstNode = newNode;                                  // Makes the new Node first
        size++;     	   		
	}
		
	public Node removeFirst(){                                // Method to remove first Node
		Node NodeReference = firstNode;                       // Create a reference to the first node
		if(!isEmpty()){                                       // if not empty remove first node
			firstNode = firstNode.next;                       // Makes next element the new first therefore old one is gone
		    size--;
		} else {System.out.println("Empty LinkedList");}
		return NodeReference;                                 // Returns the first Node
		
	}
	
	public void printList(){                                  // Method to print the List
		Node NodeReference = firstNode; 	                  // Creates a reference to the first Node												
		while(NodeReference != null){
			NodeReference.printNode();
			System.out.println("Next Node " + NodeReference.next);
			NodeReference = NodeReference.next;
			System.out.println();
		}
	}
	
}
	

	
	