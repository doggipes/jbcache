package ru.javalab.jbcache.service;

import lombok.RequiredArgsConstructor;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import ru.javalab.jbcache.config.CacheManagerConfig;

@Service
@RequiredArgsConstructor
@CacheConfig(cacheManager = "repositoryCacheManager", cacheNames = CacheManagerConfig.TEST_CACHE)
public class CacheService {

    private final CacheManager cacheManager;

    @Cacheable
    public String cacheMethod(String string){
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

    @CacheEvict
    public String pokaMethod(String string){
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
