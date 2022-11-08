package prog13_2.db;

@SuppressWarnings("serial")
public class RecordNotFoundException extends Exception {
	public RecordNotFoundException() {
		super();
	}

	public RecordNotFoundException(String message) {
		super(message);
	}

	public RecordNotFoundException(Throwable throwable) {
		super(throwable);
	}
}
