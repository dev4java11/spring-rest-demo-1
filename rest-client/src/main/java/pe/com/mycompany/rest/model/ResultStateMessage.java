package pe.com.mycompany.rest.model;

public class ResultStateMessage {

	private boolean state;//true si se ejecuto de manera correcta, false si no se pudo ejecutar.
	private String message;//mensaje de la respuesta.
	private Object result;//en caso de ser un get, para acceder al resultado de la consulta.
	
	public ResultStateMessage() {
		// TODO Auto-generated constructor stub
	}
	
	public ResultStateMessage(boolean state) {
		super();
		this.state = state;
	}

	public ResultStateMessage(boolean state, String message) {
		super();
		this.state = state;
		this.message = message;
	}
	
	public ResultStateMessage(boolean state, String message, Object result) {
		super();
		this.state = state;
		this.message = message;
		this.result = result;
	}
	
	public boolean isState() {
		return state;
	}

	public void setState(boolean state) {
		this.state = state;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getResult() {
		return result;
	}

	public void setResult(Object result) {
		this.result = result;
	}
	
	
	
}
