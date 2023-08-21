package dominio;

public class ContatoNaoExisteException extends Exception {

    /**
     * Creates a new instance of <code>ContatoNaoExisteException</code> without
     * detail message.
     */
    public ContatoNaoExisteException() {
    }

    /**
     * Constructs an instance of <code>ContatoNaoExisteException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public ContatoNaoExisteException(String msg) {
        super(msg);
    }
}
