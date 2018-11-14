package com.specificapps.compucooking.entities;

import javax.persistence.*;
import java.util.List;

/**
 * Created by mark on 11/13/18.
 */

@Entity
public class Point {

    @Id()
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer pointId;

    private Integer x;

    private Integer y;


    /*public List<Geo> getGeos() {
        return geos;
    }

    public void setGeos(List<Geo> geos) {
        this.geos = geos;
    }*/


    public Integer getPointId() {
        return pointId;
    }

    public void setPointId(Integer pointId) {
        this.pointId = pointId;
    }

    public Integer getX() {
        return x;
    }

    public void setX(Integer x) {
        this.x = x;
    }

    public Integer getY() {
        return y;
    }

    public void setY(Integer y) {
        this.y = y;
    }

}


