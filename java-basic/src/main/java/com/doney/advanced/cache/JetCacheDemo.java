package com.doney.advanced.cache;

import com.alicp.jetcache.Cache;
import com.alicp.jetcache.anno.CacheType;
import com.alicp.jetcache.anno.Cached;
import com.alicp.jetcache.anno.CreateCache;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("cache")
public class JetCacheDemo {

    @CreateCache(name = "jet-cache-", cacheType = CacheType.REMOTE)
    private Cache<String,String> cache;

    @GetMapping
    @Cached
    public String get(String key){
        return cache.get(key);
    }

    @PutMapping
    @Cached
    public boolean put(String key,String value){
        cache.put(key,value);
        return true;
    }

    @DeleteMapping
    @Cached
    public boolean delete(String key){
        cache.remove(key);
        return true;
    }
}
