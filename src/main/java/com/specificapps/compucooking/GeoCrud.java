package com.specificapps.compucooking;

import com.specificapps.compucooking.entities.Geo;
import com.specificapps.compucooking.entities.Point;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mark on 11/13/18.
 */
public class GeoCrud {

    EntityManagerFactory emf;
    EntityManager em;

    public GeoCrud(){
        emf = Persistence.createEntityManagerFactory("RecipeService");
        em = emf.createEntityManager();
    }


    public void  createGeoPoints(){

        em.getTransaction().begin();

        Geo geo = new Geo();

        geo.setShapeName("Square");

        List<Point> points = new ArrayList<>();
        Point p1 = new Point();
        p1.setX(1);
        p1.setY(2);
        points.add(p1);

        Point p2 = new Point();
        p2.setX(3);
        p2.setY(4);
        points.add(p2);


        geo.setPoints(points);

        em.persist(geo);


        em.getTransaction().commit();
    }



}
