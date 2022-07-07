package exceptions;

public class RideNotFound extends RuntimeException{

    public RideNotFound() {
        super("No Ride Found");
    }
    
}
