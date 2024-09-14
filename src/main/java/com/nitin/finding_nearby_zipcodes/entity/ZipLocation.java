package com.nitin.finding_nearby_zipcodes.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ZipLocation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String stdZip5;
    private String uspsZipPrefCity;
    private String uspsZipPrefState;
    private Double latitude;
    private Double longitude;
    private Double x;
    private Double y;
}

