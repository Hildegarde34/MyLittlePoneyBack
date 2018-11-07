package app.exceptions;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class RessourceNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public RessourceNotFoundException( String message ) {

	        super(message);

	    }

	public RessourceNotFoundException( String message, Throwable cause ) {

	        super( message , cause );

	    }

}