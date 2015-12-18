package com.yw.ads.cache;

import java.io.Serializable;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * Created by dylanyu on 12/18/2015.
 */
public class Cache<T> implements Serializable {
    private String mKey;
    private T mValue;

    public Cache(String pKey, T pValue) {
        this.mKey = pKey;
        this.mValue = pValue;
    }

    public String getKey() {
        return mKey;
    }

    public void setKey(String pKey) {
        mKey = pKey;
    }

    public T getValue() {
        return mValue;
    }

    public void setValue(T pValue) {
        mValue = pValue;
    }

    @Override
    public int hashCode() {
        HashCodeBuilder hashCodeBuilder = new HashCodeBuilder();
        hashCodeBuilder.append(getKey()).append(getValue());
        return hashCodeBuilder.build();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Cache) {
            return false;
        }
        Cache cache = (Cache) obj;
        if (cache.getKey() == this.getKey() && cache.getValue() == this.getValue()) {
            return true;
        }
        return false;
    }
}
