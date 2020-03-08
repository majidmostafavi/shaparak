package core.utils.exception;

import javax.ejb.ApplicationException;

/**
 * Created by majid on 12/22/16.
 */
@ApplicationException(rollback=true)
public class DuplicateDataException extends Exception {
    private static final String s = "Duplicate Data Exception";
    public DuplicateDataException() {
        super(s);
    }
    public DuplicateDataException (String s){
        super(s);
    }
}
