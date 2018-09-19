/**
 * 
 */
package cache;

import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.cache.CacheProperties;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Mo Jianyue
 *
 * @date 创建时间 2018年9月19日 下午5:13:24
 * 
 * 执行缓存测试
 * 
 */
@RestController
public class Controller {
    
    
    private static final Logger log = LoggerFactory.getLogger(Controller.class);

    @Autowired
    CacheManager cacheManager;
    
    @Autowired
    CacheProperties cacheProperties;
    
    @Autowired
    CacheQuery cache;
    
    /**
     * 查看缓存的信息
     */
    @GetMapping("/1")
    public void getProperties(){
        /*
         * cacheProperties中保存选用的缓存类型，支持的类型有6种，具体查看CacheType类
         * 
         */
        log.info("缓存类型{}",cacheProperties.getType());
        
        Collection<String> cacheNames = cacheManager.getCacheNames();
         for (String name : cacheNames) {
            log.info("已经配置的名：{}",name);
        }
        
    }
    
    /**
     * 正常缓存测试
     */
    @RequestMapping("/2")
    public void queryTest(){
        log.info("查询返回值【{}】",cache.query(1L));
    }
    
    /**
     * 缓存无效调用
     */
    @RequestMapping("/3")
    public void queryTest2(){
        log.info("查询返回值【{}】,同一个类中的方法调用测试",cache.query2(1L));
    }
    
    /**
     * 注解的方法调用另一个带注解的方法
     */
    @RequestMapping("/4")
    public void queryTest4(){
        log.info("查询返回值【{}】,调用不同类的方法，该方法调用另一个有@Cacheable注解的方法",cache.query4(1L));
    }
    
    
}
