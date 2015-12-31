package com.yw.ads.cache;

import com.yw.ads.cache.adapter.CacheAdapter;
import com.yw.ads.cache.adapter.NormalCacheAdapter;
import com.yw.ads.cache.adapter.SoftReferenceCacheAdapter;

/**
 * Created by dylanyu on 12/18/2015.
 */
public class CacheManager {

    private CacheAdapter cacheAdapter;

    public CacheManager(CacheLifecycle pLifecycle) {
        switch (pLifecycle) {
            case REFRENCE: {
                cacheAdapter = SoftReferenceCacheAdapter.getAdapter();
                break;
            }
            case THREAD: {
                cacheAdapter = NormalCacheAdapter.getAdapter();
            }
        }
    }





    public enum CacheLifecycle {
        //save cache as soft reference object
        REFRENCE,
        //save cache to thread local object
        THREAD

    }
}
