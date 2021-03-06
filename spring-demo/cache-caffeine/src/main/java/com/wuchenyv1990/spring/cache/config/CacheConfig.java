package com.wuchenyv1990.spring.cache.config;

import com.github.benmanes.caffeine.cache.Caffeine;
import com.github.benmanes.caffeine.cache.LoadingCache;
import com.wuchenyv1990.spring.cache.service.ServiceFoo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

@Configuration
public class CacheConfig {

    @Bean(name = "loadingCacheA")
    public LoadingCache<String, String> loadingCacheA(
            CaffeineAProperties caffeineAProperties, ServiceFoo serviceFoo) {
        return Caffeine.newBuilder()
                .initialCapacity(caffeineAProperties.getInitialCapacity())
                .expireAfterWrite(caffeineAProperties.getExpireAfterWrite(), TimeUnit.SECONDS)
                .build(serviceFoo::getValue);
    }

}
