package com.example.springcloud.service.impl;

import com.example.springcloud.module.Organization;
import com.example.springcloud.service.RedisService;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.List;

@Repository
public class RedisServiceImpl implements RedisService{

    private static final String HASH_NAME = "organization";
    @Resource
    private RedisTemplate<String,Object> redisTemplate;
    private HashOperations hashOperations;

    public RedisServiceImpl() {
        super();
    }

    public RedisServiceImpl(RedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @PostConstruct
    private void init() {
        hashOperations = redisTemplate.opsForHash();
    }



    @Override
    public void saveOrg(Organization organization) {
        redisTemplate.opsForHash().put(HASH_NAME,organization.getOrgId(),organization);
    }

    @Override
    public Organization queryOrgByOrgId(String orgId) {
        return (Organization) hashOperations.get(HASH_NAME,orgId);
    }

    @Override
    public void deleteOrgByOrgId(String orgId) {
        hashOperations.delete(HASH_NAME,orgId);
    }
}
