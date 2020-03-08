package core.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by majid on 12/6/16.
 */
public class NejatCache<K,V> extends HashMap<K,V> {
    public NejatCache() {

    }

    public NejatCache(int initialCapacity) {
        super(initialCapacity);
    }

    public NejatCache(Map<K,V> m) {
        super(m);
    }

    public NejatCache(int initialCapacity, float loadFactor) {
        super(initialCapacity, loadFactor);
    }
}
