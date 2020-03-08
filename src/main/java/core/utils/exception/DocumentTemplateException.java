package core.utils.exception;

import javax.ejb.ApplicationException;

/**
 * Created by armiiit on Jul, 2018
 */

@ApplicationException(rollback=true)
public class DocumentTemplateException  extends Exception {
    private static final String s = "Document Template Exception";
    public DocumentTemplateException() {
        super(s);
    }

    public DocumentTemplateException(String string) {
        super(string);
    }
}
