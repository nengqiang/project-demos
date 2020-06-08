package com.hnq.fly.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.GenericToStringSerializer;

/**
 * redis 配置<br>
 * 集群下启动 session 共享，需打开{@link @EnableRedisHttpSession}，单机下不需要
 *
 * @author henengqiang
 * @date 2020/5/31
 */
@Configuration
public class RedisConfig {

    @Bean("redisTemplate")
    public <K, V> RedisTemplate<K, V> redisTemplate(@Lazy RedisConnectionFactory connectionFactory) {
        RedisTemplate<K, V> redis = new RedisTemplate<>();
        GenericToStringSerializer<String> keySerializer = new GenericToStringSerializer<>(String.class);
        redis.setKeySerializer(keySerializer);
        redis.setHashKeySerializer(keySerializer);
        GenericJackson2JsonRedisSerializer valueSerializer = new GenericJackson2JsonRedisSerializer();
        redis.setValueSerializer(valueSerializer);
        redis.setHashValueSerializer(valueSerializer);
        redis.setConnectionFactory(connectionFactory);
        return redis;
    }

}
