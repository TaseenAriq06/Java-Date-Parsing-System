public class SortedDate212List extends Date212List {
    
    // constructor calls super class which sets up the dummy node and initializes the list
    public SortedDate212List(){
        super(); 
    }
    // adds Date212 object into the list in sorted order and finds the correct order to position it using compareTo()
    public void add(Date212 w){ 
        Date212Node newNode = new Date212Node(w);

        Date212Node previous = first;       // start at dummy node
        Date212Node current = first.next;   // start at actual first node

        // keep looping until null or less than equal to the new date
        while(current != null && current.data.compareTo(w) <= 0){ 
            previous = current; // this is the node before inserting a new node
            current = current.next; // this is the node after inserting a new node
        }
        
        newNode.next = current;     // link new node to current
        previous.next = newNode;    // link previous node to newNode

        if(current == null){        // if current becomes null, insert at end of list so the 'last' can become newNode
            last = newNode; 
        }
        length++;                   // keep count of length of list
    }
}