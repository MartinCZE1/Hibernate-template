package cz.secda1.spsmb.javaJpaExample.services;

import cz.secda1.spsmb.javaJpaExample.model.*;
import org.hibernate.Session;

import java.time.LocalDateTime;

public class DBInit {

    public static void initDB(Session session) {
        Band acdc = new Band();
        acdc.setName("AC/DC");

        Genre genre1 = new Genre();
        genre1.setName("Pop");

        User user1 = new User();
        user1.setName("Ouyi");

        Song song1 = new Song();
        song1.setName("Highway to Hell");
        song1.setBand(acdc);
        song1.setCreatedDate(LocalDateTime.now());
        song1.setGenre(genre1);

        Rating rating = new Rating();
        rating.setRating(1);
        rating.setLocalDate(LocalDateTime.now());

        Song song3 = new Song();
        song3.setName("Xua Hua Piao Piao");
        song3.getUsers().add(user1);
        user1.getSongs().add(song3);
        song3.getRatings().add(rating);
        rating.setSong(song3);


        Song song2 = new Song();
        song2.setName("Hell's Bells");
        song2.setBand(acdc);
        song2.setCreatedDate(LocalDateTime.now());

        session.beginTransaction();
        session.persist(rating);
        session.persist(genre1);
        session.persist(user1);
        session.persist(acdc);
        session.persist(song1);
        session.persist(song2);
        session.persist(song3);
        session.getTransaction().commit();
    }
}
