package com.example.springcloud.dao;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("licenseDao")
public interface LicenseDao {

    public List getLicensesByOrg(String organizationId);
    //public License getLicensesByOrgAndLicenseId(String organizationId,String licenseId);
}