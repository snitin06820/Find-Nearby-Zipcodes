package com.nitin.finding_nearby_zipcodes.service;

import com.nitin.finding_nearby_zipcodes.entity.ZipLocation;

import java.util.List;

public interface ZiplocationService {
    void saveZipLocation(ZipLocation zipLocation);
    ZipLocation getDataByZipcode(String zipcode);
    List<ZipLocation> getNearbyZipcodes(String zipcode, Integer radius);
}
