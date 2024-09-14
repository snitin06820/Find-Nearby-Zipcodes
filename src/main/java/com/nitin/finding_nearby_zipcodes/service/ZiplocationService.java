package com.nitin.finding_nearby_zipcodes.service;

import com.nitin.finding_nearby_zipcodes.entity.ZipLocation;

import java.util.List;

public interface ZiplocationService {
    public void saveZipLocation(ZipLocation zipLocation);
    public ZipLocation getDataByZipcode(String zipcode);
    public List<ZipLocation> getNearbyZipcodes(String zipcode, Integer radius);
}
