package ru.javalab.jbcache.service;

import lombok.RequiredArgsConstructor;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import ru.javalab.jbcache.config.MultipleCacheManagerConfig;

@Service
@RequiredArgsConstructor
@CacheConfig(cacheResolver = "cacheResolver",cacheNames = {MultipleCacheManagerConfig.TEST1_CACHE, MultipleCacheManagerConfig.TEST2_CACHE})
public class Cache2Service {

    private final CacheManager cacheManager;

    @Cacheable(cacheManager = "cacheManager", cacheNames = MultipleCacheManagerConfig.TEST1_CACHE)
    public String privetMethod(String string){
        System.out.println();
        System.out.println("IN METHOD");
        System.out.println();
        switch (string){
            case "USER1":{
                return "Privet, USER1!";
            }
            case "USER2":{
                return "Privet, USER2!";
            }
            case "USER3":{
                return "Privet, USER3!";
            }
            case "USER4":{
                return "Privet, USER4!";
            }
            default:{
                return "Privet, Anonymous";
            }
        }
    }

    @Cacheable(cacheManager = "alternateCacheManager", cacheNames = MultipleCacheManagerConfig.TEST2_CACHE)
    public String pokaMethod(String string){
        System.out.println();
        System.out.println("IN METHOD");
        System.out.println();
        switch (string){
            case "USER1":{
                return "Poka, USER1!";
            }
            case "USER2":{
                return "Poka, USER2!";
            }
            case "USER3":{
                return "Poka, USER3!";
            }
            case "USER4":{
                return "Poka, USER4!";
            }
            default:{
                return "Poka, Anonymous";
            }
        }
    }
}
