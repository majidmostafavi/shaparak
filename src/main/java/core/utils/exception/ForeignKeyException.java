package core.utils.exception;

import javax.ejb.ApplicationException;

/**
 * Created by majid on 9/3/17.
 */
@ApplicationException(rollback = true)
public class ForeignKeyException extends RuntimeException {
    public ForeignKeyException(String message) {
        super(message);
    }
}
