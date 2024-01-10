package cz.secda1.spsmb.javaJpaExample.repository;

import cz.secda1.spsmb.javaJpaExample.model.Song;
import jakarta.persistence.NoResultException;
import org.hibernate.NonUniqueResultException;
import org.hibernate.Session;

import java.util.List;
import java.util.Optional;

public class SongRepository {

    public static Optional<Song> getSongById(Session session, long id) {
        Song mySong = null;
        try {
            mySong = session.createQuery("SELECT s from Song s where s.id = :id",Song.class)
                    .setParameter("id",id).getSingleResult();
        }
        catch (NonUniqueResultException | NoResultException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return Optional.ofNullable(mySong);
    }

    public static List<Song> getSongsByBandName(Session session, String bandName) {
        List<Song> filteredSongs = session.createQuery("SELECT s from Song s where s.band.name = :bandName", Song.class)
                .setParameter("bandName", bandName).getResultList();
        return filteredSongs;
    }


}
