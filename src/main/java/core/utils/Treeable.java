package core.utils;



/**
 * Created by majid on 11/6/16.
 */
public interface Treeable<T> {

    T getId();
    default T getParentId() {
        return null;
    }
    default boolean isLeaf() { return true; }
}
