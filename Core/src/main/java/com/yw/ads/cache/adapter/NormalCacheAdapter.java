package com.yw.ads.cache.adapter;

import com.yw.ads.CollectionUtils;
import com.yw.ads.cache.Cache;
import java.util.List;

/**
 * Created by dylanyu on 12/31/2015.
 */
public class NormalCacheAdapter implements CacheAdapter {

    private ThreadLocal<List<Cache<?>>> mCacheThreadLocal;
    private static CacheAdapter INSTANCE;

    static {
        INSTANCE = new NormalCacheAdapter();
    }

    public static CacheAdapter getAdapter() {
        return INSTANCE;
    }

    private NormalCacheAdapter() {
        mCacheThreadLocal = new ThreadLocal<List<Cache<?>>>();
    }

    @Override
    public <T> void add(Cache<T> pCache) {
        mCacheThreadLocal.get().add(pCache);
    }

    @Override
    public <T> void add(String pKey, T pValue) {
        Cache<T> existCache = getCache(pKey);
        if (existCache != null) {
            existCache.setValue(pValue);
            return;
        }
        Cache<T> cache = new Cache<T>(pKey, pValue);
        mCacheThreadLocal.get().add(cache);
    }

    @Override
    public <T> Cache<T> getCache(String pKey) {
        if (CollectionUtils.isEmpty(mCacheThreadLocal.get())) {
            return null;
        }
        List<Cache<?>> cacheList = mCacheThreadLocal.get();
        int cacheSize = cacheList.size();
        Cache<T> tmp;
        for (int i = 0; i < cacheSize; i++) {
            tmp = (Cache<T>) cacheList.get(i);
            if (tmp == null) {
                continue;
            }
            if (tmp.getKey().equals(pKey)) {
                return tmp;
            }
        }
        return null;
    }

    @Override
    public <T> T get(String pKey) {
        Cache<T> cache = getCache(pKey);
        if (cache == null) {
            return null;
        }
        return cache.getValue();
    }

    @Override
    public boolean contains(String pKey) {
        return getCache(pKey) == null ? false : true;
    }
}
