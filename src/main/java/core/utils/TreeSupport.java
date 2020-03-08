package core.utils;

import java.util.Set;

/**
 * Created by majid on 6/22/16.
 */
public interface TreeSupport<T>{

    Set<T> getChildren();
    boolean isActive();
    boolean isLeaf();
    void setLeaf(boolean b);

    TreeSupport<T> getParent();

    Long getId();
    String getCode();

    String getPathId();
    String getPathCode();
    void setPathId(String s);
    void setPathCode(String s);
}
