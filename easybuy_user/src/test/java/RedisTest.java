import com.yaorange.util.RedisUtils;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class RedisTest {
    @Test
    public void test() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-redis.xml");
        //得到jedis连接池
        JedisPool jedisPool = (JedisPool) applicationContext.getBean("jedisPool");
        //获取一个jedis连接
        Jedis resource = jedisPool.getResource();
        String set = resource.set("redis", "good");
        System.out.println(set);
        String redis = resource.get("redis");
        System.out.println(redis);
    }

    @Test
    public void test1(){
        RedisUtils.setRedisSsoId(123L);
    }
}
