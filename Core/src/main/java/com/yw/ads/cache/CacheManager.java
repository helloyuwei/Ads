package com.yw.ads.cache;

import com.yw.ads.cache.adapter.CacheAdapter;
import com.yw.ads.cache.adapter.SoftReferenceCacheAdapter;

/**
 * Created by dylanyu on 12/18/2015.
 */
public class CacheManager {
    private CacheAdapter mSoftReferenceCacheAdapter;

    public CacheManager() {
        mSoftReferenceCacheAdapter = SoftReferenceCacheAdapter.getAdapter();
    }
}
