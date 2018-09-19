package cache;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.cache.CacheProperties;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
@EnableCaching
@RestController
public class EhCacheApplication {

    @Autowired
    CacheManager cacheManager;
    
    @Autowired
    CacheProperties cacheProperties;
    
    @Autowired
    QueryCache queryCache;
    
	public static void main(String[] args) {
		SpringApplication.run(EhCacheApplication.class, args);
	}
	
	@GetMapping("/1")
	public void test(){
	    List<String> cacheNames2 = cacheProperties.getCacheNames();
	    
	    Collection<String> cacheNames = cacheManager.getCacheNames();
	     for (String string : cacheNames) {
            System.out.println(string);
        }
	    
	    String query = queryCache.query(1L);
	    System.out.println(query);
	}
	
}
