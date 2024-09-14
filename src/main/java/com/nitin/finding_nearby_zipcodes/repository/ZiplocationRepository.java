package com.nitin.finding_nearby_zipcodes.repository;

import com.nitin.finding_nearby_zipcodes.entity.ZipLocation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ZiplocationRepository extends JpaRepository<ZipLocation, Long> {
    ZipLocation findByStdZip5(String stdZip5);

    // Used haversine formula for find distance b/w two points on sphere
    @Query("SELECT zl FROM ZipLocation zl WHERE zl.stdZip5 <> ?1 AND (6371 * 2 * ASIN(SQRT(POWER(SIN(RADIANS(?2 - zl.latitude) / 2), 2) + COS(RADIANS(?2)) * COS(RADIANS(zl.latitude)) * POWER(SIN(RADIANS(?3 - zl.longitude) / 2), 2)))) <= ?4")
    List<ZipLocation> NearbyCodes(String centerZipcode, Double centerZipcodeLatitude, Double centerZipcodeLongitude,
                                  Integer radiusInKm);
}

