package com.specificapps.compucooking.entities;

import javax.persistence.*;
import java.util.List;

/**
 * Created by mark on 11/13/18.
 */

@Entity()
public class Geo {

    @Id()
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer geoId;

    private String shapeName;


    @ManyToMany(cascade = CascadeType.PERSIST)
    private  List<Point> points;

    public Integer getGeoId() {
        return geoId;
    }

    public void setGeoId(Integer geoId) {
        this.geoId = geoId;
    }

    public String getShapeName() {
        return shapeName;
    }

    public void setShapeName(String shapeName) {
        this.shapeName = shapeName;
    }
    public List<Point> getPoints() {
        return points;
    }

    public void setPoints(List<Point> points) {
        this.points = points;
    }








}
