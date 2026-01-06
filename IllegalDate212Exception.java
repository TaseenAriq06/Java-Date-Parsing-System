// this is a custom exception class that handles invalid Date212 objects
// extends IllegalArgumentException since the invalid dates are not valid arguments 
public class IllegalDate212Exception extends IllegalArgumentException {
    public IllegalDate212Exception(String message){ // uses IllegalArgumentException constructor to output the error
        super(message);
    }
}
