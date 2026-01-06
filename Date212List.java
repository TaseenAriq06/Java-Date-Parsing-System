public abstract class Date212List {

    protected Date212Node first;    // head/dummy node that does not store real data but avoids empty list
    protected Date212Node last;     // points to last node in the list
    protected int length;           // keeps track of how many nodes are in the list

    public Date212List() {          // creates an empty linked list with only dummy node
        first = new Date212Node(null); 
        last = first;                 
        length = 0;
    }

    protected void append(Date212 w) { // appends a new date object to the end of the list
        Date212Node newNode = new Date212Node(w); // create a new node that contains data

        last.next = newNode; // link the current last node to new node
        last = newNode;     // update last to point to new final node
        length++;       // increase the counter of stored dates
    }

    // unsorted list calls append() and sorted list inserts nodes in a sorted order
    public abstract void add(Date212 d);

    public String toString() {              // converts entire linked list into a string
        String stringResult = "";
        Date212Node current = first.next;   // start at the first node

        while (current != null) {
            stringResult += current.data.toString() + "\n"; // add the string of data to the result
            current = current.next;                         // move onto the next node
        }
        return stringResult;
    }
}