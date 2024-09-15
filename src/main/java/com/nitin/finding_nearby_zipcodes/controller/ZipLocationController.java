package com.nitin.finding_nearby_zipcodes.controller;

import com.nitin.finding_nearby_zipcodes.entity.ZipLocation;
import com.nitin.finding_nearby_zipcodes.service.ZiplocationService;
import com.nitin.finding_nearby_zipcodes.utils.CsvUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@CrossOrigin
@RestController
@Slf4j
public class ZipLocationController {

    @Autowired
    private ZiplocationService zipLocationService;

    @PostMapping("/uploadFile")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            return ResponseEntity.badRequest().body("Please select a file to upload");
        }

        try {
            List<ZipLocation> zipLocations = CsvUtils.parseCsvFile(file.getInputStream());
            zipLocations.forEach(zipLocationService::saveZipLocation);
            log.info("ziplocation data: {}", zipLocations);
            return ResponseEntity.ok("File uploaded and processed successfully");
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An error occurred while processing the file");
        }
    }

    @GetMapping("/{stdZip5}")
    @Cacheable("zipcode")
    public ResponseEntity<Object> getDataByZipcode(@PathVariable String stdZip5) {
        ZipLocation data = zipLocationService.getDataByZipcode(stdZip5);
        if (data != null) {
            return ResponseEntity.ok(data);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Data for zipcode '" + stdZip5 + "' not found.");
        }
    }

    @GetMapping("/nearbyZipCodes")
    @Cacheable("nearby_zipcode")
    public ResponseEntity<?> getNearbyZipCodes(@RequestParam String zipcode,
                                               @RequestParam(defaultValue = "20") int radius) {
        List<ZipLocation> nearbyZipCodes = zipLocationService.getNearbyZipcodes(zipcode, radius);
        return nearbyZipCodes.isEmpty()
                ? ResponseEntity.status(HttpStatus.NOT_FOUND).body("No zipcodes found nearby " + radius + " Kms")
                : ResponseEntity.ok(nearbyZipCodes);
    }
}
