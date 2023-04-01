package fr.utilisateur.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.lang.Math;

@NoArgsConstructor
@Getter
@Setter

public class GPSLocation{
    private String nom;
    private double longitude;
    private double latitude;
    private final static double RAYON = 637.371;

    public GPSLocation(double latitude, double longitude){
        this.longitude = longitude;
        this.latitude = latitude;
    }
    public double distanceVers(GPSLocation that){
        double lat1 = Math.toRadians(this.latitude);
        double lat2 = Math.toRadians(that.getLatitude());
        double long1 = Math.toRadians(this.longitude);
        double long2 = Math.toRadians(that.getLongitude());

        double angle = Math.acos(Math.sin(lat1) * Math.sin(lat2)
                               + Math.cos(lat1) * Math.cos(lat2) * Math.cos(long1 - long2));
                               
        return RAYON * 2 * Math.atan2(Math.sqrt(angle), Math.sqrt(1-angle));
    }

}
