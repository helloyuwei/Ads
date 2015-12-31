package com.yw.ads;

import java.util.Collection;

/**
 * Created by dylanyu on 12/31/2015.
 */
public class CollectionUtils {

    public static boolean isEmpty(Collection<?> pCollection) {
        return (pCollection == null || pCollection.isEmpty());
    }

    public static boolean isNotEmpty(Collection<?> pCollection) {
        return !isEmpty(pCollection);
    }
}
