package core.utils.exception;

import javax.ejb.ApplicationException;

/**
 * Created by shaghayegh on 1/21/18.
 */
@ApplicationException(rollback=true)
public class StateActionException extends Exception {
    private static final String s = "StateAction Exception";

    public StateActionException() {
        super(s);
    }

    public StateActionException(String s) {
        super(s);
    }
}
