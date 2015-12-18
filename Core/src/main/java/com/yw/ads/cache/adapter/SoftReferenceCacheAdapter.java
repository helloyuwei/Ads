package com.yw.ads.cache.adapter;


import com.yw.ads.cache.Cache;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dylanyu on 12/18/2015.
 */
public class SoftReferenceCacheAdapter implements CacheAdapter {

    private List<SoftReference<Cache<?>>> mCacheList;
    private static CacheAdapter INSTANCE;

    static {
        INSTANCE = new SoftReferenceCacheAdapter();
    }

    private SoftReferenceCacheAdapter() {
        mCacheList = new ArrayList<SoftReference<Cache<?>>>();
    }

    public static CacheAdapter getAdapter() {
        return INSTANCE;
    }

    public <T> void add(Cache<T> pCache) {
        mCacheList.add(new SoftReference<Cache<?>>(pCache));
    }

    public <T> void add(String pKey, T pValue) {

        mCacheList.add(new SoftReference<Cache<?>>(new Cache<T>(pKey, pValue)));
    }

    public <T> Cache<T> getCache(String pKey) {
        SoftReference<Cache<?>> cache;
        for (int i = mCacheList.size(); i > 0; i--) {
            cache = mCacheList.get(i--);
            if (cache.get().getKey().equals(pKey)) {
                return (Cache<T>) cache.get();
            }
        }
        return null;
    }

    public <T> T get(String pKey) {
        SoftReference<Cache<?>> cache;
        for (int i = mCacheList.size(); i > 0; i--) {
            cache = mCacheList.get(i--);
            if (cache.get().getKey().equals(pKey)) {
                return (T) cache.get().getValue();
            }
        }
        return null;
    }

    @Override
    public boolean contains(String pKey) {
        return getCache(pKey) == null ? false : true;
    }
}
