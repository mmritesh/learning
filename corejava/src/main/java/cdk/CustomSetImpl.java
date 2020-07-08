package cdk;

import java.util.HashMap;
import java.util.Map;

public class CustomSetImpl<T> implements CustomSet<T> {

    private Map<T, Object> map = new HashMap();

    private final Object obj = new Object();

    /**
     * k1, k2
     *
     * k1, obj
     * @param item
     *
     * 123, e1
     * 567, e2
     * 567, e2
     *
     * 1 -> (123, e1) -> (567, e2) -> null
     */
    @Override
    public void add(T item) {
        map.put(item, obj);
    }

    @Override
    public boolean remove(T item) {
        return map.remove(item) == obj;
    }

    @Override
    public boolean contains(T item) {
        return map.get(item) == obj;
    }

}
