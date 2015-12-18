package com.yw.ads.cache.adapter;

import com.yw.ads.cache.Cache;

/**
 * Created by dylanyu on 12/18/2015.
 */
public interface CacheAdapter {
    <T> void add(Cache<T> pCache);

    <T> void add(String pKey, T pValue);

    <T> Cache<T> getCache(String pKey);

    <T> T get(String pKey);

    boolean contains(String pKey);
}
