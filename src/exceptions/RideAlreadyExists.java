package exceptions;

public class RideAlreadyExists extends RuntimeException{

	public RideAlreadyExists(String message) {
        super(message);
    }
	
}
