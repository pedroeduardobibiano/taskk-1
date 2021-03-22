package model.exeptions;

public class DomainExeption extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public DomainExeption(String msg) {
		super(msg);
	}

}
