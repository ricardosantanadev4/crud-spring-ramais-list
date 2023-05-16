package br.com.rsds.ramaislist.exception;

public class RecordNotFoundExceptiomn extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public RecordNotFoundExceptiomn (Long id) {
		super("Registro não encontrado com id: " + id);
	}
	
}
