package egreso.exceptions;

public class EgresoNoCerradoException extends Exception {

	public EgresoNoCerradoException() {
	}

	public EgresoNoCerradoException(String message) {
		super(message);
	}

	public EgresoNoCerradoException(Throwable cause) {
		super(cause);
	}

	public EgresoNoCerradoException(String message, Throwable cause) {
		super(message, cause);
	}

	public EgresoNoCerradoException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
