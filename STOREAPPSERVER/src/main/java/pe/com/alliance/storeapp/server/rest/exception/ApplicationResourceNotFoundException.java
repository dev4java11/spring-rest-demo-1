package pe.com.alliance.storeapp.server.rest.exception;

import static pe.com.alliance.storeapp.server.util.Constantes.*;

public class ApplicationResourceNotFoundException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ApplicationResourceNotFoundException() {
		super(RESOURCE_NOT_FOUND_EXCEPTION_VALUE);
	}
}
