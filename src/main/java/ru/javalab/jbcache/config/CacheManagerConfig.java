package ru.javalab.jbcache.config;

import com.github.benmanes.caffeine.cache.Caffeine;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.CacheManager;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

@Configuration
public class CacheManagerConfig {

    public static final String TEST_CACHE = "repository-cache";

    @Value("${cache.repository.max-size:10000}")
    private Long maxTestCached;

    @Value("${cache.repository.expiration-minutes:30}")
    private Long testExpirationMinutes;

    @Bean
    public CacheManager repositoryCacheManager() {
        CaffeineCacheManager cacheManager = new CaffeineCacheManager(TEST_CACHE);
        cacheManager.setCaffeine(testCache());
        cacheManager.setAllowNullValues(true);
        return cacheManager;
    }

    private Caffeine<Object, Object> testCache() {
        Caffeine<Object, Object> build = Caffeine.newBuilder()
                .maximumSize(maxTestCached)
                .expireAfterAccess(testExpirationMinutes, TimeUnit.MINUTES)
                .softValues()
                .recordStats();
        return build;
    }

}
