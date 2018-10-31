package com.example.springcloud.service;

import com.example.springcloud.module.Organization;

import java.util.List;

public interface RedisService {

    public void saveOrg(Organization organization);
    public Organization queryOrgByOrgId(String orgId);
    public void deleteOrgByOrgId(String orgId);
}
