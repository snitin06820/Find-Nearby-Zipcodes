package com.nitin.finding_nearby_zipcodes.service;

import com.nitin.finding_nearby_zipcodes.entity.ZipLocation;
import com.nitin.finding_nearby_zipcodes.repository.ZiplocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ZiplocationServiceImpl implements ZiplocationService {

    @Autowired
    private ZiplocationRepository zipLocationRepository;

    @Override
    public void saveZipLocation(ZipLocation zipLocation) {
        zipLocationRepository.save(zipLocation);
    }

    @Override
    public ZipLocation getDataByZipcode(String zipcode) {
        return !zipcode.isBlank() ? zipLocationRepository.findByStdZip5(zipcode) : null;
    }

    @Override
    public List<ZipLocation> getNearbyZipcodes(String zipcode, Integer radius) {
        ZipLocation ziplocation = getDataByZipcode(zipcode);
        if (ziplocation != null) {
            return zipLocationRepository.NearbyCodes(ziplocation.getStdZip5(), ziplocation.getLatitude(),
                    ziplocation.getLongitude(), radius);
        }
        return null;
    }
}
