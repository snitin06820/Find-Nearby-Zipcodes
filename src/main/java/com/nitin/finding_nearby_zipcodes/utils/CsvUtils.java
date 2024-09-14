package com.nitin.finding_nearby_zipcodes.utils;

import com.nitin.finding_nearby_zipcodes.entity.ZipLocation;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CsvUtils {
    public static List<ZipLocation> parseCsvFile(InputStream file) throws IOException {
        List<ZipLocation> zipLocations = new ArrayList<>();
        try (CSVReader csvReader = new CSVReaderBuilder(new InputStreamReader(file)).withSkipLines(1).build()) {
            String[] line;
            while ((line = csvReader.readNext()) != null) {
                if (line.length >= 8) {
                    ZipLocation zipLocation = new ZipLocation();
                    zipLocation.setStdZip5(line[1].trim());
                    zipLocation.setUspsZipPrefCity(line[2].trim());
                    zipLocation.setUspsZipPrefState(line[3].trim());
                    zipLocation.setLatitude(Double.parseDouble(line[4].trim()));
                    zipLocation.setLongitude(Double.parseDouble(line[5].trim()));
                    zipLocation.setX(Double.parseDouble(line[6].trim()));
                    zipLocation.setY(Double.parseDouble(line[7].trim()));
                    zipLocations.add(zipLocation);
                }
            }
        }
        return zipLocations;
    }
}
