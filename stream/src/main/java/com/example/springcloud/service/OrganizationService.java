package com.example.springcloud.service;

import com.example.springcloud.module.Organization;

import java.util.List;


public interface OrganizationService {

    public void saveOrg(Organization organization);

    public List queryByOrgId(String orgId);
}
