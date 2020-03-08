package core.utils.exception;

import javax.ejb.ApplicationException;

/**
 * Created by majid on 2/20/17.
 */
@ApplicationException(rollback=true)
public class PersonnelDataException extends Exception {
    private static final String s = "Personnel Delete Data Exception";
    public PersonnelDataException() {
        super(s);
    }
}
