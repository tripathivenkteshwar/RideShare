package exceptions;

public class UserAlreadyRegistered extends RuntimeException{

	public UserAlreadyRegistered(String message) {
        super(message);
    }
}
