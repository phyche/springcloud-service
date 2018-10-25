package com.example.springcloud.service;


import java.util.List;

public interface LicenseService {

    public List getLicensesByOrg(String organizationId);
}
