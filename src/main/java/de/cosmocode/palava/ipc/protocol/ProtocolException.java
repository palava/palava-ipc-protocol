package de.cosmocode.palava.ipc.protocol;


/**
 * Indicates an error in {@link Protocol#process(Object, DetachedConnection)}.
 *
 * @author Willi Schoenborn
 */
public class ProtocolException extends Exception {

    private static final long serialVersionUID = -3563963370141966005L;

    public ProtocolException() {
        super();
    }

    public ProtocolException(String message, Throwable cause) {
        super(message, cause);
    }

    public ProtocolException(String message) {
        super(message);
    }

    public ProtocolException(Throwable cause) {
        super(cause);
    }

}
