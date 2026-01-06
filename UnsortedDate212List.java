public class UnsortedDate212List extends Date212List {

    // constructor calls superclass initializing dummy node and initializes linked list structure
    public UnsortedDate212List(){
        super();
    }
    public void add(Date212 w){     // add Date212 object to end of list
        append(w);                  // keeps the input order original
    }
}
