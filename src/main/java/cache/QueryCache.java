/**
 * 
 */
package cache;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

/**
 *
 * @author Mo Jianyue
 *
 * @date 创建时间 2018年9月19日 下午5:13:24
 * 
 */
@Component
public class QueryCache {
    
    @Cacheable(value="users")
    public String query(Long id){
        
        System.out.println("执行查询");
        return "数据";
    }
}
