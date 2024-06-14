package biz.restobar.platform.u202210749.attention.domain.exceptions;

/**
 * Exception thrown when a client is not found
 * @author Piero Gonzalo Delgado Corrales
 * @version 1.0
 */
public class ClientNotFoundException extends RuntimeException{
    /**
     * Constructor
     * @param aLong id of the client that was not found
     * @author Piero Gonzalo Delgado Corrales
     */
    public ClientNotFoundException(Long aLong) {
        super("Client with id " + aLong + " not found");
    }
}
