package customException;

public class StudentNotFoundException extends RuntimeException{
	String message;

	public StudentNotFoundException(String message) {
		super();
		this.message = message;
	}
	@Override
	public String getMessage() {
		return message;
	}
}

