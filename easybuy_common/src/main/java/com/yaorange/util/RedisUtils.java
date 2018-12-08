package com.yaorange.util;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.yaorange.util.StrUtils;
import com.yaorange.util.encrypt.MD5;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.exceptions.JedisConnectionException;

public final class RedisUtils {

	// 可用连接实例的最大数目，默认值为8；
	// 如果赋值为-1，则表示不限制；如果pool已经分配了maxTotal个jedis实例，则此时pool的状态为exhausted(耗尽)。
	private static int MAX_TOTAL = 100;

	// 控制一个pool最多有多少个状态为idle(空闲的)的jedis实例，默认值也是8。
	private static int MAX_IDLE = 20;

	// 等待可用连接的最大时间，单位毫秒，默认值为-1，表示永不超时。如果超过等待时间，则直接抛出JedisConnectionException；
	private static int MAX_WAIT = 20000;

	// 超时时间 毫秒
	private static int TIMEOUT = 20000;

	private static JedisPool jedisPool = null;
	/**
	 * 初始化Redis连接池
	 */
	static {
		try {
			JedisPoolConfig config = new JedisPoolConfig();
			// 连接耗尽时是否阻塞, false报异常,ture阻塞直到超时, 默认true
			config.setBlockWhenExhausted(true);
			// 设置的逐出策略类名, 默认DefaultEvictionPolicy(当连接超过最大空闲时间,或连接数超过最大空闲连接数)
			config.setEvictionPolicyClassName("org.apache.commons.pool2.impl.DefaultEvictionPolicy");
			// 是否启用pool的jmx管理功能, 默认true
			config.setJmxEnabled(true);
			// 最大空闲连接数, 默认8个 控制一个pool最多有多少个状态为idle(空闲的)的jedis实例。
			config.setMaxIdle(MAX_IDLE);
			// 最大连接数, 默认8个
			config.setMaxTotal(MAX_TOTAL);
			// 表示当borrow(引入)一个jedis实例时，最大的等待时间，如果超过等待时间，则直接抛出JedisConnectionException；
			config.setMaxWaitMillis(MAX_WAIT);
			// 在borrow一个jedis实例时，是否提前进行validate操作；如果为true，则得到的jedis实例均是可用的；
			config.setTestOnBorrow(true);
			config.setTestOnReturn(true);
			jedisPool = new JedisPool(config, "192.168.23.130", 6379, TIMEOUT,"123456");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 获取Jedis实例
	 *
	 * @return
	 */
	public synchronized static Jedis getInstance() {
		Jedis resource = null;
		try {
			if (jedisPool != null) {
				resource = jedisPool.getResource();
				return resource;
			} else {
				return null;
			}
		} catch (JedisConnectionException e) {
			close(resource);
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * @功能：通过Redis的key获取值，并释放连接资源
	 * @参数：key，键值 @返回： 成功返回value，失败返回null
	 */
	public static String get(String key) {
		Jedis jedis = null;
		String value = null;
		try {
			jedis = getInstance();
			value = jedis.get(key);
		} catch (Exception e) {
			close(jedis);
			e.printStackTrace();
		} finally {
			close(jedis);
		}
		return value;
	}

	/**
	 * @功能：向redis存入key和value（如果key已经存在 则覆盖），并释放连接资源
	 * @参数：key，键
	 * @参数：value，与key对应的值 @返回：成功返回“OK”，失败返回“FAIL”
	 */
	public static String set(String key, String value) {
		Jedis jedis = null;
		String ret = "FAIL";
		try {
			jedis = getInstance();
			ret = jedis.set(key, value);
		} catch (Exception e) {
			close(jedis);
			e.printStackTrace();
		} finally {
			close(jedis);
		}
		return ret;
	}

	/**
	 * @功能：向redis存入具有过期时间的key和value（如果key已经存在 则覆盖），并释放连接资源
	 * @参数：key，键
	 * @参数：seconds，过期时间（秒） @参数：value，与key对应的值 @返回：成功返回“OK”，失败返回“FAIL”
	 */
	public static String setex(String key, Integer seconds, String value) {
		Jedis jedis = null;
		String ret = "FAIL";
		try {
			jedis = getInstance();
			ret = jedis.setex(key, seconds, value);
		} catch (Exception e) {
			close(jedis);
			e.printStackTrace();
		} finally {
			close(jedis);
		}
		return ret;
	}

	/**
	 * @功能：通过Redis的key删除，并释放连接资源
	 * @参数：key，键值 @返回： 成功返回value，失败返回null
	 */
	public static Long del(String key) {
		Jedis jedis = null;
		Long ret = null;
		try {
			jedis = getInstance();
			ret = jedis.del(key);
		} catch (Exception e) {
			close(jedis);
			e.printStackTrace();
		} finally {
			close(jedis);
		}
		return ret;
	}

	/**
	 * @功能：通过Redis设置key的过期时间，并释放连接资源
	 * @参数：key，键值
	 * @参数：seconds，过期秒数 @返回： 成功返回value，失败返回null
	 */
	public static Long expire(String key, int seconds) {
		Jedis jedis = null;
		Long ret = null;
		try {
			jedis = getInstance();
			ret = jedis.expire(key, seconds);
		} catch (Exception e) {
			close(jedis);
			e.printStackTrace();
		} finally {
			close(jedis);
		}
		return ret;
	}

	public static Long decr(String key) {
		Jedis jedis = null;
		Long ret = null;
		try {
			jedis = getInstance();
			ret = jedis.decr(key);
		} catch (Exception e) {
			close(jedis);
			e.printStackTrace();
		} finally {
			close(jedis);
		}
		return ret;
	}

	/**
	 * 释放jedis资源
	 *
	 * @param jedis
	 */
	public static void close(final Jedis jedis) {
		if (jedis != null) {
			jedis.close();
		}
	}

	public static void main(String[] args) {
		Jedis jedis = RedisUtils.getInstance();
		// jedis.set("test", "nixianhua");
		System.out.println(jedis.get("SMSCODE:18000534097"));
		// RedisUtil.testString(jedis);
		// RedisUtils.testMap(jedis);
		// RedisUtils.testList(jedis);
		// RedisUtils.testSet(jedis);
		RedisUtils.close(jedis);
	}

	/**
	 * 字符串测试
	 *
	 * @param jedis
	 */
	public static void testString(Jedis jedis) {
		jedis.set("name", "xxxx");// 向key-->name中放入了value-->xinxin
		System.out.println(jedis.get("name"));// 执行结果：xinxin

		jedis.append("name", " is my lover"); // 拼接
		System.out.println(jedis.get("name"));

		jedis.del("name"); // 删除某个键
		System.out.println(jedis.get("name"));
		// 设置多个键值对
		jedis.mset("name", "某某某", "age", "24", "qq", "476777XXX");
		jedis.incr("age"); // 进行加1操作
		System.out.println(jedis.get("name") + "-" + jedis.get("age") + "-" + jedis.get("qq"));
	}

	/**
	 * map 用法
	 *
	 * @param jedis
	 */
	public static void testMap(Jedis jedis) {
		// -----添加数据----------
		Map<String, String> map = new HashMap<String, String>();
		map.put("name", "xinxin");
		map.put("age", "22");
		map.put("qq", "123456");
		jedis.hmset("user", map);
		// 取出user中的name，执行结果:[minxr]-->注意结果是一个泛型的List
		// 第一个参数是存入redis中map对象的key，后面跟的是放入map中的对象的key，后面的key可以跟多个，是可变参数
		List<String> rsmap = jedis.hmget("user", "name", "age", "qq");
		System.out.println(rsmap);

		// 删除map中的某个键值
		jedis.hdel("user", "age");
		System.out.println(jedis.hmget("user", "age")); // 因为删除了，所以返回的是null
		System.out.println(jedis.hlen("user")); // 返回key为user的键中存放的值的个数2
		System.out.println(jedis.exists("user"));// 是否存在key为user的记录 返回true
		System.out.println(jedis.hkeys("user"));// 返回map对象中的所有key
		System.out.println(jedis.hvals("user"));// 返回map对象中的所有value

		Iterator<String> iter = jedis.hkeys("user").iterator();
		while (iter.hasNext()) {
			String key = iter.next();
			System.out.println(key + ":" + jedis.hmget("user", key));
		}
	}

	/**
	 * jedis操作List
	 */
	public static void testList(Jedis jedis) {
		// 开始前，先移除所有的内容
		jedis.del("java framework");
		System.out.println(jedis.lrange("java framework", 0, -1));
		// 先向key java framework中存放三条数据
		jedis.lpush("java framework", "spring");
		jedis.lpush("java framework", "struts");
		jedis.lpush("java framework", "hibernate");
		// 再取出所有数据jedis.lrange是按范围取出，
		// 第一个是key，第二个是起始位置，第三个是结束位置，jedis.llen获取长度 -1表示取得所有
		System.out.println(jedis.lrange("java framework", 0, -1));

		jedis.del("java framework");
		jedis.rpush("java framework", "spring");
		jedis.rpush("java framework", "struts");
		jedis.rpush("java framework", "hibernate");
		System.out.println(jedis.lrange("java framework", 0, -1));
	}

	/**
	 * jedis操作Set
	 */
	public static void testSet(Jedis jedis) {
		// 添加
		jedis.sadd("user", "liuling");
		jedis.sadd("user", "xinxin");
		jedis.sadd("user", "ling");
		jedis.sadd("user", "zhangxinxin");
		jedis.sadd("user", "who");
		// 移除noname
		jedis.srem("user", "who");
		System.out.println(jedis.smembers("user"));// 获取所有加入的value
		System.out.println(jedis.sismember("user", "who"));// 判断 who
															// 是否是user集合的元素
		System.out.println(jedis.srandmember("user"));
		System.out.println(jedis.scard("user"));// 返回集合的元素个数
	}



	// -------------------------------华丽的分割线-----------------------------------------------------
	public static String getSsoTGC(String ssoId) {
		int expireSeconds = 30 * 600;
		String tgc = MD5.getMD5(ssoId + StrUtils.getComplexRandomString(32));
		String tgt = ssoId;
		String tgcKey = "TGC-" + tgc;
		RedisUtils.setex(tgcKey, expireSeconds, tgt);
		return tgc;
	}

	public static void refreshTGCExpires(String tgc) {
		int expireSeconds = 30 * 600;
		String tgcKey = "TGC-" + tgc;
		RedisUtils.expire(tgcKey, expireSeconds);
	}

	public static void deleteSsoTGC(String tgc) {
		String tgcKey = "TGC-" + tgc;
		String tgt = RedisUtils.get(tgcKey);
		RedisUtils.del(tgcKey);
		// 同时删除SsoId
		String ssoIdKey = "u-" + tgt;
		RedisUtils.del(ssoIdKey);
	}

	public static boolean validateSsoTGC(String tgc) {
		String tgcKey = "TGC-" + tgc;
		String cacheTgc = RedisUtils.get(tgcKey);
		return null != cacheTgc;
	}

	public static String getSsoST(String tgc) {
		// int expireSeconds = 30;
		int expireSeconds = 3000;
		String tgcKey = "TGC-" + tgc;
		String tgt = RedisUtils.get(tgcKey);
		String st = MD5.getMD5(tgt + StrUtils.getComplexRandomString(32));
		String stKey = "ST-" + st;
		RedisUtils.setex(stKey, expireSeconds, tgt);
		return st;
	}

	public static String validateSsoST(String st) {
		String stKey = "ST-" + st;
		String tgt = RedisUtils.get(stKey);
		RedisUtils.del(stKey);
		return tgt;
	}

	public static void setRedisSsoId(Long ssoId) {
		int expireSeconds = 30 * 60;
		String key = "u-" + ssoId;
		RedisUtils.setex(key, expireSeconds, ssoId.toString());
	}

	public static Long refreshRedisSsoId(Long ssoId) {
		int expireSeconds = 30 * 600;
		String key = "u-" + ssoId;
		Long ret = RedisUtils.expire(key, expireSeconds);
		return ret;
	}

	public static String getRedisSsoId(Long ssoId) {
		String key = "u-" + ssoId;
		return RedisUtils.get(key);
	}

	public static Long delRedisSsoId(Long ssoId) {
		String key = "u-" + ssoId;
		return RedisUtils.del(key);
	}

}
