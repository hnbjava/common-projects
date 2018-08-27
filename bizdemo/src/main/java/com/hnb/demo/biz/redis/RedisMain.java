package com.hnb.demo.biz.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.List;
import java.util.Set;

/**
 * @author xiaolu
 * @date 2018/8/24 上午11:01
 */
public class RedisMain {
    public static void main(String[] args) {
        JedisPool jedisPool = new JedisPool(new JedisPoolConfig(), "118.25.235.213", 6379);
        Jedis jedis = jedisPool.getResource();
        testRedisList(jedis);
        testRedisSet(jedis);
        testRedisHash(jedis);
        jedisPool.close();
    }

    /**
     * redisHash
     *
     * @param jedis
     */
    private static void testRedisHash(Jedis jedis) {

        /**
         * jedis.hexists() 查看哈希表 key 中，指定的字段是否存在
         */
        String map0 = "hash_map_0";
        String map1 = "hash_map_2";
        String key0 = "key_0";
        String key1 = "key_1";
        String key2 = "key_2";
        System.out.println();
        System.out.println("============ Redis Hash ============");
        System.out.println();
        emptyMap(jedis, map0);

        String[] value = new String[0];
        jedis.hset(map0, key0, key0);
        jedis.hset(map0, key1, key1);
        jedis.hset(map0, key2, key2);
        System.out.println("=========== LEN:" + jedis.hlen(map0));

        coutHash(jedis, map0);
    }

    private static void coutHash(Jedis jedis, String map0) {
        String[] value = new String[0];
        //获取所有键
        value = jedis.hkeys(map0).toArray(value);
        for (String tmp : value) {
            //获取键值对
            System.out.println("key:" + tmp + "====value:" + jedis.hget(map0, tmp));
        }
    }

    /**
     * 清空数据
     *
     * @param jedis
     * @param map0
     */
    private static void emptyMap(Jedis jedis, String map0) {
        String[] value = new String[0];
        //获取所有键
        value = jedis.hkeys(map0).toArray(value);
        for (String tmp : value) {
            //删除键值对
            jedis.hdel(map0,tmp);
        }
    }

    /**
     * redis集合操作
     *
     * @param jedis
     */
    private static void testRedisSet(Jedis jedis) {
        String key = "set_hnb";
        String key0 = "set_hnb_0";
        String key1 = "set_hnb_1";
        String key2 = "set_hnb_2";
        String[] keys = {key, key0, key1};
        String[] value = new String[0];

        for (String tm : keys) {
            value = new String[0];
            //获取所有集合数据
            value = jedis.smembers(tm).toArray(value);
            //删除集合数据
            if (value.length > 0) {
                jedis.srem(tm, value);
            }
        }

        //集合添加
        System.out.println("======= 集合添加 ======");
        System.out.println(jedis.sadd("set_hnb", "Hello Set0"));
        System.out.println(jedis.sadd("set_hnb", "Hello Set0"));
        System.out.println(jedis.sadd("set_hnb", "Hello Set1"));
        System.out.println(jedis.sadd("set_hnb", "Hello Set2"));
        coutRedisSet(jedis, key);

        //集合元素数量
        System.out.println("======= 集合元素数量 ======");
        System.out.println(jedis.scard(key));

        //集合元素移动
        System.out.println("======= 集合元素移动 ======");
        System.out.println(jedis.smove(key, key + "_bak", "Hello Set0"));
        System.out.println(key + ":::");
        coutRedisSet(jedis, key);
        System.out.println(key + "_bak:::");
        coutRedisSet(jedis, key + "_bak");


        jedis.sadd(key0, "0","6");
        jedis.sadd(key0, "2");
        jedis.sadd(key0, "3");
        jedis.sadd(key0, "1");
        jedis.sadd(key1, "2");
        jedis.sadd(key1, "3");
        jedis.sadd(key1, "4");
        jedis.sadd(key1, "5");
        value = new String[0];
        System.out.printf("KEY0:");
        value = jedis.smembers(key0).toArray(value);
        coutArray(value);
        //多集合处理
        System.out.println("======= 多集合处理 ======");
        //SDIFF
        value = new String[0];
        System.out.printf("SDIFF:");
        value = jedis.sdiff(key0, key1).toArray(value);
        coutArray(value);

        //SINTER
        value = new String[0];
        System.out.printf("SINTER:");
        value = jedis.sinter(key0, key1).toArray(value);
        coutArray(value);

        //SUNION
        value = new String[0];
        System.out.printf("SUNION:");
        value = jedis.sunion(key0, key1).toArray(value);
        coutArray(value);

        //SDIFFSTORE
        value = new String[0];
        System.out.printf("SDIFFSTORE:");
        jedis.sdiffstore(key2, key0, key1);
        value = jedis.smembers(key2).toArray(value);
        coutArray(value);
    }

    private static void coutArray(String[] value) {
        for (String tmp : value) {
            System.out.printf(tmp + ",");
        }
        System.out.println();
    }

    private static void coutRedisSet(Jedis jedis, String key) {
        String[] value = new String[0];
        //获取所有集合数据
        value = jedis.smembers(key).toArray(value);
        coutArray(value);
    }


    /**
     * redis列表操作
     *
     * @param jedis
     */
    private static void testRedisList(Jedis jedis) {
        String sort1 = "sort-r";
        //清楚
        jedis.ltrim(sort1, -1, 0);

        jedis.rpush(sort1, new String[]{"插入1", "插入2", "插入3", "插入4"});
        System.out.println("========= 原始 =========");
        coutSortList(jedis, 0, 4);

        //裁剪
        jedis.ltrim(sort1, 1, 2);
        System.out.println("========= 裁剪 =========");
        coutSortList(jedis, 0, 4);

        //右端插入
        jedis.rpush(sort1, new String[]{"右端插入1", "右端插入2"});
        System.out.println("========= 右端插入 =========");
        coutSortList(jedis, 0, 3);

        //左端插入
        jedis.lpush(sort1, new String[]{"左端插入1", "左端插入2"});
        System.out.println("========= 左端插入 =========");
        coutSortList(jedis, 0, 4);

        //左端出栈
        System.out.println("========= 左端出栈 =========");
        System.out.println(jedis.lpop(sort1));
        coutSortList(jedis, 0, 4);

        //右端出栈
        System.out.println("========= 右端出栈 =========");
        System.out.println(jedis.lpop(sort1));
        coutSortList(jedis, 0, 4);

        //查找Index
        System.out.println("========= 查找Index =========");
        System.out.println(jedis.lindex(sort1, 2));
        coutSortList(jedis, 0, 4);
    }

    private static void coutSortList(Jedis jedis, int start, int end) {
        List list = jedis.lrange("sort-r", start, end);
        for (Object str : list) {
            System.out.printf(str + ",");
        }
        System.out.println();
    }
}
