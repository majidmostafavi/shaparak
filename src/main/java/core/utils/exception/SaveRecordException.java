package core.utils.exception;

import javax.ejb.ApplicationException;


/**
 * Created by majid on 7/27/17.
 */
@ApplicationException(rollback=true)
public class SaveRecordException extends Exception {
    private static final String s = "Save Record Data Exception";
    public SaveRecordException() {
        super(s);
    }
}
