package com.example.springcloud.dao;

import com.example.springcloud.module.Organization;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("organizationDao")
public interface OrganizationDao {

    public void saveOrg(Organization organization);
    public List queryByOrgId(String orgId);
}