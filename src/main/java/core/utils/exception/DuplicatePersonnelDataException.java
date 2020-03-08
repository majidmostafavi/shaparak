package core.utils.exception;

import javax.ejb.ApplicationException;

/**
 * Created by shaghayegh on 10/15/18.
 */
@ApplicationException(rollback=true)
public class DuplicatePersonnelDataException extends Exception {
    private static final String s = "Duplicate Personnel Data Exception";
    public DuplicatePersonnelDataException() {
        super(s);
    }
    public DuplicatePersonnelDataException (String s){
        super(s);
    }
}
