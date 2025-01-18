package cat.institutmarianao.salinig.ws.exception;

public class NotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    // Constructor por defecto
    public NotFoundException() {
        super();
    }

    // Constructor con mensaje
    public NotFoundException(String message) {
        super(message);
    }
}
