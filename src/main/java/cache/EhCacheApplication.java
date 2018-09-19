package cache;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Mo Jianyue
 *
 * @date 创建时间 2018年9月19日 下午5:37:20
 * 
 * @EnableCaching 注解，使得缓存生效

 * 
 */

@SpringBootApplication
@EnableCaching
@RestController
public class EhCacheApplication {
    
	public static void main(String[] args) {
		SpringApplication.run(EhCacheApplication.class, args);
	}
	
	
	
}
