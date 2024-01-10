package cz.secda1.spsmb.javaJpaExample;

import cz.secda1.spsmb.javaJpaExample.model.Event;
import cz.secda1.spsmb.javaJpaExample.services.DbFactory;
import cz.secda1.spsmb.javaJpaExample.model.Song;
import org.hibernate.Session;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        DbFactory dbFactory = new DbFactory();
        Session session = dbFactory.getSession();
        session.beginTransaction();
        Event event = new Event();
        event.setTitle("MyEvent");
        session.persist(event);
        session.getTransaction().commit();
    }


    private static List<Song> getSongsByBandName(Session session, String bandName) {
        return session.createQuery("SELECT s from Song s where s.band.name = :bandName", Song.class)
                .setParameter("bandName", bandName).getResultList();
    }

    private static Song getSongById(Session session, Long id) {
        return session.createQuery("SELECT s from Song s where s.id= :id", Song.class)
                .setParameter("id", id).getSingleResult();
    }
}
