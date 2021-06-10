package ru.javalab.jbcache.service;

import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TestService {

    private final CacheService cacheService;
    private final Cache2Service cacheService2;

    @Scheduled(fixedRate=60*60*1000)
    public void getCache(){
        String user1 = "USER1";
        String user2 = "USER2";
        String user3 = "USER3";
        String user4 = "USER4";

        for (int i = 0; i < 10; i++) {
            System.out.println(cacheService.cacheMethod(user1));
        }

//        System.out.println(cacheService.pokaMethod(user1));
//        System.out.println(cacheService.cacheMethod(user1));

        for (int i = 0; i < 20; i++) {
            System.out.println(cacheService.cacheMethod(user2));
        }

        for (int i = 0; i < 30; i++) {
            System.out.println(cacheService.cacheMethod(user3));
        }

        for (int i = 0; i < 40; i++) {
            System.out.println(cacheService.cacheMethod(user4));
        }
    }

    //@Scheduled(fixedRate=60*60*1000)
    public void get() {
        String user1 = "USER1";
        String user2 = "USER2";
        String user3 = "USER3";
        String user4 = "USER4";

        for (int i = 0; i < 10; i++) {
            System.out.println(cacheService2.privetMethod(user1));
        }

        for (int i = 0; i < 10; i++) {
            System.out.println(cacheService2.pokaMethod(user1));
        }
    }
}
