package ru.javalab.jbcache.config;

import com.github.benmanes.caffeine.cache.Caffeine;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.cache.interceptor.CacheResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

@Configuration
public class MultipleCacheManagerConfig extends CachingConfigurerSupport {

    public static final String TEST1_CACHE = "test1-cache";
    public static final String TEST2_CACHE = "test2-cache";

    @Value("${cache.repository.max-size:10000}")
    private Long maxTest1Cached;

    @Value("${cache.repository.expiration-minutes:30}")
    private Long test1ExpirationMinutes;

    @Bean
    public CacheManager cacheManager() {
        CaffeineCacheManager cacheManager = new CaffeineCacheManager(TEST1_CACHE);
        cacheManager.setCaffeine(Caffeine.newBuilder()
                .expireAfterAccess(test1ExpirationMinutes, TimeUnit.MINUTES)
                .maximumSize(maxTest1Cached)
                .weakKeys()
                .recordStats());
        return cacheManager;
    }

    @Bean
    public CacheManager alternateCacheManager() {
        return new ConcurrentMapCacheManager(TEST2_CACHE);
    }

    @Bean
    public CacheResolver cacheResolver() {
        return new MultipleCacheResolver(alternateCacheManager(), cacheManager());
    }
}
