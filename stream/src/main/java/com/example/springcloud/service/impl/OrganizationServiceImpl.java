package com.example.springcloud.service.impl;

import com.example.springcloud.SimpleSourceBean;
import com.example.springcloud.dao.OrganizationDao;
import com.example.springcloud.module.Organization;
import com.example.springcloud.service.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * 消息生产者
 */
@Service
public class OrganizationServiceImpl implements OrganizationService{

    @Autowired
    private OrganizationDao organizationDao;

    @Autowired
    private SimpleSourceBean simpleSourceBean;

    @Override
    public void saveOrg(Organization organization) {
        organization.setOrgId(UUID.randomUUID().toString());
        organizationDao.saveOrg(organization);
        simpleSourceBean.publishOrgChange("SAVE",organization.getOrgId());
    }

    @Override
    public List queryByOrgId(String orgId) {
        List organization = organizationDao.queryByOrgId(orgId);
        simpleSourceBean.publishOrgChange("QUERY",orgId);
        return organization;
    }
}
