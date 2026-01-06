public class Date212Node {
    protected Date212 data;     // one Date212 object 
    protected Date212Node next; // pointer to the next node

    public Date212Node(Date212 w){  // creates a single argument constructor that contains Date212 object
        this.data = w;              // assign the data
        this.next = null;           // node not linked to anything 
    }
}