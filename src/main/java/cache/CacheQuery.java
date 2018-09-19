/**
 * 
 */
package cache;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

/**
 *
 * 模拟数据查询和缓存
 *
 * @author Mo Jianyue
 *
 * @date 创建时间 2018年9月19日 下午5:53:09
 * 
 */
@Component
public class CacheQuery {
    
    
    private static final Logger log = LoggerFactory.getLogger(CacheQuery.class);

    @Cacheable(value="demo")
    public String query(Long id){
        log.info("执行查询");
        return "数据";
    }

    /**
     * 测试同一个类中，调用带缓存注解的方法
     * @param l
     * @return
     */
    public Object query2(long l) {
        return query(l);
    }

    /**
     * 
     * 注解方法，调用另一个注解的方法
     * 
     * @param l
     * @return
     */
    @Cacheable(value="demo")
    public Object query4(long l) {
        return query(l);
    }

}
