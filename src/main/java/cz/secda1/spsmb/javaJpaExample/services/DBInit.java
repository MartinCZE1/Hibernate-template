package cz.secda1.spsmb.javaJpaExample.services;

import cz.secda1.spsmb.javaJpaExample.model.Band;
import cz.secda1.spsmb.javaJpaExample.model.Song;
import org.hibernate.Session;

import java.time.LocalDateTime;

public class DBInit {

    public static void initDB(Session session) {
        Band acdc = new Band();
        acdc.setName("AC/DC");

        Song song1 = new Song();
        song1.setName("Highway to Hell");
        song1.setBand(acdc);
        song1.setCreatedDate(LocalDateTime.now());

        Song song2 = new Song();
        song2.setName("Hell's Bells");
        song2.setBand(acdc);
        song2.setCreatedDate(LocalDateTime.now());

        session.beginTransaction();
        session.persist(acdc);
        session.persist(song1);
        session.persist(song2);
        session.getTransaction().commit();
    }
}
