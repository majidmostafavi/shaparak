package core.utils.exception;

import javax.ejb.ApplicationException;

/**
 * Created by majid on 12/22/16.
 */
@ApplicationException(rollback=true)
public class RelationDataException extends Exception {
    private static final String s = "Relation Data Exception";
    public RelationDataException() {
        super(s);
    }

}
