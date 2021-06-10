package ru.javalab.jbcache.config;

import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.interceptor.CacheOperationInvocationContext;
import org.springframework.cache.interceptor.CacheResolver;

import java.util.ArrayList;
import java.util.Collection;

public class MultipleCacheResolver implements CacheResolver {

    public static final String TEST1_CACHE = "test1-cache";
    public static final String TEST2_CACHE = "test2-cache";
    private final CacheManager caffeineCacheManager;
    private final CacheManager cacheManager;

    public MultipleCacheResolver(CacheManager caffeineCacheManager, CacheManager cacheManager) {
        this.caffeineCacheManager = caffeineCacheManager;
        this.cacheManager = cacheManager;
    }

    @Override
    public Collection<? extends Cache> resolveCaches(CacheOperationInvocationContext<?> cacheOperationInvocationContext) {
        Collection<Cache> caches = new ArrayList<Cache>();
        if (TEST1_CACHE.equals(cacheOperationInvocationContext.getMethod().getName())) {
            caches.add(caffeineCacheManager.getCache(TEST1_CACHE));
        } else {
            caches.add(cacheManager.getCache(TEST2_CACHE));
        }
        return caches;
    }
}
